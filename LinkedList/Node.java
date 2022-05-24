package LinkedList;

public class Node {
    int val;
    Node next;

    Node(int value, Node next) {
        this.val = value;
        this.next = next;
    }

    Node(int val) {
        this.val = val;
    }

    public void print() {
        Node n = this;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public Node reverse() {
        Node head = this;
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public void append(int val){
        Node h = this;
        while(h.next !=null)
            h=h.next;
        h.next = new Node(val);
    }

    public Node prepend(int val){
        Node n = new Node(val);
        n.next = this;
        return n;
    }

    public Node getMiddle() {
        Node head = this;
        if (head == null || head.next==null)
            return head;
        //else
        Node curr = head; Node currpp = head;
        while(currpp.next!=null && currpp.next.next !=null){
            curr = curr.next;
            currpp = currpp.next.next;
        }
        return curr;
    }

    public static Node mergeTwoSortedLists(Node n, Node m) {
        if(n==null)
            return m;
        else if(m==null)
            return n;
        Node merged = new Node(Integer.MIN_VALUE);
        Node currentMerged = merged;
        Node currN = n;
        Node currM = m;
        while (currN != null && currM != null) {
            if (currN.val < currM.val) {
                currentMerged.next = currN;
                currentMerged = currentMerged.next;
                currN = currN.next;
            } else if (currM.val <= currN.val) {
                currentMerged.next = currM;
                currentMerged = currentMerged.next;
                currM = currM.next;
            }
        }
        if(currN != null) {
            currentMerged.next = currN;
        }

        if (currM != null) {
            currentMerged.next = currM;
        }
        return merged.next;
    }

    public static Node mergeSort(Node n) {
        if(n.next == null || n==null)
            return n;
        Node mid = n.getMiddle();
        n.print();
        Node midplusOne = mid.next;
        mid.next = null;
        Node left = mergeSort(n);
        Node right = mergeSort(midplusOne);
        Node res = mergeTwoSortedLists(left, right);
        System.out.println("----------");
        res.print();
        return res;
    }

}