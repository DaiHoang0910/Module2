package bai_tap.bai2;

import bai_tap.bai1.MyList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add(0, "apple");
        list.add(1, "orange");
        list.add(2, "banana");

        System.out.println("Size: " + list.size());
        list.printList();

        list.remove(1);

        System.out.println("\n" +"After remove: ");
        list.printList();
    }
}
