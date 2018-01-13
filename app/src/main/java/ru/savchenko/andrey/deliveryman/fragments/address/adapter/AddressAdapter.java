package ru.savchenko.andrey.deliveryman.fragments.address.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseAdapter;
import ru.savchenko.andrey.deliveryman.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryman.entities.Address;

public class AddressAdapter extends BaseAdapter<Address> {
    @Override
    public BaseViewHolder<Address> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address, parent, false);
        return new AddressViewHolder(view);
    }

    class AddressViewHolder extends BaseViewHolder<Address> {

        AddressViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
