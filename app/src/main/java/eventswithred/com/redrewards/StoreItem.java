package eventswithred.com.redrewards;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by nik on 6/7/17.
 */

public class StoreItem extends SimpleCursorAdapter{
    TextView name;
    TextView description;
    int price;
    boolean inStock;
    ImageView itemImage;
    int position;

    public StoreItem(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
      super(context, layout, c, from, to, flags);
    }
}
/*static class ViewHolder {
  TextView text;
  TextView timestamp;
  ImageView icon;
  ProgressBar progress;
  int position;
}*/