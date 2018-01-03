package ru.savchenko.andrey.deliveryman.activities.neworder.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.activities.neworder.NewOrderView;
import ru.savchenko.andrey.deliveryman.activities.neworder.NewOrderPresenter;
import ru.savchenko.andrey.deliveryman.activities.neworder.NewOrderInterActor;
import ru.savchenko.andrey.deliveryman.network.DeliveryNetworkService;

@Module
public class NewOrderModule implements BaseModule {
    private NewOrderView view;

    public NewOrderModule(NewOrderView view) {
        this.view = view;
    }

    @NewOrderScope
    @Provides
    public NewOrderPresenter presenter(NewOrderInterActor interActor) {
        return new NewOrderPresenter(view, interActor);
    }

    @NewOrderScope
    @Provides
    NewOrderInterActor interActor(DeliveryNetworkService deliveryNetworkService) {
        return new NewOrderInterActor(deliveryNetworkService);
    }
}

