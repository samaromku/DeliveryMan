package ru.savchenko.andrey.deliveryman.fragments.reviews.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.fragments.reviews.ReviewView;
import ru.savchenko.andrey.deliveryman.fragments.reviews.ReviewPresenter;
import ru.savchenko.andrey.deliveryman.fragments.reviews.ReviewInterActor;

@Module
public class ReviewModule implements BaseModule {
    private ReviewView view;

    public ReviewModule(ReviewView view) {
        this.view = view;
    }

    @ReviewScope
    @Provides
    public ReviewPresenter presenter(ReviewInterActor interActor) {
        return new ReviewPresenter(view, interActor);
    }

    @ReviewScope
    @Provides
    ReviewInterActor interActor() {
        return new ReviewInterActor();
    }
}

