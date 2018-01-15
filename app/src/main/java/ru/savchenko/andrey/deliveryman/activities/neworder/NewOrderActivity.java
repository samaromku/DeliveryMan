package ru.savchenko.andrey.deliveryman.activities.neworder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.activities.neworder.di.NewOrderComponent;
import ru.savchenko.andrey.deliveryman.activities.neworder.di.NewOrderModule;
import ru.savchenko.andrey.deliveryman.base.BaseActivity;

public class NewOrderActivity extends BaseActivity implements NewOrderView {
    private static final String TAG = NewOrderActivity.class.getSimpleName();
    @Inject
    NewOrderPresenter presenter;

    @BindView(R.id.etTitle)EditText etTitle;
    @BindView(R.id.etDescription)EditText etDescription;
    @BindView(R.id.etAddress)EditText etAddress;
    @OnClick(R.id.fab)
    void onFabClick(){
        presenter.sendOrder(etTitle.getText().toString(),
                            etDescription.getText().toString(),
                            etAddress.getText().toString());
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        ButterKnife.bind(this);
        ((NewOrderComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new NewOrderModule(this))).inject(this);
        initBackButton();
        changeToolbarTitle(R.string.new_order);
    }

    @Override
    public void finishCurrent() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getComponentManager().releaseComponent(getClass());
        }
    }

}
