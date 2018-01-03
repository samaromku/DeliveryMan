package ru.savchenko.andrey.deliveryman.activities.draw.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.activities.draw.DeliveryDrawerActivity;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;

/**
 * Created by Andrey on 02.01.2018.
 */
@Subcomponent(modules = MainModule.class)
public interface MainComponent extends BaseComponent<DeliveryDrawerActivity>{
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<MainComponent, MainModule>{}
}
