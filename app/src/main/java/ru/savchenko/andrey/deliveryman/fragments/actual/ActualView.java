package ru.savchenko.andrey.deliveryman.fragments.actual;

import java.util.List;

import ru.savchenko.andrey.deliveryman.base.mvp.BaseView;
import ru.savchenko.andrey.deliveryman.entities.Order;

/**
 * Created by Andrey on 25.09.2017.
 */

public interface ActualView extends BaseView {
    void setOrdersList(List<Order>ordersList);
}
