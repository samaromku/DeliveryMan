package ru.savchenko.andrey.deliveryman.fragments.actual;

/**
 * Created by Andrey on 25.09.2017.
 */
public class ActualPresenter {
    private ActualView view;
    private ActualInteractor interactor;

    public ActualPresenter(ActualView view, ActualInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    void setOrders(){
        interactor.ordersList()
                .subscribe(orders -> view.setOrdersList(orders));
    }
}
