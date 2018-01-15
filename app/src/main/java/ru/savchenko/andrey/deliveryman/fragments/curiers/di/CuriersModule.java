package ru.savchenko.andrey.deliveryman.fragments.curiers.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.fragments.curiers.CuriersView;
import ru.savchenko.andrey.deliveryman.fragments.curiers.CuriersPresenter;
import ru.savchenko.andrey.deliveryman.fragments.curiers.CuriersInterActor;

@Module
public class CuriersModule implements BaseModule {
    private CuriersView view;

    public CuriersModule(CuriersView view) {
        this.view = view;
    }

    @CuriersScope
    @Provides
    public CuriersPresenter presenter(CuriersInterActor interActor) {
        return new CuriersPresenter(view, interActor);
    }

    @CuriersScope
    @Provides
    CuriersInterActor interActor() {
        return new CuriersInterActor();
    }
}

