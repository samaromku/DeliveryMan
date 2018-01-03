package ru.savchenko.andrey.deliveryman.fragments.actual;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dagger.Module;
import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Order;

/**
 * Created by Andrey on 25.09.2017.
 */
public class ActualInteractorImpl implements ActualInteractor{

    @Override
    public Observable<List<Order>>ordersList(){
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
        return Observable.just(orders);
    }
}
