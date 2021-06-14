package com.innovativeapps.com.messagingapp.manager;

import com.innovativeapps.com.messagingapp.pojo.AppMessage;
import com.innovativeapps.com.messagingapp.pojo.MessagePayload;

import java.util.List;

public interface MessageManagerLocal {

    AppMessage createMessage(String userId, String content);

    AppMessage getMessage(String messageId);

    MessagePayload getMessages();
}
