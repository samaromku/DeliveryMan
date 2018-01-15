package ru.savchenko.andrey.deliveryman.fragments.profile;

public class ProfileUserPresenter {
    private static final String TAG = ProfileUserPresenter.class.getSimpleName();
    private ProfileUserView view;
    private ProfileUserInterActor interActor;

    public ProfileUserPresenter(ProfileUserView view, ProfileUserInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

}
