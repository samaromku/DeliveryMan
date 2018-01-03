package ru.savchenko.andrey.deliveryman.fragments.actual.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualInteractor;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualInteractorImpl;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualPresenter;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualView;

/**
 * Created by Andrey on 03.01.2018.
 */
@Module
public class ActualModule implements BaseModule{
    private ActualView view;

    public ActualModule(ActualView view) {
        this.view = view;
    }

    @Provides
    @ActualScope
    ActualInteractor interactor(){
        return new ActualInteractorImpl();
    }

    @Provides
    @ActualScope
    ActualPresenter presenter(ActualInteractor interactor){
        return new ActualPresenter(view, interactor);
    }
}
