package ru.savchenko.andrey.deliveryman.fragments.actual.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualFragment;

/**
 * Created by Andrey on 25.09.2017.
 */
@Subcomponent(modules = ActualModule.class)
@ActualScope
public interface ActualComponent extends BaseComponent<ActualFragment>{
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<ActualComponent, ActualModule>{}
}
