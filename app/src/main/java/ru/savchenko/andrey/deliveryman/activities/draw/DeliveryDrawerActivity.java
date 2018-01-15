package ru.savchenko.andrey.deliveryman.activities.draw;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding2.widget.RxTextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.activities.draw.di.MainComponent;
import ru.savchenko.andrey.deliveryman.activities.draw.di.MainModule;
import ru.savchenko.andrey.deliveryman.activities.neworder.NewOrderActivity;
import ru.savchenko.andrey.deliveryman.base.BaseActivity;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualFragment;
import ru.savchenko.andrey.deliveryman.fragments.curiers.CuriersFragment;
import ru.savchenko.andrey.deliveryman.fragments.delivered.DeliveredFragment;
import ru.savchenko.andrey.deliveryman.fragments.profile.ProfileUserFragment;
import ru.savchenko.andrey.deliveryman.interfaces.OnChangeTitle;
import ru.savchenko.andrey.deliveryman.network.DeliveryNetworkService;

public class DeliveryDrawerActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnChangeTitle {
    @Inject
    DeliveryNetworkService deliveryNetworkService;

    public static final String TAG = DeliveryDrawerActivity.class.getSimpleName();
    @BindView(R.id.search_toolbar) Toolbar searchToolbar;
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.etSearch)EditText etSearch;
    @OnClick(R.id.ivBack)
    void onBackClick(){
        backClick();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_drawer);
        ButterKnife.bind(this);
        ((MainComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new MainModule())).inject(this);

        setSupportActionBar(toolbar);

        deliveryNetworkService.getAddresses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(addresses -> Log.i(TAG, "onCreate: " + addresses), Throwable::printStackTrace);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        LinearLayout llProfileInfo = navigationView.getHeaderView(0).findViewById(R.id.llProfileInfo);
        llProfileInfo.setOnClickListener(view -> openFragment(new ProfileUserFragment()));

        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_actual));
        RxTextView.afterTextChangeEvents(etSearch)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(textViewAfterTextChangeEvent -> {
                    Log.i(TAG, "onCreate: " + getSupportFragmentManager().getFragments().get(0));
                });
    }

    private void backClick(){
        toolbar.setVisibility(View.VISIBLE);
        searchToolbar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(searchToolbar.getVisibility()==View.VISIBLE){
            backClick();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delivery_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_search) {
            openToolbarSearch();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openToolbarSearch() {
        toolbar.setVisibility(View.GONE);
        searchToolbar.setVisibility(View.VISIBLE);
        etSearch.requestFocus();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_actual:
                return openFragment(new ActualFragment());
            case R.id.nav_delivered:
                return openFragment(new DeliveredFragment());
            case R.id.nav_curiers:
                return openFragment(new CuriersFragment());
            case R.id.nav_new_order:
                startActivity(new Intent(this, NewOrderActivity.class));
                return true;
            default:
                return true;
        }
    }

    private boolean openFragment(BaseFragment fragment) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        fragment.setOnChangeTitle(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
        return true;
    }

//    private boolean closeDrawer(){
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    @Override
    public void changeTitle(@StringRes int title) {
        changeToolbarTitle(title);
    }
}
