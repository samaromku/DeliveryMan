package ru.savchenko.andrey.deliveryman.fragments.actual;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.savchenko.andrey.deliveryman.di.ComponentManager;

/**
 * Created by Andrey on 25.09.2017.
 */
@InjectViewState
public class ActualPresenter extends MvpPresenter<ActualView> {
    @Inject ActualInteractor interactor;

    public void init(){
        ComponentManager.getActualComponent().inject(this);
    }

    public void setOrders(){
        interactor.ordersList()
                .subscribe(orders -> getViewState().setOrdersList(orders));
    }
}
