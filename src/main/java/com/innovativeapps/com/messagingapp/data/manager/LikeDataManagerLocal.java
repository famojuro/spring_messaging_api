package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.model.Like;

import java.util.List;

public interface LikeDataManagerLocal {

    Like create(Like like);

    List<Like> getAll();
}
