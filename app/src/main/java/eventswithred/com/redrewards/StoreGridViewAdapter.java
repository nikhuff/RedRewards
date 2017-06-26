package eventswithred.com.redrewards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class StoreGridViewAdapter extends ArrayAdapter<StoreProduct> {
    public StoreGridViewAdapter(Context context, int resource, List<StoreProduct> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(null == v) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.store_grid_item, null);
        }
        StoreProduct product = getItem(position);
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        TextView txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        //TextView txtDescription = (TextView) v.findViewById(R.id.txtDescription);
        TextView txtCost = (TextView) v.findViewById(R.id.txtCost);

        img.setImageResource(product.getImageId());
        txtTitle.setText(product.getTitle());
        //txtDescription.setText(product.getDescription());
        txtCost.setText("cost: " + product.getCost());

        return v;
    }
}
