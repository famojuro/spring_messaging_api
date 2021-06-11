package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.data.provider.DataproviderLocal;
import com.innovativeapps.com.messagingapp.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDataManager implements CommentDataManagerLocal {

    @Autowired
    private DataproviderLocal crud;

    @Override
    public Comment create(Comment comment) { return crud.create(comment); }

    @Override
    public Comment get(String commentId) { return crud.find(commentId, Comment.class); }

    @Override
    public List<Comment> getAll() {return crud.findAll(Comment.class); }
}
