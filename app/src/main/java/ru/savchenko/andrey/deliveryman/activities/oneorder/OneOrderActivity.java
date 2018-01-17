package ru.savchenko.andrey.deliveryman.activities.oneorder;

import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseActivity;
import ru.savchenko.andrey.deliveryman.activities.oneorder.di.OneOrderComponent;
import ru.savchenko.andrey.deliveryman.activities.oneorder.di.OneOrderModule;
import ru.savchenko.andrey.deliveryman.entities.Order;

import static ru.savchenko.andrey.deliveryman.storage.Utils.setNameValueByCardViewName;

public class OneOrderActivity extends BaseActivity implements OneOrderView {
    private static final String TAG = OneOrderActivity.class.getSimpleName();
    @Inject
    OneOrderPresenter presenter;
    @BindView(R.id.card_view_title)View card_view_title;
    @BindView(R.id.card_view_body)View card_view_body;
    @BindView(R.id.card_view_address)View card_view_address;
    @BindView(R.id.card_view_created)View card_view_created;
    @BindView(R.id.card_view_dead_line)View card_view_dead_line;
    @BindView(R.id.card_view_way)View card_view_way;
    @BindView(R.id.card_view_status)View card_view_status;
    @BindView(R.id.card_view_rating)View card_view_rating;
    @BindString(R.string.title)String title;
    @BindString(R.string.description)String description;
    @BindString(R.string.address)String address;
    @BindString(R.string.creation_date)String creationDate;
    @BindString(R.string.deadline)String deadline;
    @BindString(R.string.way)String way;
    @BindString(R.string.status)String status;
    @BindString(R.string.rating)String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_order);
        ((OneOrderComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new OneOrderModule(this))).inject(this);
        initBackButton();
        ButterKnife.bind(this);
        Order order = new Order.Builder()
                .body("Пицца с креветками")
                .title("test")
                .deadLine(new Date())
                .created(new Date())
                .way(10)
                .address("Кайок то адрес")
                .status(1)
                .rating(2)
                .build();
        setNameValueByCardViewName(title, order.getTitle(), card_view_title);
        setNameValueByCardViewName(description, order.getBody(), card_view_body);
        setNameValueByCardViewName(address, order.getAddress(), card_view_address);
        setNameValueByCardViewName(creationDate, new SimpleDateFormat("dd/mm/yyyy").format(order.getCreated()), card_view_created);
        setNameValueByCardViewName(deadline, new SimpleDateFormat("dd/mm/yyyy").format(order.getDeadLine()), card_view_dead_line);
        setNameValueByCardViewName(way, String.valueOf(order.getWay()), card_view_way);
        setNameValueByCardViewName(status, String.valueOf(order.getStatus()), card_view_status);
        setNameValueByCardViewName(rating, String.valueOf(order.getRating()), card_view_rating);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing()) {
            App.getComponentManager().releaseComponent(getClass());
        }
    }
}
