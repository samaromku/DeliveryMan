package ru.savchenko.andrey.deliveryman.fragments.reviews;

import java.util.List;

import ru.savchenko.andrey.deliveryman.entities.Review;

public interface ReviewView {
    void setListToAdapter(List<Review> listToAdapter);
}
