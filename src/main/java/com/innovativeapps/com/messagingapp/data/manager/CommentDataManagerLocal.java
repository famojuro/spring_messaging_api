package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.model.Comment;
import com.innovativeapps.com.messagingapp.model.Like;

import java.util.List;

public interface CommentDataManagerLocal {

    Comment create(Comment comment);

    Comment get(String commentId);

    List<Comment> getAll();
}
