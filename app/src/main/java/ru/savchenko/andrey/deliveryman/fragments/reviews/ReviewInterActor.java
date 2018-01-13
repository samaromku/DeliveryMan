package ru.savchenko.andrey.deliveryman.fragments.reviews;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Review;

public class ReviewInterActor {
    private static final String TAG = ReviewInterActor.class.getSimpleName();

    Observable<List<Review>> getListFroAdapter() {
        // TODO: 30.12.2017 must get data from repository
        return Observable.fromCallable(ArrayList::new);
    }
}
