package ru.savchenko.andrey.deliveryman.fragments.curiers.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.fragments.curiers.CuriersFragment;

@Subcomponent(modules = CuriersModule.class)
@CuriersScope
public interface CuriersComponent extends BaseComponent<CuriersFragment> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<CuriersComponent, CuriersModule> {
    }
}
