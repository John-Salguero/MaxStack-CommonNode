import java.util.HashSet;

public class Solution {

    static private class Node<T> {
        Node<T> next;
        T data;

        Node(T data) {this.data = data;}
        Node(T data, Node<T> next) {this.data = data; this.next = next;}
        Node() {}
    }


    private static <T> Node<T> commonNode(Node<T> list1, Node<T> list2) {

        HashSet<T> set = new HashSet<>();

        while(list1 != null || list2 != null) {
            if(list1 != null) {
                if (set.contains(list1.data))
                    return list1;
                set.add(list1.data);
                list1 = list1.next;
            }
            if(list2 != null) {
                if (set.contains(list2.data))
                    return list2;
                set.add(list2.data);
                list2 = list2.next;
            }
        }


        return null;
    }

    private static void test1() {
        Node<Integer> head = new Node<>(0);
        Node<Integer> it = head;
        for(int i = 1; i < Math.random()*100; ++i) {
            it.next = new Node<>(i);
            it = it.next;
        }

        Node<Integer> retVal = commonNode(head, head);
        System.out.println("Test 1 worked: " + head.equals(retVal));
    }
    private static void test2() {
        int id = 0;
        Node<Integer> head1 = new Node<>(++id);
        Node<Integer> head2 = new Node<>(++id);
        Node<Integer> common = new Node<>(++id);
        Node<Integer> it = head1;

        for(int i = 1; i < Math.random()*100; ++i) {
            it.next = new Node<>(++id);
            it = it.next;
        }
        it.next = common;
        it = head2;
        for(int i = 1; i < Math.random()*100; ++i) {
            it.next = new Node<>(++id);
            it = it.next;
        }
        it.next = common;

        Node<Integer> retVal = commonNode(head1, head2);
        System.out.println("Test 2 worked: " + common.equals(retVal));

    }
    private static void test3() {
        int id = 0;
        Node<Integer> head1 = new Node<>(++id);
        Node<Integer> head2 = new Node<>(++id);

        Node<Integer> it = head1;
        for(int i = 1; i < Math.random()*100; ++i) {
            it.next = new Node<>(++id);
            it = it.next;
        }
        it = head2;
        for(int i = 1; i < Math.random()*100; ++i) {
            it.next = new Node<>(++id);
            it = it.next;
        }

        Node<Integer> retVal = commonNode(head1, head2);
        System.out.println("Test 3 worked: " + (retVal == null));

    }
    private static void test4() {
        int id = 0;
        Node<Integer> head1 = new Node<>(++id);
        Node<Integer> head2 = new Node<>(++id);
        Node<Integer> common = new Node<>(++id);
        Node<Integer> it = common;
        for(int i = 1; i < Math.random()*100; ++i) {
            it.next = new Node<>(++id);
            it = it.next;
        }
        it = head1;
        for(int i = 1; i < Math.random()*100; ++i) {
            it.next = new Node<>(++id);
            it = it.next;
        }
        it.next = common;
        it = head2;
        for(int i = 1; i < Math.random()*100; ++i) {
            it.next = new Node<>(++id);
            it = it.next;
        }
        it.next = common;

        Node<Integer> retVal = commonNode(head1, head2);
        System.out.println("Test 4 worked: " + common.equals(retVal));
    }
    private static void allTests() {
        test1();
        test2();
        test3();
        test4();
    }

    public static void main(String[] args) {
        for(String option : args) {
            switch(option) {
                case "Test_1":
                    test1();
                    break;
                case "Test_2":
                    test2();
                    break;
                case "Test_3":
                    test3();
                    break;
                case "Test_4":
                    test4();
                    break;
                case "All_Tests":
                    allTests();
            }
        }
    }
}
