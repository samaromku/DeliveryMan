package ru.savchenko.andrey.deliveryman.fragments.delivered.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.fragments.delivered.DeliveredView;
import ru.savchenko.andrey.deliveryman.fragments.delivered.DeliveredPresenter;
import ru.savchenko.andrey.deliveryman.fragments.delivered.DeliveredInterActor;

@Module
public class DeliveredModule implements BaseModule {
    private DeliveredView view;

    public DeliveredModule(DeliveredView view) {
        this.view = view;
    }

    @DeliveredScope
    @Provides
    public DeliveredPresenter presenter(DeliveredInterActor interActor) {
        return new DeliveredPresenter(view, interActor);
    }

    @DeliveredScope
    @Provides
    DeliveredInterActor interActor() {
        return new DeliveredInterActor();
    }
}

