package ru.savchenko.andrey.deliveryman.fragments.profile;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;

import butterknife.BindString;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import javax.inject.Inject;

import static ru.savchenko.andrey.deliveryman.storage.Utils.hideKeyboard;
import static ru.savchenko.andrey.deliveryman.storage.Utils.setNameValueByCardViewName;
import static ru.savchenko.andrey.deliveryman.storage.Utils.showKeyboard;

public class ProfileUserFragment extends BaseFragment implements ProfileUserView {
    private static final String TAG = ProfileUserFragment.class.getSimpleName();
    @Inject
    ProfileUserPresenter presenter;
    private boolean isEditable;
    @BindView(R.id.ivPhoto)ImageView ivPhoto;
    @BindView(R.id.card_view_name)View cardViewName;
    @BindView(R.id.card_view_status)View cardViewStatus;
    @BindView(R.id.card_view_post)View card_view_post;
    @BindView(R.id.card_view_for_day)View card_view_for_day;
    @BindView(R.id.card_view_having)View card_view_having;
    @BindView(R.id.card_view_middle_time)View card_view_middle_time;
    @BindView(R.id.card_view_phone)View cardViewPhone;
    @BindView(R.id.btnEditPhoto)FloatingActionButton fabEdit;

    @BindString(R.string.name) String name;
    @BindString(R.string.status) String status;
    @BindString(R.string.phone) String phone;
    @BindString(R.string.post) String post;
    @BindString(R.string.per_day) String perDay;
    @BindString(R.string.orders_on_hand) String ordersOnHand;
    @BindString(R.string.middle_time) String middleTime;
    @BindString(R.string.profile) String profile;
    @OnClick(R.id.btnEditPhoto)
    void onEditClick() {
        if (isEditable) {
            isEditable = false;
            fabEdit.setImageResource(R.drawable.ic_edit);
            hideKeyboard(getActivity(), etName);
        } else {
            isEditable = true;
            fabEdit.setImageResource(R.drawable.ic_check);
            showKeyboard(getActivity(), etName);
        }
        etName.setEnabled(isEditable);
        etStatus.setEnabled(isEditable);
        etPhone.setEnabled(isEditable);
    }
    private EditText etName;
    private EditText etStatus;
    private EditText etPhone;


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
        setToolbarTitle(profile);
        setHasOptionsMenu(false);
        Picasso.with(getActivity())
                .load("http://i.imgur.com/0JTbWMn.jpg")
                .into(ivPhoto);

        setNameValueByCardViewName(name, "Аркадий", cardViewName);
        setNameValueByCardViewName(status, "Малыш на драйве", cardViewStatus);
        setNameValueByCardViewName(phone, "+7(855)321-54-65", cardViewPhone);
        setNameValueByCardViewName(post, "Курьер", card_view_post);
        setNameValueByCardViewName(perDay, "15 заказов", card_view_for_day);
        setNameValueByCardViewName(ordersOnHand, "3 заказа", card_view_having);
        setNameValueByCardViewName(middleTime, "27 минут", card_view_middle_time);
        etName = cardViewName.findViewById(R.id.tvValue);
        etStatus = cardViewStatus.findViewById(R.id.tvValue);
        etPhone = cardViewPhone.findViewById(R.id.tvValue);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        App.getComponentManager().releaseComponent(getClass());
    }

}
