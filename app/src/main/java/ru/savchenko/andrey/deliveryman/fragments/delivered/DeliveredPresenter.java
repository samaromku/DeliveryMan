package ru.savchenko.andrey.deliveryman.fragments.delivered;

public class DeliveredPresenter {
    private static final String TAG = DeliveredPresenter.class.getSimpleName();
    private DeliveredView view;
    private DeliveredInterActor interActor;

    public DeliveredPresenter(DeliveredView view, DeliveredInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void getListFroAdapter() {
        interActor.getListFroAdapter()
                .subscribe(list -> view.setListToAdapter(list));
    }
}
