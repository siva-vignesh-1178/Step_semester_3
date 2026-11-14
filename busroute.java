import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static Node build(String[] stops) {
        Node head = null;
        Node temp = null;

        for (String stop : stops) {
            Node newNode = new Node(stop);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        return head;
    }

    static void printRoute(Node head) {
        Node temp = head;
        int count = 0;
        String first = "";
        String last = "";

        while (temp != null) {
            if (count == 0)
                first = temp.data;

            last = temp.data;
            count++;

            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count +
                ", First: " + first +
                ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] stops = new String[n];

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        Node head = build(stops);
        printRoute(head);
    }
}