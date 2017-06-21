package eventswithred.com.redrewards;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class StoreTabFragment extends ListFragment implements AdapterView.OnItemClickListener {

   // StoreItem holder = new StoreItem();
    //holder.itemImage = (ImageView) convertView.findViewById(R.id.listitem_image);
    //holder.text = (TextView) convertView.findViewById(R.id.listitem_text);
    //holder.timestamp = (TextView) convertView.findViewById(R.id.listitem_timestamp);
    //holder.progress = (ProgressBar) convertView.findViewById(R.id.progress_spinner);
//convertView.setTag(holder);


    //working with ListView
    //https://developer.android.com/training/improving-layouts/smooth-scrolling.html
    //https://developer.android.com/reference/android/widget/ListView.html

    //filling and designing a layout
    //https://developer.android.com/guide/topics/ui/declaring-layout.html#FillingTheLayout

    //layout class
    //  https://developer.android.com/reference/android/R.layout.html
    //  int list_content
    //  Standard content view for a ListFragment. If you are implementing a subclass of ListFragment
    // with your own customized content, you can include this layout in that content to still retain
    // all of the standard functionality of the base class.



    //SITE THAT PROVIDED CODE TO FINALLY GET A LIST TO SHOW
    //https://www.tutorialspoint.com/android/android_list_fragment.htm

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_tab_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("storeFragment","loading the array adapter");
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
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
        // link to get started with listing the store items
        // https://developer.android.com/guide/topics/ui/layout/listview.html

        //other links:
        //https://stackoverflow.com/questions/12077955/android-using-simplecursoradapter-to-get-data-from-database-to-listview
        //https://developer.android.com/reference/android/support/v4/app/ListFragment.html
        //https://developer.android.com/reference/android/widget/SimpleCursorAdapter.html
        //https://developer.android.com/reference/android/app/ListFragment.html
        //https://developer.android.com/guide/topics/ui/declaring-layout.html#AdapterViews
        //https://developer.android.com/guide/topics/ui/layout/listview.html
        //https://thinkandroid.wordpress.com/2010/01/09/simplecursoradapters-and-listviews/

/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.store_tab_fragment, container, false);
    }*/


}
