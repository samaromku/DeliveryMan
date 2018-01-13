package ru.savchenko.andrey.deliveryman.fragments.delivered.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.fragments.delivered.DeliveredFragment;

@Subcomponent(modules = DeliveredModule.class)
@DeliveredScope
public interface DeliveredComponent extends BaseComponent<DeliveredFragment> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<DeliveredComponent, DeliveredModule> {
    }
}
