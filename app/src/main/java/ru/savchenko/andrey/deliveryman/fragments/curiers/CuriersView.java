package ru.savchenko.andrey.deliveryman.fragments.curiers;

import java.util.List;

import ru.savchenko.andrey.deliveryman.entities.Courier;

public interface CuriersView {
    void setListToAdapter(List<Courier> listToAdapter);
}
