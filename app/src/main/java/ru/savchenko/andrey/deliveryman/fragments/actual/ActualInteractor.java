package ru.savchenko.andrey.deliveryman.fragments.actual;

import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Order;

/**
 * Created by Andrey on 26.09.2017.
 */

public interface ActualInteractor {
    ActualInteractor interactor();

    Observable<List<Order>> ordersList();
}
