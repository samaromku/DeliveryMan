package ru.savchenko.andrey.deliveryman.fragments.profile.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.fragments.profile.ProfileUserView;
import ru.savchenko.andrey.deliveryman.fragments.profile.ProfileUserPresenter;
import ru.savchenko.andrey.deliveryman.fragments.profile.ProfileUserInterActor;

@Module
public class ProfileUserModule implements BaseModule {
    private ProfileUserView view;

    public ProfileUserModule(ProfileUserView view) {
        this.view = view;
    }

    @ProfileUserScope
    @Provides
    public ProfileUserPresenter presenter(ProfileUserInterActor interActor) {
        return new ProfileUserPresenter(view, interActor);
    }

    @ProfileUserScope
    @Provides
    ProfileUserInterActor interActor() {
        return new ProfileUserInterActor();
    }
}

