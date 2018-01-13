package ru.savchenko.andrey.deliveryman.fragments.address;

public class AddressesPresenter {
    private static final String TAG = AddressesPresenter.class.getSimpleName();
    private AddressesView view;
    private AddressesInterActor interActor;

    public AddressesPresenter(AddressesView view, AddressesInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void getListFroAdapter() {
        interActor.getListFroAdapter()
                .subscribe(list -> view.setListToAdapter(list));
    }
}
