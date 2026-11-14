import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;
    int size;

    Stack() {
        top = null;
        size = 0;
    }

    void push(String plate) {
        Node newNode = new Node(plate);

        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate +
                " -> top " + plate +
                ", size " + size);
    }

    void pop() {
        if (top == null) {
            System.out.println("pop -> stack is empty");
            return;
        }

        String plate = top.data;

        top = top.next;
        size--;

        System.out.println("pop -> " + plate +
                ", size " + size);
    }

    void peek() {
        if (top == null) {
            System.out.println("peek -> stack is empty");
        } else {
            System.out.println("peek -> " + top.data);
        }
    }

    void isEmpty() {
        if (top == null)
            System.out.println("isEmpty -> true");
        else
            System.out.println("isEmpty -> false");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack stack = new Stack();

        for (int i = 0; i < n; i++) {

            String operation = sc.next();

            if (operation.equals("push")) {
                String plate = sc.next();
                stack.push(plate);
            }

            else if (operation.equals("pop")) {
                stack.pop();
            }

            else if (operation.equals("peek")) {
                stack.peek();
            }

            else if (operation.equals("isEmpty")) {
                stack.isEmpty();
            }
        }
    }
}