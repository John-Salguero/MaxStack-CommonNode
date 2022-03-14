import MyStack.MyStack;

public class Solution {

    private static void test1() {
        MyStack<Integer> stack = new MyStack<>(Integer::compare);

        int i = 0;
        for(;i < Math.random() * 100 + 1; ++i) {
            stack.push(i);
        }

        for(int j = --i; j >= 0; --j) {
            if(j != stack.max()){
                System.out.println("Test 1 pass: " + false);
                return;
            }
            stack.pop();
        }

        System.out.println("Test 1 pass: " + true);
    }
    private static void test2() {
        MyStack<Integer> stack = new MyStack<>(Integer::compare);
        stack.push(1000);

        int i = 0;
        for(;i < Math.random() * 100 + 1; ++i) {
            stack.push(i);
        }

        for(int j = --i; j >= 0; --j) {
            if(1000 != stack.max()){
                System.out.println("Test 1 pass: " + false);
                return;
            }
            stack.pop();
        }

        System.out.println("Test 2 pass: " + true);
    }
    private static void test3() {
        MyStack<Integer> stack = new MyStack<>(Integer::compare);

        for(int i = 0;i < 1000; ++i) {
            stack.push((int)(Math.random() * 1000 + 1));
        }

        int max = stack.max();
        for(int i = 0; i < 1000; ++i) {
            if(max < stack.max()){
                System.out.println("Test 3 pass: " + false);
                return;
            }
            stack.pop();
            if(!stack.isEmpty())
                max = stack.max();
        }

        System.out.println("Test 3 pass: " + true);
    }
    private static void test4() {
        MyStack<Integer> stack = new MyStack<>(Integer::compare);

        for(int i = 0;i < 1000; ++i) {
            stack.push((int)(Math.random() * 1000 + 1));
        }
        for(int i = 0;i < 1000; ++i) {
            stack.pop();
        }

        boolean didThrow = false;
        try{
            stack.pop();
        } catch (IllegalStateException e) {
            didThrow = true;
        }
        try{
            stack.max();
        } catch (IllegalStateException e) {
            if(didThrow) {
                System.out.println("Test 4 pass: " + true);
                return;
            }
        }

        System.out.println("Test 4 pass: " + false);
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
