package com.innovativeapps.com.messagingapp.pojo;

import com.innovativeapps.com.messagingapp.util.hateoas.Link;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MessagePayload {
    private List<AppMessage> messages = null;
    private List<Link> links;

    public MessagePayload() {
       messages = new ArrayList<>();
       links = new ArrayList<>();
    }

    public List<AppMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<AppMessage> messages) { this.messages.addAll(messages); }

    public void setUser(AppMessage appMessage) { messages.add(appMessage); }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(String uri, String rel, String method) {
        Link link = new Link();
        link.setLink(uri);
        link.setRel(rel);
        link.setMethod(method);
        links.add(link);
    }
}
