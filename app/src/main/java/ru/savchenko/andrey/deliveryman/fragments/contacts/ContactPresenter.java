package ru.savchenko.andrey.deliveryman.fragments.contacts;

public class ContactPresenter {
    private static final String TAG = ContactPresenter.class.getSimpleName();
    private ContactView view;
    private ContactInterActor interActor;

    public ContactPresenter(ContactView view, ContactInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void getListFroAdapter() {
        interActor.getListFroAdapter()
                .subscribe(list -> view.setListToAdapter(list));
    }
}
