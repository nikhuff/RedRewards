package eventswithred.com.redrewards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class noDisplayLoginLauncher extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_display_login_launcher);

        mAuth = FirebaseAuth.getInstance();

        //move the logic that sees if a user is already logged in to here <-
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            //a user is already logged in
            Log.d("nodisplay", "a user is already logged in, they have email : " + currentUser.getEmail());
            Intent intent = new Intent(this, LogoutActivity.class);
            startActivity(intent);
        } else {
            Log.d("nodisplay", "No user is logged in yet!");
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }


    }
}
