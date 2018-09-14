package de.quinscape.dqlmobx.runtime.message;


import de.quinscape.dqlmobx.ws.DQLMobxClientConnection;
import de.quinscape.dqlmobx.ws.DQLMobxWebSocketHandler;

public interface ConnectionCloseListener
{

    void onClose(DQLMobxWebSocketHandler webSocketHandler, DQLMobxClientConnection clientConnection);
}
