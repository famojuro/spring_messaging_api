package com.innovativeapps.com.messagingapp.manager;

import com.innovativeapps.com.messagingapp.data.manager.CommentDataManagerLocal;
import com.innovativeapps.com.messagingapp.data.manager.MessageDataManagerLocal;
import com.innovativeapps.com.messagingapp.data.manager.UserDataManagerLocal;
import com.innovativeapps.com.messagingapp.model.Comment;
import com.innovativeapps.com.messagingapp.model.Message;
import com.innovativeapps.com.messagingapp.model.User;
import com.innovativeapps.com.messagingapp.pojo.AppComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class CommentManager implements CommentManagerLocal{

    @Autowired
    private CommentDataManagerLocal commentDataManager;

    @Autowired
    private UserDataManagerLocal userDataManager;

    @Autowired
    private MessageDataManagerLocal messageDataManager;

    @Override
    public AppComment createComment(String content, String userId, String messageId) {
        User user = userDataManager.get(Integer.parseInt(userId));
        Message message = messageDataManager.get(Integer.parseInt(messageId));
        if (user == null || message == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setMessage(message);
        comment.setUser(user);

        return getAppComment(comment);
    }

    private List<AppComment> getAppComments(List<Comment> comments) {
        List<AppComment> appComments = new ArrayList<>();
        for (Comment comment : comments) {
            AppComment appComment = getAppComment(comment);
            if (appComment != null) {
                appComments.add(appComment);
            }
        }
        appComments.sort(Comparator.comparing(AppComment::getCreatedDate));

        return appComments;
    }

    private AppComment getAppComment(Comment comment) {
        AppComment appComment = new AppComment();
        if (comment == null) {
            return null;
        }
        appComment.setContent(comment.getContent());
        appComment.setMessage(comment.getMessage());
        appComment.setUser(comment.getUser());
        appComment.setCreatedDate(comment.getCreatedDate());

        return appComment;
    }
}
