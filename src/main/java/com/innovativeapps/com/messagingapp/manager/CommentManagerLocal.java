package com.innovativeapps.com.messagingapp.manager;

import com.innovativeapps.com.messagingapp.pojo.AppComment;

public interface CommentManagerLocal {

    AppComment createComment(String content, String userId, String messageId);
}
