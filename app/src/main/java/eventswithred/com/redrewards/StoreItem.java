package eventswithred.com.redrewards;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.widget.SimpleCursorAdapter;

/**
 * Created by nik on 6/7/17.
 */

public class StoreItem extends SimpleCursorAdapter{
    private String name;
    private String description;
    private int price;
    boolean inStock;
    Image itemImage;

    public StoreItem(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }
}
