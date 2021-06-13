package com.innovativeapps.com.messagingapp.config;

import com.innovativeapps.com.messagingapp.pojo.AppUser;
import com.innovativeapps.com.messagingapp.pojo.UserPayload;
import com.innovativeapps.com.messagingapp.service.MessageService;
import com.innovativeapps.com.messagingapp.service.UserService;
import com.innovativeapps.com.messagingapp.util.exception.AppException;
import com.innovativeapps.com.messagingapp.util.exception.ErrorMessage;
import com.innovativeapps.com.messagingapp.util.exception.GeneralAppException;
import com.innovativeapps.com.messagingapp.util.exception.GeneralAppExceptionMapper;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.activation.DataSource;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v1")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {

        register(MessageService.class);
        register(UserService.class);
        register(GeneralAppExceptionMapper.class);
    }

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {

                // context
                ContextResource resource = new ContextResource();
                resource.setName("jdbc/messagingcms");
                resource.setType(DataSource.class.getName());
                resource.setProperty("driverClassName", "com.mysql.jdbc.Driver");

                resource.setProperty("url", "jdbc:mysql://localhost:3306/spring_demo_messenger?useSSL=false");
                resource.setProperty("username", "root");
                resource.setProperty("password", "password");
                context.getNamingResources()
                        .addResource(resource);
            }
        };
    }
}
