package de.quinscape.dqlmobx.runtime.config;

import de.quinscape.dqlmobx.runtime.message.GraphQLMessageHandler;
import de.quinscape.dqlmobx.ws.DQLMobxWebSocketHandler;
import graphql.GraphQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Arrays;

@Configuration
@EnableWebSocket
public class WebsocketConfiguration
    implements WebSocketConfigurer
{
    private final GraphQL graphQL;


    public WebsocketConfiguration(
        @Lazy graphql.GraphQL graphQL
    )
    {
        this.graphQL = graphQL;
    }


    /**
     * We don't want to deal with all the socket.js/stomp stuff for now, so we register our own spring
     * {@link TextWebSocketHandler} implementation.
     *
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
    {
        final DQLMobxWebSocketHandler webSocketHandler = dqlMobxWebSocketHandler();

        registry.addHandler(webSocketHandler, "/dqlmobx-ws");
    }

    @Bean
    public DQLMobxWebSocketHandler dqlMobxWebSocketHandler()
    {
        return new DQLMobxWebSocketHandler(
            Arrays.asList(
                new GraphQLMessageHandler(
                    graphQL
                )
            )
        );
    }
}
