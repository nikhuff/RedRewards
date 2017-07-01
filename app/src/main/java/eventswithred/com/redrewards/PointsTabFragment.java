package eventswithred.com.redrewards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PointsTabFragment extends Fragment {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.point_tab_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hideItems();
    }

    private void hideItems() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            //a user is already logged in
            Log.d("nodisplay", mAuth.getCurrentUser().getEmail() + " is already logged in!");
        } else {
            Log.d("nodisplay", "No user is logged in yet!");
        }
    }


}
