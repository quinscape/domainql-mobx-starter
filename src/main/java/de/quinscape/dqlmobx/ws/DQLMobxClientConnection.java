package de.quinscape.dqlmobx.ws;

import de.quinscape.dqlmobx.model.message.OutgoingMessage;
import de.quinscape.dqlmobx.runtime.service.AppAuthentication;
import org.springframework.web.socket.WebSocketSession;
import org.svenson.JSONProperty;

public interface DQLMobxClientConnection
{
    void initialize(WebSocketSession session);

    @JSONProperty(ignore = true)
    WebSocketSession getSession();

    String getConnectionId();

    AppAuthentication getAuth();

    void send(OutgoingMessage message);

    void respond(String messageId, Object payload, String error);

    void respond(String messageId, Object result);
}
