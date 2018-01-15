package ru.savchenko.andrey.deliveryman.dialogs.oneorder;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseActivity;
import ru.savchenko.andrey.deliveryman.dialogs.oneorder.di.OneOrderComponent;
import ru.savchenko.andrey.deliveryman.dialogs.oneorder.di.OneOrderModule;
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
        setNameValueByCardViewName("Заголовок", order.getTitle(), card_view_title);
        setNameValueByCardViewName("Описание", order.getBody(), card_view_body);
        setNameValueByCardViewName("Адрес", order.getAddress(), card_view_address);
        setNameValueByCardViewName("Дата создания", new SimpleDateFormat("dd/mm/yyyy").format(order.getCreated()), card_view_created);
        setNameValueByCardViewName("Крайний срок", new SimpleDateFormat("dd/mm/yyyy").format(order.getDeadLine()), card_view_dead_line);
        setNameValueByCardViewName("Осталось в пути", String.valueOf(order.getWay()), card_view_way);
        setNameValueByCardViewName("Сатус", String.valueOf(order.getStatus()), card_view_status);
        setNameValueByCardViewName("Рейтинг", String.valueOf(order.getRating()), card_view_rating);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing()) {
            App.getComponentManager().releaseComponent(getClass());
        }
    }
}
