package ru.savchenko.andrey.deliveryman.activities.neworder.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.activities.neworder.NewOrderActivity;

@Subcomponent(modules = NewOrderModule.class)
@NewOrderScope
public interface NewOrderComponent extends BaseComponent<NewOrderActivity> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<NewOrderComponent, NewOrderModule> {
    }
}
