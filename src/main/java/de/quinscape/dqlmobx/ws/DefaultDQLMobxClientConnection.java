package de.quinscape.dqlmobx.ws;

import de.quinscape.dqlmobx.runtime.DQLMobxException;
import de.quinscape.dqlmobx.runtime.service.AppAuthentication;
import de.quinscape.dqlmobx.model.message.OutgoingMessage;
import de.quinscape.dqlmobx.model.message.Response;
import de.quinscape.spring.jsview.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.svenson.JSONProperty;

import java.io.IOException;

public class DefaultDQLMobxClientConnection
    implements DQLMobxClientConnection
{
    private final static Logger log = LoggerFactory.getLogger(DefaultDQLMobxClientConnection.class);


    private volatile WebSocketSession session;

    private final String connectionId;

    private final AppAuthentication auth;


    public DefaultDQLMobxClientConnection(String connectionId, AppAuthentication auth)
    {
        log.debug("New session: {},/{}", connectionId, auth);

        this.connectionId = connectionId;
        this.auth = auth;
    }

    @Override
    public void initialize(WebSocketSession session)
    {
        this.session = session;
    }


    @Override
    @JSONProperty(ignore = true)
    public WebSocketSession getSession()
    {
        return session;
    }


    @Override
    public String getConnectionId()
    {
        return connectionId;
    }


    @Override
    public AppAuthentication getAuth()
    {
        return auth;
    }


    @Override
    public void send(OutgoingMessage message)
    {
        try
        {
            session.sendMessage(
                new TextMessage(
                    JSONUtil.DEFAULT_GENERATOR.forValue(
                        message
                    )
                )
            );
        }
        catch (IOException e)
        {
            throw new DQLMobxException("Error sending websocket message", e);
        }
    }


    @Override
    public void respond(String messageId, Object payload, String error)
    {
        final Response response = new Response(messageId, payload, error);

        send(
            response
        );
    }


    @Override
    public void respond(String messageId, Object result)
    {
        respond(messageId, result, null);
    }
}
