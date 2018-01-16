package ru.savchenko.andrey.deliveryman.activities.draw;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

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
import ru.savchenko.andrey.deliveryman.interfaces.OnSearch;
import ru.savchenko.andrey.deliveryman.network.DeliveryNetworkService;

public class DeliveryDrawerActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnChangeTitle {
    @Inject
    DeliveryNetworkService deliveryNetworkService;

    public static final String TAG = DeliveryDrawerActivity.class.getSimpleName();
    private ActionBarDrawerToggle toggle;
    @BindView(R.id.search_toolbar) Toolbar searchToolbar;
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.etSearch)EditText etSearch;
    @OnClick(R.id.ivBack)
    void onBackClick(){
        backClick();
    }
    @OnClick(R.id.ivClose)
    void onCloseClick(){
        etSearch.setText("");
    }
    private BaseFragment baseFragment;

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
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                Log.i(TAG, "onDrawerSlide: ");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.i(TAG, "onDrawerOpened: ");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.i(TAG, "onDrawerClosed: ");
                baseFragment.setOnChangeTitle(DeliveryDrawerActivity.this);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, baseFragment)
                        .commit();
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.i(TAG, "onDrawerStateChanged: ");
            }
        };
        drawer.addDrawerListener(drawerListener);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        LinearLayout llProfileInfo = navigationView.getHeaderView(0).findViewById(R.id.llProfileInfo);
        llProfileInfo.setOnClickListener(view -> openFragment(new ProfileUserFragment()));

        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_actual));
        RxTextView.textChanges(etSearch)
                .debounce(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(text -> {
                    if(!getSupportFragmentManager().getFragments().isEmpty()) {
                        Fragment fragment = getSupportFragmentManager().getFragments().get(0);
                        if (fragment instanceof OnSearch) {
                            OnSearch onSearch = (OnSearch) fragment;
                            onSearch.search(text.toString());
                        }
                    }
                });
    }

    private void backClick(){
        toolbar.setVisibility(View.VISIBLE);
        searchToolbar.setVisibility(View.GONE);
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Service.INPUT_METHOD_SERVICE);
        if(imm!=null)
        imm.hideSoftInputFromWindow(etSearch.getWindowToken(), 0);
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
        InputMethodManager keyboard = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if(keyboard!=null) {
            keyboard.showSoftInput(etSearch, 0);
        }
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
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        baseFragment = fragment;
        return true;
    }

    @Override
    public void changeTitle(@StringRes int title) {
        changeToolbarTitle(title);
    }
}
