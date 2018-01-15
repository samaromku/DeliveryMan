package ru.savchenko.andrey.deliveryman.fragments.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.fragments.profile.di.ProfileUserComponent;
import ru.savchenko.andrey.deliveryman.fragments.profile.di.ProfileUserModule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import static ru.savchenko.andrey.deliveryman.storage.Utils.setNameValueByCardViewName;

public class ProfileUserFragment extends BaseFragment implements ProfileUserView {
    private static final String TAG = ProfileUserFragment.class.getSimpleName();
    @Inject
    ProfileUserPresenter presenter;
    @BindView(R.id.ivPhoto)ImageView ivPhoto;
    @BindView(R.id.card_view_name)View cardViewName;
    @BindView(R.id.card_view_status)View card_view_status;
    @BindView(R.id.card_view_post)View card_view_post;
    @BindView(R.id.card_view_for_day)View card_view_for_day;
    @BindView(R.id.card_view_having)View card_view_having;
    @BindView(R.id.card_view_middle_time)View card_view_middle_time;
    @BindView(R.id.btnEditPhoto)FloatingActionButton fabEdit;
    @OnClick(R.id.btnEditPhoto)
    void onEditClick(){
        fabEdit.setImageResource(R.drawable.ic_check);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((ProfileUserComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new ProfileUserModule(this))).inject(this);
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setToolbarTitle("Профиль");
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

    @Override
    public void onDetach() {
        super.onDetach();
        App.getComponentManager().releaseComponent(getClass());
    }

}
