package ru.savchenko.andrey.deliveryman.fragments.contacts;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryman.entities.Address;
import ru.savchenko.andrey.deliveryman.entities.Contact;

public class ContactInterActor {
    private static final String TAG = ContactInterActor.class.getSimpleName();

    Observable<List<Contact>> getListFroAdapter() {
        List<Contact>addresses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            addresses.add(new Contact(i,
                    "Andrey " + i,
                    new Address(i, "Новолитовскаяб 12", 0, 0),
                    "+7(985) 857-12-1"+i,
                    "test@mail.ru"));
        }
        return Observable.fromCallable(() -> addresses);
    }
}
