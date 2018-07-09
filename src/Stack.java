public class Stack {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        return;
    }

    public int peek() {
        return top.data;
    }

    public int pop() {

        if (top != null) {
            int data = top.data;
            top = top.next;
            return data;
        }
        return -1;
    }
}
