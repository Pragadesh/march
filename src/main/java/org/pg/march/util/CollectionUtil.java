package org.pg.march.util;

import java.util.Collection;
import java.util.Iterator;

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
    
    public static <T> boolean containsAll(Collection<T> source, Collection<T> destination) {
        if(source == null && destination == null) {
            return true;
        }
        if(source == null || destination == null) {
            System.out.println("One of the collection is empty.");
            return false;
        }
        if(source.size() != destination.size()) {
            System.out.println("Size of collection do not match");
            return false;
        }
        Iterator<T> itr1 = source.iterator();
        Iterator<T> itr2 = destination.iterator();
        while(itr1.hasNext() || itr2.hasNext()) {
            try {
                T t1 = itr1.next();
                T t2 = itr2.next();
                if(!t1.equals(t2)) {
                    System.out.println(String.format("Mismatched elements", t1, t2));
                    return false;
                }
            }catch(Exception e) {
                e.printStackTrace();
                return false;
            }
            
        }
        return true;
    }
}
