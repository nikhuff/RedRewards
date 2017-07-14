package eventswithred.com.redrewards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class singleItemActivity extends AppCompatActivity {
    private User user = User.getUserInstance();
    private int points = user.getPoints();
    private StoreProduct SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_single_item_view);

        // Get the Intent that started this activity and extract the string
        Log.d("intent", "getting intent...");
        Intent intent = getIntent();
        Log.d("intent", "intent received...");
        SP = (StoreProduct)intent.getSerializableExtra("product");

        String log_message = "Received intent with " + SP.getTitle();
        Log.d("intent_created", log_message);

        // Capture the layout's TextView and set the string as its text
        ImageView img = (ImageView) findViewById(R.id.imageView);
        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) findViewById(R.id.txtDescription);
        TextView txtCost = (TextView) findViewById(R.id.txtCost);

        img.setImageResource(SP.getImageId());
        txtTitle.setText(SP.getTitle());
        txtDescription.setText(SP.getDescription());
        txtCost.setText("cost: " + SP.getCost());
    }

    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Button_Redeem) {
            Log.d("Store", "User has requested to redeem points for an item.");
            if (user.canSubtract(SP.getCost()))
            {
                user.subtractPoints(SP.getCost());
                Toast.makeText(this, "" + SP.getCost() + " points has been removed from your account.", Toast.LENGTH_LONG).show();
            }
            else {
                Log.d("Store", "User does not have enough points for an item.");
                Toast.makeText(this, "not enough points", Toast.LENGTH_LONG).show();
            }
        }
    }
}

