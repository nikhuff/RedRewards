package eventswithred.com.redrewards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by andrew on 6/21/17.
 */

public class StoreItemAdapter extends ArrayAdapter<StoreItem> {

    public StoreItemAdapter(Context context, ArrayList<StoreItem> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        StoreItem SItem = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sample_item_list1, parent, false);
        }

        // Lookup view for data population
        TextView Name = (TextView) convertView.findViewById(R.id.ItemName);
        TextView Desc = (TextView) convertView.findViewById(R.id.ItemDesc);

        // Populate the data into the template view using the data object
        Name.setText(SItem.name);
        Desc.setText(SItem.description);

        // Return the completed view to render on screen
        return convertView;
    }
}
