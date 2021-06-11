package com.innovativeapps.com.messagingapp.manager;

import com.innovativeapps.com.messagingapp.pojo.AppMessage;

public interface MessageManagerLocal {

    AppMessage createMessage(String userId, String content);

    AppMessage getMessage(String messageId);
}
