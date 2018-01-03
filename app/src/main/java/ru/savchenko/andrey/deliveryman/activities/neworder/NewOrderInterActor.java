package ru.savchenko.andrey.deliveryman.activities.neworder;


import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryman.entities.Order;
import ru.savchenko.andrey.deliveryman.network.DeliveryNetworkService;

public class NewOrderInterActor {
    private static final String TAG = NewOrderInterActor.class.getSimpleName();
    private DeliveryNetworkService deliveryNetworkService;

    public NewOrderInterActor(DeliveryNetworkService deliveryNetworkService) {
        this.deliveryNetworkService = deliveryNetworkService;
    }

    Observable<Integer> sendOrder(String title, String description, String address){
        return deliveryNetworkService.addOrder(new Order(1, title, description, address, new Date(), new Date()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
