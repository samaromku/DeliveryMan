package ru.savchenko.andrey.deliveryman.fragments.address.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.fragments.address.AddressesFragment;

@Subcomponent(modules = AddressesModule.class)
@AddressesScope
public interface AddressesComponent extends BaseComponent<AddressesFragment> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<AddressesComponent, AddressesModule> {
    }
}
