package ru.savchenko.andrey.deliveryman.fragments.contacts.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryman.di.base.BaseModule;
import ru.savchenko.andrey.deliveryman.fragments.contacts.ContactView;
import ru.savchenko.andrey.deliveryman.fragments.contacts.ContactPresenter;
import ru.savchenko.andrey.deliveryman.fragments.contacts.ContactInterActor;

@Module
public class ContactModule implements BaseModule {
    private ContactView view;

    public ContactModule(ContactView view) {
        this.view = view;
    }

    @ContactScope
    @Provides
    public ContactPresenter presenter(ContactInterActor interActor) {
        return new ContactPresenter(view, interActor);
    }

    @ContactScope
    @Provides
    ContactInterActor interActor() {
        return new ContactInterActor();
    }
}

