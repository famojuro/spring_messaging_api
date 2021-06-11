package com.innovativeapps.com.messagingapp.data.manager;

import com.innovativeapps.com.messagingapp.data.provider.DataproviderLocal;
import com.innovativeapps.com.messagingapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDataManager implements MessageDataManagerLocal {

    @Autowired
    private DataproviderLocal crud;

    @Override
    public Message create(Message message) { return crud.create(message); }

    @Override
    public Message get(Integer messageId) { return crud.find(messageId, Message.class); }
}
