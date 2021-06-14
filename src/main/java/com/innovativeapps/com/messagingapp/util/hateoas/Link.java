package com.innovativeapps.com.messagingapp.util.hateoas;

import java.net.URI;

public class Link {
    private String link;
    private String rel;

    private String method;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
