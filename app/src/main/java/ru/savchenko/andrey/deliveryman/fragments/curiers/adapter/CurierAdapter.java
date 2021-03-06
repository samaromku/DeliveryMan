package ru.savchenko.andrey.deliveryman.fragments.curiers.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseAdapter;
import ru.savchenko.andrey.deliveryman.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryman.entities.Courier;
import ru.savchenko.andrey.deliveryman.interfaces.OnItemClickListener;

import static ru.savchenko.andrey.deliveryman.storage.Utils.setNameValueByCardViewName;

public class CurierAdapter extends BaseAdapter<Courier> {
    @Override
    public BaseViewHolder<Courier> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_curier, parent, false);
        return new CurierViewHolder(view);
    }

    class CurierViewHolder extends BaseViewHolder<Courier> {
        @BindView(R.id.card_view_name)View cardViewName;
        @BindView(R.id.card_view_phone)View cardViewPhone;
        @BindView(R.id.card_view_status)View cardViewStatus;
        @BindString(R.string.status)String status;
        @BindString(R.string.phone)String phone;
        @BindString(R.string.name)String name;

        CurierViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(Courier courier, OnItemClickListener clickListener) {
            super.bind(courier, clickListener);
            setNameValueByCardViewName(name, courier.getName(), cardViewName);
            setNameValueByCardViewName(phone, courier.getPhone(), cardViewPhone);
            switch (courier.getStatus()){
                case 0:
                    setNameValueByCardViewName(status, "Отсутствует", cardViewStatus);
                    break;
                case 1:
                    setNameValueByCardViewName(status, "Свободен", cardViewStatus);
                    break;
                case 2:
                    setNameValueByCardViewName(status, "На заказе", cardViewStatus);
                    break;
            }

        }
    }
}
