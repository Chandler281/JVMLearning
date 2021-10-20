package com.Chandler281;

public class NodeTest<E> {
    private Node head;
    private Node tail;
    private int len = 0;

    class Node {
        E item;
        Node prev;
        Node next;

    Node(
        Node prev, Node next,
        E element)
        {
            this.prev = prev;
            this.next = next;
            this.item = element;
        }
    }

    public void addFirst(E value){
        Node temp = new Node(null, head, value);
        if(head != null){
            head.prev = temp;
        }else{
            tail = temp;
        }
        head = temp;
        len++;
    }

    public void del(E value){
        Node temp = head;

        while(temp != null){
            if(temp.item == value)
                break;
            temp = temp.next;
        }
        if(temp == head){
            head.next.prev = null;
            head = head.next;
            len--;
        }
        else if(temp == tail){
            tail.prev.next = null;
            tail = tail.prev;
            len--;
        }
        else if(temp == null){
            System.out.println("未找到目标");
        }
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            len--;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(len);
        Node temp = head;
        while(temp != null){
            sb.append(temp.item);
            temp = temp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NodeTest nodeTest = new NodeTest();
        nodeTest.addFirst(1);
        nodeTest.addFirst(4);
        nodeTest.addFirst(1);
        nodeTest.del(1);
        nodeTest.del(1);
        System.out.println(nodeTest);
    }

}