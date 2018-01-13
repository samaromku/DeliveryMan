package ru.savchenko.andrey.deliveryman.fragments.address;

import java.util.List;

import ru.savchenko.andrey.deliveryman.entities.Address;

public interface AddressesView {
    void setListToAdapter(List<Address> listToAdapter);
}
