package ru.savchenko.andrey.deliveryman.activities.draw;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.activities.draw.di.MainComponent;
import ru.savchenko.andrey.deliveryman.activities.draw.di.MainModule;
import ru.savchenko.andrey.deliveryman.activities.neworder.NewOrderActivity;
import ru.savchenko.andrey.deliveryman.base.BaseActivity;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualFragment;
import ru.savchenko.andrey.deliveryman.fragments.profile.ProfileFragment;
import ru.savchenko.andrey.deliveryman.interfaces.OnChangeTitle;
import ru.savchenko.andrey.deliveryman.network.DeliveryNetworkService;

public class DeliveryDrawerActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnChangeTitle {
    @Inject
    DeliveryNetworkService deliveryNetworkService;

    public static final String TAG = DeliveryDrawerActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_drawer);
        ((MainComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new MainModule())).inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_profile));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.delivery_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_new_order) {
            startActivity(new Intent(this, NewOrderActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_actual:
                openFragment(new ActualFragment());
                return closeDrawer(true);
            case R.id.nav_profile:
                openFragment(new ProfileFragment());
                return closeDrawer(true);
            default:
                return closeDrawer(true);
        }
    }

    private void openFragment(BaseFragment fragment){
        fragment.setOnChangeTitle(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    private boolean closeDrawer(boolean isClose){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return isClose;
    }

    @Override
    public void changeTitle(@StringRes int title) {
        changeToolbarTitle(title);
    }
}
