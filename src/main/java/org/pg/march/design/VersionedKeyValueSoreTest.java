package org.pg.march.design;

public class VersionedKeyValueSoreTest {

    
    
    
    public static void main(String[] args) {
        VersionedKeyValueSore keyStore= new VersionedKeyValueSore();
        keyStore.put("key1", 5);
        keyStore.put("key2", 6);
        System.out.println(keyStore.get("key1"));
        System.out.println(keyStore.get("key1", 1));
        System.out.println(keyStore.get("key2", 2));
        keyStore.put("key1", 7);
        System.out.println(keyStore.get("key1", 1));
        System.out.println(keyStore.get("key1", 2));
        System.out.println(keyStore.get("key1", 3));
        System.out.println(keyStore.get("key4"));
        System.out.println(keyStore.get("key1", 4));
        System.out.println(keyStore.get("key2", 1));
    }
}
