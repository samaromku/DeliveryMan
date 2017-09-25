package ru.savchenko.andrey.deliveryman.di;

import dagger.Component;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualFragment;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualInteractor;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualPresenter;

/**
 * Created by Andrey on 25.09.2017.
 */
@Component(modules = {
        ActualInteractor.class
})
public interface ActualComponent {
    void inject(ActualPresenter presenter);

}
