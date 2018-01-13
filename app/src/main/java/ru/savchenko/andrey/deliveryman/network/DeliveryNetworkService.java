package ru.savchenko.andrey.deliveryman.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ru.savchenko.andrey.deliveryman.entities.Address;
import ru.savchenko.andrey.deliveryman.entities.Order;

/**
 * Created by Andrey on 02.01.2018.
 */

public interface DeliveryNetworkService {
    @POST("/add_order")
    Observable<Integer> addOrder(@Body Order order);

    @GET("/get_addresses")
    Observable<List<Address>>getAddresses();
}
