package com.example.eventzillauser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Events extends AppCompatActivity {
    private ActionBar toolbar;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        toolbar = getSupportActionBar();
        b1=(Button)findViewById(R.id.EventBtn);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation1);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Events.this,showevent.class);
                startActivity(intent);
            }
        });

        toolbar.setTitle("Home");
        loadFragment(new Home());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_categories:
                    toolbar.setTitle("Event");
                    fragment = new Home();
                    Intent a = new Intent(Events.this,Events.class);
                    startActivity(a);
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_faculty:
                    toolbar.setTitle("Categories");
                    fragment = new Categories();
                   Intent a1 = new Intent(Events.this,Browse_Category.class);
                    startActivity(a1);
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_profile:
                    toolbar.setTitle("My Profile");
                    fragment = new Profile();
                    Intent a2 = new Intent(Events.this,ProfileActivity.class);
                    startActivity(a2);
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };



    private void loadFragment(Fragment fragment) {
        // load fragment
        Fragment newFragment = new Fragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack
        transaction.replace(R.id.container, newFragment);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }
}
