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
    @BindView(R.id.tvName)TextView tvName;
    @BindView(R.id.tvStatus)TextView tvStatus;
    @BindView(R.id.tvPost)TextView tvPost;
    @BindView(R.id.tvMadePerDay)TextView tvMadePerDay;
    @BindView(R.id.tvOnHands)TextView tvOnHands;
    @BindView(R.id.tvMiddleTime)TextView tvMiddleTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        tvName.append("Аркадий");
        tvStatus.append("Малыш на драйве");
        tvPost.append("Курьер");
        tvMadePerDay.append("15 заказов");
        tvOnHands.append("3 заказа");
        tvMiddleTime.append("27 минут");
        Picasso.with(getActivity()).load("http://i.imgur.com/0JTbWMn.jpg").transform(new CircleTransform()).into(ivPhoto);
    }
}
