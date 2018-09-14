package de.quinscape.dqlmobx.ws;

import de.quinscape.domainql.param.ParameterProvider;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.util.StringUtils;

public final class DQLMobxClientConnectionProvider
    implements ParameterProvider
{

    private final DQLMobxWebSocketHandler DQLMobxWebSocketHandler;


    public DQLMobxClientConnectionProvider(DQLMobxWebSocketHandler DQLMobxWebSocketHandler)
    {

        this.DQLMobxWebSocketHandler = DQLMobxWebSocketHandler;
    }


    @Override
    public Object provide(DataFetchingEnvironment environment)
    {
        final String connectionId = environment.getContext();
        if (!StringUtils.hasText(connectionId))
        {
            throw new IllegalStateException("No connection id found in data fetching environment context.'");
        }

        final DQLMobxClientConnection clientConnection = DQLMobxWebSocketHandler.getClientConnection(connectionId);
        if (clientConnection == null)
        {
            throw new IllegalStateException("No client connection for id '" + connectionId + "' from data fetching environment context.");
        }

        return clientConnection;
    }
}
