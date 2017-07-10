package eventswithred.com.redrewards;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class StoreTabFragment extends ListFragment implements AdapterView.OnItemClickListener {
    private StoreListViewAdapter listViewAdapter;
    private List<StoreProduct> productList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.store_tab_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getProductList();
        setAdapters();
        getListView().setOnItemClickListener(this);
    }

    private void setAdapters() {
            listViewAdapter = new StoreListViewAdapter(this.getContext(), R.layout.store_list_item, productList);
            this.setListAdapter(listViewAdapter);

    }

    public List<StoreProduct> getProductList() {
        //pseudo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        productList.add(new StoreProduct(R.drawable.redtshirt, "RED T-Shirt", "A Standard RED T-Shirt", 100));
        productList.add(new StoreProduct(R.drawable.redhat, "RED Hat", "A Standard RED hat", 150));
        productList.add(new StoreProduct(R.drawable.ticketssample, "RED tickets", "A ticket for a RED event", 500));
        productList.add(new StoreProduct(R.drawable.logo_wide, "Title 4", "This is description 4", 20));
        productList.add(new StoreProduct(R.drawable.logo_wide, "Title 5", "This is description 5", 1));
        productList.add(new StoreProduct(R.drawable.logo_wide, "Title 6", "This is description 6", 5));
        return productList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent viewItem = new Intent(super.getActivity(), singleItemActivity.class);
        Log.d("intent_creation", "sending item " + position );
        viewItem.putExtra("product", productList.get(position));
        Log.d("intent_creation", "item possibly placed...starting activity...");
        startActivity(viewItem);
        //Toast.makeText(getActivity(), "Item: " + productList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }
}

/*
// Using an AsyncTask to load the slow images in a background thread
new AsyncTask<ViewHolder, Void, Bitmap>() {
        private ViewHolder v;

        @Override
        protected Bitmap doInBackground(ViewHolder... params) {
            v = params[0];
            return mFakeImageLoader.getImage();
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            if (v.position == position) {
                // If this item hasn't been recycled already, hide the
                // progress and set and show the image
                v.progress.setVisibility(View.GONE);
                v.icon.setVisibility(View.VISIBLE);
                v.icon.setImageBitmap(result);
            }
        }
    }.execute(holder);
*/

