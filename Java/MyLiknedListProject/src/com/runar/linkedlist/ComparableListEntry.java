package com.runar.linkedlist;

/**
 * Created by rsverrisson on 05-07-2018.
 */
public class ComparableListEntry<T extends Comparable<T>> extends ListEntry<T>{
    @Override
    public int compareTo(T otherValue) {
        return value.compareTo(otherValue);
    }
}
