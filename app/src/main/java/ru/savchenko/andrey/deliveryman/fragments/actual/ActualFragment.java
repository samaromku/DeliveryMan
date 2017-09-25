package ru.savchenko.andrey.deliveryman.fragments.actual;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.adapters.ActualAdapter;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.entities.Order;
import ru.savchenko.andrey.deliveryman.interfaces.OnItemClickListener;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 25.09.2017.
 */

public class ActualFragment extends BaseFragment implements ActualView, OnItemClickListener{
    @InjectPresenter ActualPresenter presenter;
    @BindView(R.id.rvActual)RecyclerView rvActual;
    private ActualAdapter adapter = new ActualAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.actual_orders, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presenter.init();
        presenter.setOrders();
    }


    @Override
    public void setOrdersList(List<Order> ordersList) {
        Log.i(TAG, "setOrdersList: " + ordersList.size());
        rvActual.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setDataList(ordersList);
        adapter.setClickListener(this);
        rvActual.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        Log.i(TAG, "onClick: " + position);
    }
}
