package de.quinscape.dqlmobx.runtime;

public class DQLMobxException
    extends RuntimeException
{
    private static final long serialVersionUID = 2074553315181786207L;

    public DQLMobxException(String message)
    {
        super(message);
    }


    public DQLMobxException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public DQLMobxException(Throwable cause)
    {
        super(cause);
    }


    public DQLMobxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
