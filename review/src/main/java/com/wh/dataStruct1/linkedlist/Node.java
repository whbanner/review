package com.wh.dataStruct1.linkedlist;

class Node{
    String name;
    Node next;

    //双链表
    Node prev;
    Node rear;

    public Node(String name) {
        this.name=name;
    }
}
