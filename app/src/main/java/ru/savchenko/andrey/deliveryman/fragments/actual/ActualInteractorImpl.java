package ru.savchenko.andrey.deliveryman.fragments.actual;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Order;

/**
 * Created by Andrey on 25.09.2017.
 */
@Module
public class ActualInteractorImpl implements ActualInteractor{

    @Override
    @Provides
    public ActualInteractor interactor(){
        return this;
    }

    @Override
    public Observable<List<Order>>ordersList(){
        List<Order>orders = new ArrayList<>();
        orders.add(new Order(1, "test", "Пицца с креветками", new DateTime(1504951111111L), new DateTime(), 10));
        orders.add(new Order(1, "test", "Суши терияки и удон", new DateTime(1504959792456L), new DateTime(), 5));
        orders.add(new Order(1, "test", "Одна с ананасами, две с шпинатом", new DateTime(1504959792187L), new DateTime(), 1));
        orders.add(new Order(1, "test", "Девять балтика 7", new DateTime(1504959792856L), new DateTime(), 12));
        orders.add(new Order(1, "test", "Чайник чая", new DateTime(1504959792911L), new DateTime(), 12.5));
        orders.add(new Order(1, "test", "три сыра по акции", new DateTime(1504959792125L), new DateTime(), 0.5));
        orders.add(new Order(1, "test", "Шашлык свиной", new DateTime(1504959792586L), new DateTime(), 1.3));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new DateTime(1504959792112L), new DateTime(), 10));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new DateTime(1504959792112L), new DateTime(), 10));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new DateTime(1504959792112L), new DateTime(), 10));
        return Observable.just(orders);
    }
}
