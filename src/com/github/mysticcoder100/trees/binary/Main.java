package com.github.mysticcoder100.trees.binary;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // 4
        Person p1 = new Person(1L, "Ali", "Yusuf");
        // 2
        Person p2 = new Person(2L, "Maryam", "Bello");
        // 6
        Person p3 = new Person(3L, "John", "Doe");
        // 8
        Person p4 = new Person(4L, "Jane", "Smith");
        // 1
        Person p5 = new Person(5L, "Ahmed", "Khan");
        // 5
        Person p6 = new Person(6L, "Fatima", "Zara");
        // 7
        Person p7 = new Person(7L, "David", "Brown");
        //3
        Person p8 = new Person(8L, "Grace", "Johnson");

        tree.insert(p5);
        tree.insert(p2);
        tree.insert(p8);
        tree.insert(p1);
        tree.insert(p6);
        tree.insert(p3);
        tree.insert(p7);
        tree.insert(p4);

//        tree.display();

        Node result = tree.find(2L);
        System.out.println(result.data.toString());
    }
}
