package eventswithred.com.redrewards;

import android.app.ListActivity;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

public class StoreTabFragment extends ListFragment implements AdapterView.OnItemClickListener {

    //SITE THAT PROVIDED CODE TO FINALLY GET A LIST TO SHOW
    //https://www.tutorialspoint.com/android/android_list_fragment.htm

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_tab_content, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }



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
