package ru.savchenko.andrey.deliveryman.fragments.curiers;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Courier;

public class CuriersInterActor {
    private static final String TAG = CuriersInterActor.class.getSimpleName();

    Observable<List<Courier>> getListFroAdapter() {
        List<Courier> couriers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            couriers.add(new Courier(i,
                    "Никита " + i,
                    "+7(955)234-98-1" + i,
                    (int) (Math.random() * 3)));
        }

        return Observable.fromCallable(() -> couriers);
    }
}
