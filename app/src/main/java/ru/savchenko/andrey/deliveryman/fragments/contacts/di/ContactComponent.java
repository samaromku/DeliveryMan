package ru.savchenko.andrey.deliveryman.fragments.contacts.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryman.fragments.contacts.ContactFragment;

@Subcomponent(modules = ContactModule.class)
@ContactScope
public interface ContactComponent extends BaseComponent<ContactFragment> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<ContactComponent, ContactModule> {
    }
}
