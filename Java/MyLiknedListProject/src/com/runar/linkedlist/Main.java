package com.runar.linkedlist;

/**
 * Created by rsverrisson on 05-07-2018.
 */
public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> myList = new MyBinarySearchTree<>();
        myList.add(1);
        myList.add(7);
        myList.add(3);
        myList.add(2);
        myList.add(4);
        myList.add(5);
        myList.add(6);


        myList.printTree();

    }
}
