package ru.savchenko.andrey.deliveryman.dialogs.oneorder.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.dialogs.oneorder.OneOrderDialog;

@Subcomponent(modules = OneOrderModule.class)
@OneOrderScope
public interface OneOrderComponent extends BaseComponent<OneOrderDialog> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<OneOrderComponent, OneOrderModule> {
    }
}
