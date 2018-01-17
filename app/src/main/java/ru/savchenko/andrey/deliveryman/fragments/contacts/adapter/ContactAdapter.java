package ru.savchenko.andrey.deliveryman.fragments.contacts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseAdapter;
import ru.savchenko.andrey.deliveryman.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryman.entities.Contact;
import ru.savchenko.andrey.deliveryman.interfaces.OnItemClickListener;

public class ContactAdapter extends BaseAdapter<Contact> {
    @Override
    public BaseViewHolder<Contact> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }
    class ContactViewHolder extends BaseViewHolder<Contact> {
        @BindView(R.id.tvName)TextView tvName;
        @BindView(R.id.tvAddress)TextView tvAddress;
        @BindView(R.id.tvPhone)TextView tvPhone;
        @BindView(R.id.tvEmail)TextView tvEmail;


        ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(Contact contact, OnItemClickListener clickListener) {
            super.bind(contact, clickListener);
            tvName.setText(contact.getName());
            tvAddress.setText(contact.getAddress().getAddress());
            tvPhone.setText(contact.getPhone());
            tvEmail.setText(contact.getEmail());
        }
    }
}