package bai_tap.bai1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Grape");

        System.out.println("Size: " + list.size());
        System.out.println("Contains: " + list.contains("Banana"));
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println(list.indexOf("Apple"));
        System.out.println(list.indexOf("Orange"));

        list.remove(1);
        System.out.println("Size after remove: " + list.size());
        System.out.println("Data: " + Arrays.toString(list.getData()));

    }

}
