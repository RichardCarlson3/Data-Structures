/*
 * Copyright 2023 Marc Liberatore.
 */
package hashmaps;

import java.util.HashSet;

import java.util.Set;

import hashtables.ChainingHashTable;


/**
 * An implementation of a SimpleMap, built using the ChainingHashTable and 
 * SimpleMapEntry classes. This class should behave similarly to the built-in
 * java.util.HashMap, though it is much simpler!
 */
public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    ChainingHashTable<SimpleMapEntry<K, V>> table;
    
    public SimpleHashMap() {
        // TASK 1: Constructor for SimpleHashMap. Just like any good story, this
        // constructor sets the stage by initializing our ChainingHashTable.
    table = new ChainingHashTable<>();
    }

    @Override
    public int size() {
        // TASK 2: Time to count how many key-value pairs are partying in your
        // SimpleHashMap. Return the current guest count!
        return table.size();
    }

    @Override
    public void put(K k, V v) {
        // TASK 3: Add a new key-value pair to the map, or update it if the
        // key’s already there. Think of it like updating a name tag at a
        // conference—swap the old value out for the new one!
        table.remove(new SimpleMapEntry<>(k, null));
        table.add(new SimpleMapEntry<>(k, v));
    }

    @Override
    public V get(K k) {
        // TASK 4: Retrieve the value for the given key. If it's not there,
        // return `null` like a disappointed parent searching for their missing
        // car keys.
        if(k==null){
            return null;
        }
        SimpleMapEntry<K, V> probe = new SimpleMapEntry<K, V>(k, null);
        SimpleMapEntry<K, V> smp = table.get(probe);
        if(smp==null){
            return null;
        }
        return smp.v;
    }

    @Override
    public V getOrDefault(K k, V defaultValue) {
        // TASK 5: A close cousin to `get()`, but with a safety net! If the key
        // isn't there, return the `defaultValue`. It’s like having a fallback
        // playlist when your favorite song isn’t on Spotify.
        SimpleMapEntry<K, V> probe = new SimpleMapEntry<K, V>(k, null);
        SimpleMapEntry<K, V> smp = table.get(probe);
        if(smp==null){
            return defaultValue;
        }
        return smp.v;
    }

    @Override
    public V remove(K k) {
        // TASK 6: Remove the key-value pair from the map like deleting an
        // embarrassing old tweet. Return the value if successful, otherwise
        // return `null`—no harm, no foul.
        V previous = get(k);
        if(previous!=null){
            table.remove(new SimpleMapEntry<K, V>(k, null));
        }
        return previous;
    }

    @Override
    public Set<K> keys() {
        // TASK 7: Collect all the keys like you're on a treasure hunt. Store
        // them in a Set, because duplicates are for amateurs. Return your
        // shiny key collection!
        Set<K> keySet = new HashSet<K>();
        for (SimpleMapEntry<K, V> i : table) {
            keySet.add(i.k);
        }
        return keySet;
    }
}