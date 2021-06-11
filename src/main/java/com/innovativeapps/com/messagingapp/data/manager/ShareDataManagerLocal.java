package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.model.Share;

import java.util.List;

public interface ShareDataManagerLocal {

    Share create(Share share);

    Share get(String shareId);

    List<Share> getAll();
}
