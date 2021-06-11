package com.innovativeapps.com.messagingapp.manager;

import com.innovativeapps.com.messagingapp.data.manager.MessageDataManagerLocal;
import com.innovativeapps.com.messagingapp.data.manager.UserDataManagerLocal;
import com.innovativeapps.com.messagingapp.model.Message;
import com.innovativeapps.com.messagingapp.model.User;
import com.innovativeapps.com.messagingapp.pojo.AppMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RestController
public class MessageManager implements  MessageManagerLocal {

    @Autowired
    private UserDataManagerLocal userDataManager;

    @Autowired
    private MessageDataManagerLocal messageDataManager;

    @Override
    public AppMessage createMessage(String userId, String content) {
        User user = userDataManager.get(Integer.parseInt(userId));
        if (user == null) {
            return null;
        }
        Message message = new Message();
        message.setContent(content);
        message.setUser(user);
        message.setCreatedDate(new Date());
        message = messageDataManager.create(message);

        return getAppMessage(message);
    }

    @Override
    public AppMessage getMessage(String messageId) {
        Message message = messageDataManager.get(Integer.parseInt(messageId));

        return getAppMessage(message);
    }

    private List<AppMessage> getAppMessages(List<Message> messages) {
        List<AppMessage> appMessages = new ArrayList<>();
        for (Message message : messages) {
            AppMessage appMessage = getAppMessage(message);
            if (appMessage != null) {
                appMessages.add(appMessage);
            }
        }
        appMessages.sort(Comparator.comparing(AppMessage::getCreatedDate));

        return appMessages;
    }

    private AppMessage getAppMessage(Message message) {
        if (message == null) {
            return null;
        }
        AppMessage appMessage = new AppMessage();
        appMessage.setContent(message.getContent());
        appMessage.setUser(message.getUser());
        appMessage.setCommentList(message.getCommentList());
        appMessage.setShareList(message.getShareList());
        appMessage.setCreatedDate(message.getCreatedDate());

        return appMessage;
    }
}
