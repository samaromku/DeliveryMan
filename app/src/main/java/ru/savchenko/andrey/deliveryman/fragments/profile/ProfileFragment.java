package ru.savchenko.andrey.deliveryman.fragments.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.view.CircleTransform;

/**
 * Created by Andrey on 25.09.2017.
 */

public class ProfileFragment extends BaseFragment implements ProfileView {
    @BindView(R.id.ivPhoto)ImageView ivPhoto;
    @BindView(R.id.card_view_name)View cardViewName;
    @BindView(R.id.card_view_status)View card_view_status;
    @BindView(R.id.card_view_post)View card_view_post;
    @BindView(R.id.card_view_for_day)View card_view_for_day;
    @BindView(R.id.card_view_having)View card_view_having;
    @BindView(R.id.card_view_middle_time)View card_view_middle_time;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Picasso.with(getActivity())
                .load("http://i.imgur.com/0JTbWMn.jpg")
                .into(ivPhoto);

        setNameValueByCardViewName("Имя", "Аркадий", cardViewName);
        setNameValueByCardViewName("Статус", "Малыш на драйве", card_view_status);
        setNameValueByCardViewName("Должность", "Курьер", card_view_post);
        setNameValueByCardViewName("Сделано за день", "15 заказов", card_view_for_day);
        setNameValueByCardViewName("Заказов на руках", "3 заказа", card_view_having);
        setNameValueByCardViewName("Среднее время", "27 минут", card_view_middle_time);
    }

    private void setNameValueByCardViewName(String name, String value, View cardView){
        TextView tvName = cardView.findViewById(R.id.tvName);
        TextView tvValue = cardView.findViewById(R.id.tvValue);
        tvName.setText(name);
        tvValue.setText(value);
    }
}
