package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.model.Message;

import java.util.List;

public interface MessageDataManagerLocal {

    Message create(Message message);

    Message get(Integer messageId);

    List<Message> getAll();
}
