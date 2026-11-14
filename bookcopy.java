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

    static String find(Node head, String id) {
        Node temp = head;

        int position = 1;
        int copies = 0;
        int firstPosition = -1;

        while (temp != null) {

            if (temp.data.equals(id)) {

                copies++;

                if (firstPosition == -1) {
                    firstPosition = position;
                }
            }

            temp = temp.next;
            position++;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position " +
                firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        for (int i = 0; i < n; i++) {
            String id = sc.next();

            Node newNode = new Node(id);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        String findId = sc.next();

        System.out.println(find(head, findId));
    }
}