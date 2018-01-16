package ru.savchenko.andrey.deliveryman.fragments.actual;

/**
 * Created by Andrey on 25.09.2017.
 */
public class ActualPresenter {
    private ActualView view;
    private ActualInteractorImpl interactor;

    public ActualPresenter(ActualView view, ActualInteractorImpl interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    void setOrders(){
        interactor.ordersList()
                .subscribe(orders -> view.setOrdersList(orders));
    }

    void onSearch(String search){
        interactor.searchedOrders(search)
                .subscribe(orders -> view.setSearchedList(orders));
    }
}
