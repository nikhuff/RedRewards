package eventswithred.com.redrewards;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nik on 6/11/17.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SocialMediaTabFragment socialMediaTab = new SocialMediaTabFragment();
                return socialMediaTab;
            case 1:
                PointsTabFragment pointsTabFragment = new PointsTabFragment();
                return pointsTabFragment;
            case 2:
                StoreTabFragment storeTabFragment = new StoreTabFragment();
                return storeTabFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount () {
        return mNumOfTabs;
    }
}
