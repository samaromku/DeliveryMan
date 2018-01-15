package ru.savchenko.andrey.deliveryman.fragments.curiers;

public class CuriersPresenter {
    private static final String TAG = CuriersPresenter.class.getSimpleName();
    private CuriersView view;
    private CuriersInterActor interActor;

    public CuriersPresenter(CuriersView view, CuriersInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void getListFroAdapter() {
        interActor.getListFroAdapter()
                .subscribe(list -> view.setListToAdapter(list));
    }
}
