package ru.savchenko.andrey.deliveryman.fragments.reviews.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.fragments.reviews.ReviewFragment;

@Subcomponent(modules = ReviewModule.class)
@ReviewScope
public interface ReviewComponent extends BaseComponent<ReviewFragment> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<ReviewComponent, ReviewModule> {
    }
}
