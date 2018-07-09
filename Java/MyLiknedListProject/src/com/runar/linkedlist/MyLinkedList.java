package com.runar.linkedlist;

/**
 * Created by rsverrisson on 05-07-2018.
 */
public class MyLinkedList<T extends Comparable<T>> {
    ListEntry<T> start;
    ListEntry<T> head;

    public void add(T valueToAdd){
        ComparableListEntry<T> toAdd = new ComparableListEntry<T>();
        toAdd.setValue(valueToAdd);
        if (hasEntry()) {
            head = start;
            while ( head.compareTo(valueToAdd) < 0 && head.hasNext()) {
                next();
            }
            if (head.compareTo(valueToAdd) == 0) {
                System.out.println(valueToAdd.toString() + " is already in the list!");
            } else if (head.compareTo(valueToAdd) > 0) {
                ListEntry<T> previous = head.getPrevious();
                if (head.hasPrevious()) {
                    toAdd.setPrevious(head.getPrevious());
                    head.getPrevious().setNext(toAdd);
                }
                toAdd.setNext(head);
                head.setPrevious(toAdd);
            } else if (!head.hasNext()) {
                toAdd.setPrevious(head);
                head.setNext(toAdd);
            }
        } else {
            start = toAdd;
        }
        head = toAdd;
    }

    public void next() {
        if (hasEntry()) {
            if (head.hasNext()) {
                head = head.getNext();
            } else {
                System.out.println("You are at the end of the list.");
            }
        } else {
            System.out.println("The list does not contain an entry.");
        }
    }

    public void previous() {
        if (hasEntry()) {
            if (head.hasPrevious()) {
                head = head.getPrevious();
            } else {
                System.out.println("You are at the start of the list.");
            }
        } else {
            System.out.println("The list does not contain an entry.");
        }
    }

    private Boolean hasEntry(){
        if ( start == null ) {
            return false;
        }
        return true;
    }

    public ListEntry<T> getEntry(T value) {
        head = start;
        if ( head.getValue().equals(value) ) {
            return head;
        }
        while (head.hasNext()) {
            next();
            if ( head.getValue().equals(value) ) {
                return head;
            }
        }
        return null;
    }

    public Boolean hasEntry(T value) {
        return getEntry(value) != null;
    }

    public void removeEntry(T value) {
        ListEntry<T> entry = getEntry(value);
        if ( entry != null ) {
            if ( entry.hasPrevious() ) {
                if ( entry.hasNext() ) {
                    entry.getPrevious().setNext(entry.getNext());
                    entry.getNext().setPrevious(entry.getPrevious());
                } else {
                    entry.getPrevious().setNext(null);
                }
            } else {
                if ( entry.hasNext() ) {
                    entry.getNext().setPrevious(null);
                }
            }
        }
    }


    public void printList() {
        ComparableListEntry<T> startHead = new ComparableListEntry<T>();
        if (hasEntry()) {
            startHead.setPrevious(head.getPrevious());
            startHead.setNext(head.getNext());
            startHead.setValue(head.getValue());

            head = start;
            System.out.print(head.getValue());
            while (head.hasNext()) {
                next();
                System.out.print(", ");
                System.out.print(head.getValue());
            }
            System.out.println("");
        }

        head = startHead;
    }
}

