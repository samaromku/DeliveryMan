package ru.savchenko.andrey.deliveryman.fragments.profile.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.fragments.profile.ProfileUserFragment;

@Subcomponent(modules = ProfileUserModule.class)
@ProfileUserScope
public interface ProfileUserComponent extends BaseComponent<ProfileUserFragment> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<ProfileUserComponent, ProfileUserModule> {
    }
}
