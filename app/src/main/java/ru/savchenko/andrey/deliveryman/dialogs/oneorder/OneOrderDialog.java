package ru.savchenko.andrey.deliveryman.dialogs.oneorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.dialogs.oneorder.di.OneOrderComponent;
import ru.savchenko.andrey.deliveryman.dialogs.oneorder.di.OneOrderModule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import javax.inject.Inject;

public class OneOrderDialog extends DialogFragment implements OneOrderView {
    private static final String TAG = OneOrderDialog.class.getSimpleName();
    @Inject
    OneOrderPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((OneOrderComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new OneOrderModule(this))).inject(this);
        return inflater.inflate(R.layout.dialog_one_order, container, false);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        App.getComponentManager().releaseComponent(getClass());
    }

}
