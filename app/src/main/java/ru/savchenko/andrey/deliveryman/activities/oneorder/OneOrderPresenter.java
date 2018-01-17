package ru.savchenko.andrey.deliveryman.activities.oneorder;

public class OneOrderPresenter {
    private static final String TAG = OneOrderPresenter.class.getSimpleName();
    private OneOrderView view;
    private OneOrderInterActor interActor;

    public OneOrderPresenter(OneOrderView view, OneOrderInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

}
