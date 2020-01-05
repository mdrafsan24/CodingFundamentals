class customLinkedList {

    static class LinkedList {
        Node head;

        public void insert(int data) {
            Node node = new Node();
            node.data = data;
            node.next = null;

            if (head == null) {
                head = node;
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = node;
            }
        }

        public void insertAtStart(int data) {
            Node node = new Node();
            node.data = data;
            node.next = null;
            node.next = head;
            head = node;
        }

        public void show() {
            Node n = head;
            while (n != null) {
                System.out.print (n.data + " ");
                n = n.next;
            }
        }
    }

    static class Node {
        int data;
        Node next;

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(9);
        list.insert(17);
        list.insert(999);

        list.show();
    }






}
