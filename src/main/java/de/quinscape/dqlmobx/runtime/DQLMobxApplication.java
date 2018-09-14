package de.quinscape.dqlmobx.runtime;

import de.quinscape.dqlmobx.runtime.config.DomainConfiguration;
import de.quinscape.dqlmobx.runtime.config.GraphQLConfiguration;
import de.quinscape.dqlmobx.runtime.config.SecurityConfiguration;
import de.quinscape.dqlmobx.runtime.config.WebConfiguration;
import de.quinscape.dqlmobx.runtime.config.WebsocketConfiguration;
import de.quinscape.dqlmobx.runtime.controller.JsEntryPointController;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(
    exclude = {
        DataSourceAutoConfiguration.class
    },
    scanBasePackageClasses = {
        JsEntryPointController.class,
    }
)

@Import({
    GraphQLConfiguration.class,
    WebsocketConfiguration.class,
    DomainConfiguration.class,
    WebConfiguration.class,
    SecurityConfiguration.class
})

@EnableWebSecurity(debug = false)

@PropertySource({"classpath:dqlmobx-${spring.profiles.active}.properties"})
public class DQLMobxApplication
    extends SpringBootServletInitializer
    implements ApplicationContextAware
{
    private ApplicationContext applicationContext;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(DQLMobxApplication.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(DQLMobxApplication.class, args);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }
}
