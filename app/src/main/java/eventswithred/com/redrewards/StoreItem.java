package eventswithred.com.redrewards;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


//https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView

public class StoreItem{
    String name;
    String description;
    int price;
    boolean inStock;
    Image itemImage;

    public StoreItem(String NAME, String DESC){
    }
}
/*static class ViewHolder {
  TextView text;
  TextView timestamp;
  ImageView icon;
  ProgressBar progress;
  int position;
}*/