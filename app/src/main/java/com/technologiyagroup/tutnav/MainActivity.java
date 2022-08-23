package com.technologiyagroup.tutnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.technologiyagroup.tutnav.Fragments.AttendanceStatFragment;
import com.technologiyagroup.tutnav.Fragments.Home;
import com.technologiyagroup.tutnav.Fragments.ManageEmployeeFragment;
import com.technologiyagroup.tutnav.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        replaceFragment(new Home(),binding.frame);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.myDrawerLayout, R.string.nav_open, R.string.nav_close);
        binding.myDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        binding.homeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.myDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    binding.myDrawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    binding.myDrawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
        binding.navView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
            replaceFragment(new Home(),binding.frame);
            Toast.makeText(this, "clicked on acct", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.manage_emp) {
            replaceFragment(new ManageEmployeeFragment(),binding.frame);
        } else if (id == R.id.attendace_stat) {
            replaceFragment(new AttendanceStatFragment(),binding.frame);
        }

        binding.myDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment(Fragment fragment,View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(view.getId(), fragment);
        if(fragment instanceof Home)
        {

        }
        else
        {
            fragmentTransaction.addToBackStack(fragment.toString());
        }
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        replaceFragment(new Home(),binding.frame);
    }
}