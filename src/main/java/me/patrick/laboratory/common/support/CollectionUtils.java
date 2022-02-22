package me.patrick.laboratory.common.support;

import java.util.Collection;

public class CollectionUtils {

    public static <T> boolean isEmpty(Collection<T> collection) {

        return collection == null || collection.size() == 0;
    }
}
