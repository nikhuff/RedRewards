package eventswithred.com.redrewards;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class singleItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_single_item_view);

        // Get the Intent that started this activity and extract the string
        Log.d("intent", "getting intent...");
        Intent intent = getIntent();
        Log.d("intent", "intent recived...");
        StoreProduct SP = (StoreProduct)intent.getSerializableExtra("product");

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
            Toast.makeText(this, "to be implemented", Toast.LENGTH_LONG).show();
        }
    }
}

