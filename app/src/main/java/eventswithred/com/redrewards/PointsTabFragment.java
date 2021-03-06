package eventswithred.com.redrewards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.view.View.INVISIBLE;

public class PointsTabFragment extends Fragment {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private User user = User.getUserInstance();
    private int points = user.getPoints();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.point_tab_fragment, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        display();
    }

    private void display() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        View v = this.getView();
        TextView pointsDisplay = (TextView) v.findViewById(R.id.tvPointsDisplay);
        TextView userName = (TextView) v.findViewById(R.id.tvUserName);
        if (currentUser != null) {
            //a user is already logged in
            userName.setText(currentUser.getEmail());
            pointsDisplay.setVisibility(View.VISIBLE);
            pointsDisplay.setText("POINTS: " + points);
            Log.d("nodisplay", mAuth.getCurrentUser().getEmail() + " is already logged in!");
        } else {
            //pointsDisplay.setText("Log in to see your points");
            Log.d("nodisplay", "No user is logged in yet!");
            pointsDisplay.setVisibility(INVISIBLE);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        points = user.getPoints();
        display();
    }

    public void onResume() {
        super.onResume();
        display();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            points = user.getPoints();
            display();
        }
    }
}
