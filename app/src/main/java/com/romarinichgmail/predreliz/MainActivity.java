package com.romarinichgmail.predreliz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.romarinichgmail.predreliz.Fragment.FragmentMap;
import com.romarinichgmail.predreliz.Fragment.FragmentMessenger;
import com.romarinichgmail.predreliz.Fragment.FragmentOrder;
import com.romarinichgmail.predreliz.Fragment.FragmentProfile;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentMap()).commit();
            setTitle("Карта");
            navigationView.setCheckedItem(R.id.nav_map);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_map:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentMap()).commit();
                setTitle("Карта");
                break;
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentMessenger()).commit();
                setTitle("Сообщения");
                break;
            case R.id.nav_order_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentOrder()).commit();
                setTitle("Заказы");
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentProfile()).commit();
                setTitle("Мой профиль");
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}



