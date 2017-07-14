package eventswithred.com.redrewards;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SocialMediaTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.social_media_tab_fragment, container, false);
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.pager);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        return view;

    }


    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * used to get what fragment to display when selected
         * @param position
         * @return fragment
         */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TwitterTabFragment();
                default:
                    return new FacebookTabFragment();
            }

        }

        /**
         *
         * @return nomber of tabs that are needed to be shown on the tab fragment
         */
        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }


        /**
         *
         * @param position
         * @return the string to be shown on the tab
         */
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Twitter";
                default:
                    return "Facebook";
            }
        }


    }
}