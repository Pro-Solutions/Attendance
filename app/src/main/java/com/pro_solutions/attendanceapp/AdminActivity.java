package com.pro_solutions.attendanceapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class AdminActivity extends MenuActivity implements NavigationView.OnNavigationItemSelectedListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        Toolbar toolbar = (Toolbar) findViewById(R.id.adminToolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.adminContainer);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.adminTabs);
        tabLayout.setupWithViewPager(mViewPager);

        drawerLayout=(DrawerLayout)findViewById(R.id.adminDrawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        final Animation frotate;
        frotate= AnimationUtils.loadAnimation(this,R.anim.rotate_forward);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.adminFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fab.startAnimation(frotate);

                Thread thread=new Thread()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            sleep(500);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();

                        }
                        finally
                        {
                            startActivity(new Intent(AdminActivity.this,StudentChatActivity.class));
                        }

                    }
                };
                thread.start();

            }
        });

        navigationView = (NavigationView) findViewById(R.id.adminSideNavigationMenu);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.sideNavMenuShare)
        {
            Toast.makeText(this, "Share menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ShareActivity.class));
        }
        else if (id == R.id.sideNavMenuSettings)
        {
            Toast.makeText(this, "Settings menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SettingsActivity.class));
        }
        else if (id == R.id.sideNavMenuAttach)
        {
            Toast.makeText(this, "Info menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AboutUsActivity.class));
        }
        else if (id == R.id.sideNavMenuLogout)
        {
            Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.sideNavMenudashboard)
        {
            Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.sideNavMenuhome)
        {
            Toast.makeText(this, "HOME", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

/*
    *//**
     * A placeholder fragment containing a simple view.
     *//*
    public static class PlaceholderFragment extends Fragment {
        *//**
         * The fragment argument representing the section number for this
         * fragment.
         *//*
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        *//**
         * Returns a new instance of this fragment for the given section
         * number.
         *//*
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.admin_tab1, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }*/

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position) {
                case 0:
                    AdminTab1_Activity Admin_tab_activity1=new AdminTab1_Activity();
                    return Admin_tab_activity1;
                case 1:
                    AdminTab2_Activity Admin_tab_activity2=new AdminTab2_Activity();
                    return Admin_tab_activity2;
                case 2:
                    AdminTab3_Activity Admin_tab_activity3=new AdminTab3_Activity();
                    return Admin_tab_activity3;
                default:
                    return null;
            }

//            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:

                    return "ADMIN TAB 1";
                case 1:
                    return "ADMIN TAB 2";
                case 2:
                    return "IMS NOIDA";
            }
            return null;
        }
    }
}
