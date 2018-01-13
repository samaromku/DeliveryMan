package ru.savchenko.andrey.deliveryman.fragments.delivered;

import java.util.List;

import ru.savchenko.andrey.deliveryman.entities.Order;

public interface DeliveredView {
    void setListToAdapter(List<Order> listToAdapter);
}
