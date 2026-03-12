package org.example.Thread.ThreadCration.GenericClassExample;

import java.util.List;

public class Pair<K,V>{
    private K key;
    private V value;
    public void put(K key ,V value){
        this.key = key;
        this.value = value;
        System.out.println(key);
        System.out.println(value);
    }

    


}
