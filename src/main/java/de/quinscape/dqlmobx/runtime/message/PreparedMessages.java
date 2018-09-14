package de.quinscape.dqlmobx.runtime.message;

import de.quinscape.dqlmobx.model.message.OutgoingMessage;
import de.quinscape.dqlmobx.ws.DQLMobxClientConnection;
import de.quinscape.dqlmobx.ws.DQLMobxWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

public class PreparedMessages
{
    private final List<PreparedMessage> preparedMessages = new ArrayList<>();

    public PreparedMessages()
    {

    }

    public void add(String connectionId, OutgoingMessage outgoingMessage)
    {
        preparedMessages.add(new PreparedMessage(connectionId, outgoingMessage));
    }


    public List<PreparedMessage> getMessages()
    {
        return preparedMessages;
    }


    public void addAll(List<PreparedMessage> preparedMessages)
    {
        this.preparedMessages.addAll(preparedMessages);
    }

    public void sendAll(DQLMobxWebSocketHandler dqlMobxWebSocketHandler)
    {
        for (PreparedMessage preparedMessage : preparedMessages)
        {
            final DQLMobxClientConnection connection = dqlMobxWebSocketHandler.getClientConnection(preparedMessage.getConnectionId());
            if (connection != null)
            {
                connection.send(preparedMessage);
            }
        }
    }
}
