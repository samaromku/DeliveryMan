package ru.savchenko.andrey.deliveryman.fragments.actual;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Order;

/**
 * Created by Andrey on 25.09.2017.
 */
public class ActualInteractorImpl {
    private List<Order>all;

    public ActualInteractorImpl(){
        all = new ArrayList<>();
    }

    Observable<List<Order>>ordersList(){
        for (int i = 0; i < 10; i++) {
            all.add(new Order(1, "test", "Пицца с креветками", new Date(), new Date(), 10));
            all.add(new Order(1, "test", "Суши терияки и удон", new Date(1504959792456L), new Date(), 5));
            all.add(new Order(1, "test", "Одна с ананасами, две с шпинатом", new Date(1504959792187L), new Date(), 1));
            all.add(new Order(1, "test", "Девять балтика 7", new Date(1504959792856L), new Date(), 12));
            all.add(new Order(1, "test", "Чайник чая", new Date(1504959792911L), new Date(), 12.5));
            all.add(new Order(1, "test", "три сыра по акции", new Date(1504959792125L), new Date(), 0.5));
            all.add(new Order(1, "test", "Шашлык свиной", new Date(1504959792586L), new Date(), 1.3));
            all.add(new Order(1, "test", "Картофель фри с лососем", new Date(1504959792112L), new Date(), 10));
            all.add(new Order(1, "test", "Картофель фри с лососем", new Date(1504959792112L), new Date(), 10));
            all.add(new Order(1, "test", "Картофель фри с лососем", new Date(1504959792112L), new Date(), 10));
        }
        for(Order order:all){
            order.setAddress("Новороссийская 123, кв. 12");
            order.setStatus(1);
            order.setComment("Какой-то комментарий");
        }
        return Observable.just(all);
    }

    Observable<List<Order>>searchedOrders(String search){
        return Observable.fromCallable(() -> searchedList(search.split(" ")));
    }

    private List<Order>searchedList(String[] words){
        List<Order>startList = new ArrayList<>();
        startList.addAll(all);
        for(String word:words) {
            List<Order>orders = new ArrayList<>();
            for (Order order : startList) {
                String bodyAddress = order.getBody().toLowerCase() + order.getAddress().toLowerCase();
                if (bodyAddress.contains(word.toLowerCase())) {
                    orders.add(order);
                }
            }
            startList.clear();
            startList.addAll(orders);
        }
        return startList;
    }
}
