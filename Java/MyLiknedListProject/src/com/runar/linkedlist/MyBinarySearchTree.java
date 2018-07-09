package com.runar.linkedlist;

/**
 * Created by rsverrisson on 06-07-2018.
 */
public class MyBinarySearchTree<T extends Comparable<T>> {
    ListEntry<T> root;
    ListEntry<T> head;
    int depth;

    public void add(T value) {
        if (root != null) {
            add(value, root);
        } else {
            root = new BinarySearchTreeListEntry<T>();
            root.setValue(value);
        }
    }

    public void add(T value, ListEntry<T> node) {
        if ( node.getValue().compareTo(value) < 0 ) {
            if (node.hasNext()) {
                add(value, node.getNext());
            } else {
                BinarySearchTreeListEntry<T> newEntry = new BinarySearchTreeListEntry<T>();
                newEntry.setValue(value);
                newEntry.setParent(node);
                node.setNext(newEntry);
            }
        } else if ( node.getValue().compareTo(value) > 0) {
            if (node.hasPrevious()) {
                add(value, node.getPrevious());
            } else {
                BinarySearchTreeListEntry<T> newEntry = new BinarySearchTreeListEntry<T>();
                newEntry.setValue(value);
                newEntry.setParent(node);
                node.setPrevious(newEntry);
            }
        }
    }

    private void printNode(ListEntry<T> root) {
        if (root != null) {
            if (root.hasPrevious()) {
                printNode(root.getPrevious());
            }
            System.out.println(root.getValue());
            if (root.hasNext()) {
                printNode(root.getNext());
            }
        }
    }

    public void printTree() {
        printNode(root);
    }
}
