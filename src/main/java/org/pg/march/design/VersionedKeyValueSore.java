package org.pg.march.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VersionedKeyValueSore {

    private static String EXIT = "exit";
    
    private int globalVersion;
    Map<String, TreeMap<Integer,Integer>> versionMap;
    
    public VersionedKeyValueSore() {
        this.versionMap = new HashMap<>();
    }
    
    public void put(String key, Integer value) {
        if(key == null || value == null) {
            throw new IllegalArgumentException();
        }
        TreeMap<Integer,Integer> keyMap = versionMap.get(key);
        if(keyMap == null) {
            keyMap = new TreeMap<>();
            versionMap.put(key, keyMap);
        }
        keyMap.put(++globalVersion, value);
    }
    
    public Integer get(String key) {
        if(key == null) {
            throw new IllegalArgumentException();
        }
        TreeMap<Integer,Integer> keyMap = versionMap.get(key);
        if(keyMap != null) {
            return keyMap.lastEntry().getValue();
        }
        return null;
    }
    
    public Integer get(String key, Integer version) {
        if(key == null || version == null) {
            throw new IllegalArgumentException();
        }
        TreeMap<Integer,Integer> keyMap = versionMap.get(key);
        if(keyMap != null) {
            Map.Entry<Integer,Integer> entry = keyMap.floorEntry(version);
            if(entry != null) return entry.getValue();
        }
        return null;
    }
    
    private int getVersion() {
        return globalVersion;
    }
    
    private static enum Operation{
        GET, PUT, INVALID;
        
        public static Operation fromString(String op) {
            if(op != null) {
                for(Operation operation : Operation.values()) {
                    if(operation.name().equalsIgnoreCase(op)) {
                        return operation;
                    }
                }
            }
            return INVALID;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = null;
        VersionedKeyValueSore keyStore = new VersionedKeyValueSore();
        try {
            scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            while(input != null && !EXIT.equalsIgnoreCase(input)) {
                String[] inputToken = input.split(" ");
                int length = inputToken.length;
                if(length < 2 || length > 3) {
                    System.err.println(String.format("Invalid input [%s]", input));
                    input = scanner.nextLine();
                    continue;
                }
                
                Operation operation = Operation.fromString(inputToken[0]);
                
                Integer operand = null;
                if(length == 3) {
                    try {
                        operand = Integer.parseInt(inputToken[2]);
                    }catch(Exception e) {
                        System.err.println(String.format("Invalid integer in [%s]", input));
                        input = scanner.nextLine();
                        continue;
                    }
                }
                if(operation == Operation.PUT && length == 3) {
                    keyStore.put(inputToken[1], operand);
                    System.out.println(operation+"(#" +keyStore.getVersion()+") " + inputToken[1] + " = " + operand);
                }else if(operation == Operation.GET && length == 2) {
                    Integer value = keyStore.get(inputToken[1]);
                    System.out.println(operation + " " + inputToken[1] + " = "+ value);
                }else if(operation == Operation.GET && length == 3) {
                    Integer value = keyStore.get(inputToken[1], operand);
                    System.out.println(operation + " " + inputToken[1] +"(#" + operand + ")" + " = "+ value);
                }else {
                    System.err.println(String.format("Invalid operation in [%s]", input));
                }
                input = scanner.nextLine();
            }
        }finally {
            if(scanner != null) {
                try {
                    scanner.close();
                }catch(IllegalStateException io) {}
            }
        }
    }
    
}
