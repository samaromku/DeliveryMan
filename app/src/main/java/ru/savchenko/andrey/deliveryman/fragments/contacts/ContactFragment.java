package ru.savchenko.andrey.deliveryman.fragments.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
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
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.entities.Contact;
import ru.savchenko.andrey.deliveryman.fragments.contacts.adapter.ContactAdapter;
import ru.savchenko.andrey.deliveryman.fragments.contacts.di.ContactComponent;
import ru.savchenko.andrey.deliveryman.fragments.contacts.di.ContactModule;

public class ContactFragment extends BaseFragment implements ContactView {
    private static final String TAG = ContactFragment.class.getSimpleName();
    @Inject
    ContactPresenter presenter;

    @BindView(R.id.rvAddress)
    RecyclerView rvAddress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((ContactComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new ContactModule(this))).inject(this);
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
    public void setListToAdapter(List<Contact> listToAdapter) {
        ContactAdapter adapter = new ContactAdapter();
        adapter.setDataList(listToAdapter);
        adapter.setClickListener(position -> {
            Log.i(TAG, "setListToAdapter: " + position);
        });
        rvAddress.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvAddress.setAdapter(adapter);
    }
}
