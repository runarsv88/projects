package com.runar.linkedlist;

/**
 * Created by rsverrisson on 06-07-2018.
 */
public class BinarySearchTreeListEntry<T extends Comparable<T>> extends ComparableListEntry<T>{
    private ListEntry<T> parent;

    public ListEntry<T> getParent() {
        return parent;
    }

    public void setParent(ListEntry<T> parent) {
        this.parent = parent;
    }
}
