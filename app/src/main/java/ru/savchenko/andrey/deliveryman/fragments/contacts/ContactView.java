package ru.savchenko.andrey.deliveryman.fragments.contacts;

import java.util.List;

import ru.savchenko.andrey.deliveryman.entities.Contact;

public interface ContactView {
    void setListToAdapter(List<Contact> listToAdapter);
}
