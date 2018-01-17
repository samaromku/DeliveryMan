package ru.savchenko.andrey.deliveryman.fragments.curiers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import butterknife.BindString;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.entities.Courier;
import ru.savchenko.andrey.deliveryman.fragments.curiers.di.CuriersComponent;
import ru.savchenko.andrey.deliveryman.fragments.curiers.di.CuriersModule;

import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.support.v7.widget.LinearLayoutManager;

import ru.savchenko.andrey.deliveryman.fragments.curiers.adapter.CurierAdapter;
import ru.savchenko.andrey.deliveryman.interfaces.OnSearch;

import java.util.List;

import android.util.Log;

import javax.inject.Inject;

public class CuriersFragment extends BaseFragment implements CuriersView, OnSearch {
    private static final String TAG = CuriersFragment.class.getSimpleName();
    @Inject
    CuriersPresenter presenter;

    @BindView(R.id.rvCurier)
    RecyclerView rvCurier;
    @BindString(R.string.couriers)String couriers;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((CuriersComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new CuriersModule(this))).inject(this);
        return inflater.inflate(R.layout.fragment_curiers, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presenter.getListFroAdapter();
        setToolbarTitle(couriers);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        App.getComponentManager().releaseComponent(getClass());
    }

    @Override
    public void setListToAdapter(List<Courier> listToAdapter) {
        CurierAdapter adapter = new CurierAdapter();
        adapter.setDataList(listToAdapter);
        adapter.setClickListener(position -> {
            Log.i(TAG, "setListToAdapter: " + position);
        });
        rvCurier.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCurier.setAdapter(adapter);
        rvCurier.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
    }

    @Override
    public void search(String search) {
        Log.i(TAG, "search: " + search);
    }
}
