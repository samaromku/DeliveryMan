package ru.savchenko.andrey.deliveryman.fragments.address.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.fragments.address.AddressesView;
import ru.savchenko.andrey.deliveryman.fragments.address.AddressesPresenter;
import ru.savchenko.andrey.deliveryman.fragments.address.AddressesInterActor;

@Module
public class AddressesModule implements BaseModule {
    private AddressesView view;

    public AddressesModule(AddressesView view) {
        this.view = view;
    }

    @AddressesScope
    @Provides
    public AddressesPresenter presenter(AddressesInterActor interActor) {
        return new AddressesPresenter(view, interActor);
    }

    @AddressesScope
    @Provides
    AddressesInterActor interActor() {
        return new AddressesInterActor();
    }
}

