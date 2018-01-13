package ru.savchenko.andrey.deliveryman.fragments.delivered;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Order;

public class DeliveredInterActor {
    private static final String TAG = DeliveredInterActor.class.getSimpleName();

    Observable<List<Order>> getListFroAdapter() {
        List<Order>orders = new ArrayList<>();
        orders.add(new Order(1, "test", "Пицца с креветками", new Date(), new Date(), 10));
        orders.add(new Order(1, "test", "Суши терияки и удон", new Date(1504959792456L), new Date(), 5));
        orders.add(new Order(1, "test", "Одна с ананасами, две с шпинатом", new Date(1504959792187L), new Date(), 1));
        orders.add(new Order(1, "test", "Девять балтика 7", new Date(1504959792856L), new Date(), 12));
        orders.add(new Order(1, "test", "Чайник чая", new Date(1504959792911L), new Date(), 12.5));
        orders.add(new Order(1, "test", "три сыра по акции", new Date(1504959792125L), new Date(), 0.5));
        orders.add(new Order(1, "test", "Шашлык свиной", new Date(1504959792586L), new Date(), 1.3));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new Date(1504959792112L), new Date(), 10));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new Date(1504959792112L), new Date(), 10));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new Date(1504959792112L), new Date(), 10));
        for(Order order:orders){
            order.setAddress("Новороссийская 123, кв. 12");
            order.setStatus(2);
        }
        return Observable.fromCallable(() -> orders);
    }
}
