package com.runar.linkedlist;

/**
 * Created by rsverrisson on 05-07-2018.
 */
public abstract class ListEntry<T> {
    protected ListEntry previous;
    protected ListEntry next;
    protected T value;

    public ListEntry<T> getPrevious() {
        return previous;
    }

    public Boolean hasPrevious() {
        if (previous != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean hasNext() {
        if (next != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setPrevious(ListEntry previous) {
        this.previous = previous;
    }

    public ListEntry<T> getNext() {
        return next;
    }

    public void setNext(ListEntry next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract int compareTo(T otherValue);

}
