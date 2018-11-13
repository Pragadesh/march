package org.pg.march.util;

import java.util.Collection;

public class CollectionUtil {

    public static <T> boolean containsAll(Collection<T> dataList, T... values) {
        if(dataList == null || values == null) {
            return true;
        }
        for (T value : values) {
            if(!dataList.contains(value)) {
                System.out.println("Result does not contain: "+value);
                return false;
            }
        }
        return true;
    }
}
