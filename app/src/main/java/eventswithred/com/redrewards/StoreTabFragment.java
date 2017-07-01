package eventswithred.com.redrewards;

import android.content.SharedPreferences;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
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
        productList.add(new StoreProduct(R.drawable.red2, "RED T-Shirt", "A Standard RED T-Shirt", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 2", "This is description 2", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 3", "This is description 3", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 4", "This is description 4", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 5", "This is description 5", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 6", "This is description 6", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 7", "This is description 7", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 8", "This is description 8", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 9", "This is description 9", 10));
        productList.add(new StoreProduct(R.drawable.red2, "Title 10", "This is description 10", 10));

        return productList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
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

