package ru.savchenko.andrey.deliveryman.fragments.actual;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.adapters.ActualAdapter;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.activities.oneorder.OneOrderActivity;
import ru.savchenko.andrey.deliveryman.entities.Order;
import ru.savchenko.andrey.deliveryman.fragments.actual.di.ActualComponent;
import ru.savchenko.andrey.deliveryman.fragments.actual.di.ActualModule;
import ru.savchenko.andrey.deliveryman.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryman.interfaces.OnSearch;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 25.09.2017.
 */

public class ActualFragment extends BaseFragment implements ActualView, OnItemClickListener, OnSearch{
    @Inject ActualPresenter presenter;
    @BindView(R.id.rvActual)RecyclerView rvActual;
    @BindString(R.string.current_orders)String current;
    private ActualAdapter adapter = new ActualAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.actual_orders, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ActualComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new ActualModule(this))).inject(this);
        ButterKnife.bind(this, view);
        presenter.setOrders();
        setToolbarTitle(current);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.getComponentManager().releaseComponent(getClass());
    }

    @Override
    public void setOrdersList(List<Order> ordersList) {
        Log.i(TAG, "setOrdersList: " + ordersList.size());
        rvActual.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setDataList(ordersList);
        adapter.setClickListener(this);
        rvActual.setAdapter(adapter);
        rvActual.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onClick(int position) {
        startActivity(new Intent(getActivity(), OneOrderActivity.class));
    }

    @Override
    public void search(String search) {
        presenter.onSearch(search);
    }

    @Override
    public void setSearchedList(List<Order> orders) {
        adapter.setDataList(orders);
        adapter.notifyDataSetChanged();
    }
}
