package ru.savchenko.andrey.deliveryman.activities.oneorder.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.activities.oneorder.OneOrderView;
import ru.savchenko.andrey.deliveryman.activities.oneorder.OneOrderPresenter;
import ru.savchenko.andrey.deliveryman.activities.oneorder.OneOrderInterActor;

@Module
public class OneOrderModule implements BaseModule {
    private OneOrderView view;

    public OneOrderModule(OneOrderView view) {
        this.view = view;
    }

    @OneOrderScope
    @Provides
    public OneOrderPresenter presenter(OneOrderInterActor interActor) {
        return new OneOrderPresenter(view, interActor);
    }

    @OneOrderScope
    @Provides
    OneOrderInterActor interActor() {
        return new OneOrderInterActor();
    }
}

