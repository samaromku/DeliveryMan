package ru.savchenko.andrey.deliveryman.fragments.address;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import ru.savchenko.andrey.deliveryman.entities.Address;
import ru.savchenko.andrey.deliveryman.fragments.address.adapter.AddressAdapter;
import ru.savchenko.andrey.deliveryman.fragments.address.di.AddressesComponent;
import ru.savchenko.andrey.deliveryman.fragments.address.di.AddressesModule;

public class AddressesFragment extends Fragment implements AddressesView {
    private static final String TAG = AddressesFragment.class.getSimpleName();
    @Inject
    AddressesPresenter presenter;

    @BindView(R.id.rvAddress)
    RecyclerView rvAddress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AddressesComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new AddressesModule(this))).inject(this);
        return inflater.inflate(R.layout.fragment_addresses, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presenter.getListFroAdapter();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        App.getComponentManager().releaseComponent(getClass());
    }

    @Override
    public void setListToAdapter(List<Address> listToAdapter) {
        AddressAdapter adapter = new AddressAdapter();
        adapter.setDataList(listToAdapter);
        adapter.setClickListener(position -> {
            Log.i(TAG, "setListToAdapter: " + position);
        });
        rvAddress.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAddress.setAdapter(adapter);
    }
}
