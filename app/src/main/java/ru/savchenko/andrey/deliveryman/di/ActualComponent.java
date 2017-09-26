package ru.savchenko.andrey.deliveryman.di;

import dagger.Component;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualInteractorImpl;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualPresenter;

/**
 * Created by Andrey on 25.09.2017.
 */
@Component(modules = {
        ActualInteractorImpl.class
})
public interface ActualComponent {
    void inject(ActualPresenter presenter);

}
