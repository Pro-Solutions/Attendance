package com.pro_solutions.attendanceapp;

import android.content.Intent;
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


public class StudentActivity extends MenuActivity implements NavigationView.OnNavigationItemSelectedListener {

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


    boolean msgcheck=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);


        Toolbar toolbar = (Toolbar) findViewById(R.id.studentToolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.studentContainer);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.studentTabs);
        tabLayout.setupWithViewPager(mViewPager);


        drawerLayout=(DrawerLayout)findViewById(R.id.studentDrawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.studentFab);
        final Animation shake= AnimationUtils.loadAnimation(this,R.anim.shake);
        final Animation frotate= AnimationUtils.loadAnimation(this,R.anim.rotate_forward);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fab.startAnimation(frotate);
                //fab.startAnimation(shake);

                msgcheck=true;
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
                            startActivity(new Intent(StudentActivity.this,StudentChatActivity.class));
                        }

                    }
                };
                thread.start();


                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });


        fab.startAnimation(shake);

        navigationView = (NavigationView) findViewById(R.id.studentSideNavigationMenu);
        navigationView.setNavigationItemSelectedListener(this);


    }



    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id ==R.id.sideNavMenuShare)
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


    /*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.commonmenus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

     /*   return super.onOptionsItemSelected(item);
    }

    *
     * A placeholder fragment containing a simple view.

    public static class PlaceholderFragment extends Fragment {
        *
         * The fragment argument representing the section number for this
         * fragment.

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        *
         * Returns a new instance of this fragment for the given section
         * number.

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
            View rootView = inflater.inflate(R.layout.student_tab1, container, false);
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
                    StudentTab1_Activity Student_tab_activity1=new StudentTab1_Activity();
                    return Student_tab_activity1;
                case 1:
                    StudentTab2_Activity Student_tab_activity2=new StudentTab2_Activity();
                    return Student_tab_activity2;
                case 2:
                    StudentTab3_Activity Student_tab_activity3=new StudentTab3_Activity();
                    return Student_tab_activity3;
                default:
                    return null;
            }

            //return PlaceholderFragment.newInstance(position + 1);
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
                    return "DASHBOARD";
                case 1:
                    return "STATS";
                case 2:
                    return "E-NOTES";
            }
            return null;
        }
    }
}
