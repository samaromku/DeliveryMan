package ru.savchenko.andrey.deliveryman.activities.oneorder.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.activities.oneorder.OneOrderActivity;

@Subcomponent(modules = OneOrderModule.class)
@OneOrderScope
public interface OneOrderComponent extends BaseComponent<OneOrderActivity> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<OneOrderComponent, OneOrderModule> {
    }
}
