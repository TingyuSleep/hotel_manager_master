package com.gk.study.service;


import com.gk.study.entity.Guest;
import com.gk.study.entity.User;

import java.util.List;

public interface GuestService {
    List<Guest> getGuestList(String keyword);
    void createGuest(Guest guest);
    void updateGuest(Guest guest);
    void deleteUser(String id);


}
