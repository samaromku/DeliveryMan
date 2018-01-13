package ru.savchenko.andrey.deliveryman.fragments.reviews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.App;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseFragment;
import ru.savchenko.andrey.deliveryman.entities.Review;
import ru.savchenko.andrey.deliveryman.fragments.reviews.adapter.ReviewAdapter;
import ru.savchenko.andrey.deliveryman.fragments.reviews.di.ReviewComponent;
import ru.savchenko.andrey.deliveryman.fragments.reviews.di.ReviewModule;

public class ReviewFragment extends BaseFragment implements ReviewView {
    private static final String TAG = ReviewFragment.class.getSimpleName();
    @Inject
    ReviewPresenter presenter;

    @BindView(R.id.rvReview)
    RecyclerView rvReview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((ReviewComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new ReviewModule(this))).inject(this);
        return inflater.inflate(R.layout.fragment_review, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setToolbarTitle("Отзывы");
        presenter.getListFroAdapter();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        App.getComponentManager().releaseComponent(getClass());
    }

    @Override
    public void setListToAdapter(List<Review> listToAdapter) {
        ReviewAdapter adapter = new ReviewAdapter();
        adapter.setDataList(listToAdapter);
        adapter.setClickListener(position -> {
            Log.i(TAG, "setListToAdapter: " + position);
        });
        rvReview.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvReview.setAdapter(adapter);
    }
}
