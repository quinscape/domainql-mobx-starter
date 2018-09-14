package de.quinscape.dqlmobx.ws;

import de.quinscape.domainql.param.ParameterProvider;
import de.quinscape.domainql.param.ParameterProviderFactory;
import org.springframework.context.ApplicationContext;

import java.lang.annotation.Annotation;

public final class DQLMobxClientConnectionProviderFactory
    implements ParameterProviderFactory
{
    private final ApplicationContext applicationContext;


    public DQLMobxClientConnectionProviderFactory(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }


    @Override
    public ParameterProvider createIfApplicable(Class<?> parameterClass, Annotation[] annotations) throws Exception
    {
        if (parameterClass.equals(DQLMobxClientConnection.class))
        {
            return new DQLMobxClientConnectionProvider(applicationContext.getBean(DQLMobxWebSocketHandler.class));
        }
        return null;
    }
}
