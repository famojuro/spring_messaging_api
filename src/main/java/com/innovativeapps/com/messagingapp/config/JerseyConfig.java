package com.innovativeapps.com.messagingapp.config;

import com.innovativeapps.com.messagingapp.service.MessageService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
            register(MessageService.class);
    }
}
