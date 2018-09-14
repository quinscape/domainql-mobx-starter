package de.quinscape.dqlmobx.util;

import java.util.Collection;
import java.util.Iterator;

public final class Util
{
    private Util()
    {

    }

    public static String joinWithComma(Collection<?> c)
    {
        return join(c, ", ");
    }

    public static String join(Collection<?> collection, String sep)
    {
        if (collection == null)
        {
            throw new IllegalArgumentException("collection can't be null");
        }

        if (sep == null)
        {
            throw new IllegalArgumentException("sep can't be null");
        }

        final StringBuilder buff = new StringBuilder();
        for (Iterator<?> iterator = collection.iterator(); iterator.hasNext(); )
        {
            Object o = iterator.next();

            buff.append(o);

            if (iterator.hasNext())
            {
                buff.append(sep);
            }
        }
        return buff.toString();
    }


}
