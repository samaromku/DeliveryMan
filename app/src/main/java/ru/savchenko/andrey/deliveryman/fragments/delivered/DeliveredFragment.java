package ru.savchenko.andrey.deliveryman.fragments.delivered;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.adapters.ActualAdapter;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.entities.Order;
import ru.savchenko.andrey.deliveryman.fragments.delivered.di.DeliveredComponent;
import ru.savchenko.andrey.deliveryman.fragments.delivered.di.DeliveredModule;

public class DeliveredFragment extends BaseFragment implements DeliveredView {
    private static final String TAG = DeliveredFragment.class.getSimpleName();
    @Inject
    DeliveredPresenter presenter;

    @BindView(R.id.rvOrder)
    RecyclerView rvOrder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((DeliveredComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new DeliveredModule(this))).inject(this);
        return inflater.inflate(R.layout.fragment_delivered, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setToolbarTitle("Доставленные");
        presenter.getListFroAdapter();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        App.getComponentManager().releaseComponent(getClass());
    }

    @Override
    public void setListToAdapter(List<Order> listToAdapter) {
        ActualAdapter adapter = new ActualAdapter();
        adapter.setDataList(listToAdapter);
        adapter.setClickListener(position -> {
            Log.i(TAG, "setListToAdapter: " + position);
        });
        rvOrder.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrder.setAdapter(adapter);
        rvOrder.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
    }
}
