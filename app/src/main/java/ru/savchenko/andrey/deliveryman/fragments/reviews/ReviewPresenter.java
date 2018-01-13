package ru.savchenko.andrey.deliveryman.fragments.reviews;

public class ReviewPresenter {
    private static final String TAG = ReviewPresenter.class.getSimpleName();
    private ReviewView view;
    private ReviewInterActor interActor;

    public ReviewPresenter(ReviewView view, ReviewInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void getListFroAdapter() {
        interActor.getListFroAdapter()
                .subscribe(list -> view.setListToAdapter(list));
    }
}
