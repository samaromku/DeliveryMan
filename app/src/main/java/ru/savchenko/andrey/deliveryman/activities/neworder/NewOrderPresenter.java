package ru.savchenko.andrey.deliveryman.activities.neworder;

public class NewOrderPresenter {
    private static final String TAG = NewOrderPresenter.class.getSimpleName();
    private NewOrderView view;
    private NewOrderInterActor interActor;

    public NewOrderPresenter(NewOrderView view, NewOrderInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void sendOrder(String title, String description, String address) {
        interActor.sendOrder(title, description, address)
                .subscribe(integer -> {
                            view.showToast("Ид нового заказа " + integer);
                            view.finishCurrent();
                        },
                        Throwable::printStackTrace);
    }

}
