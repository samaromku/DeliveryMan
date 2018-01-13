package ru.savchenko.andrey.deliveryman.fragments.address;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Address;

public class AddressesInterActor {
    private static final String TAG = AddressesInterActor.class.getSimpleName();

    Observable<List<Address>> getListFroAdapter() {
        // TODO: 30.12.2017 must get data from repository
        return Observable.fromCallable(ArrayList::new);
    }
}
