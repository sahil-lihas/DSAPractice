public class LinkedList {

    public static class Node{
        int val;
        Node next;

        Node(int value, Node next){
            this.val = value;
            this.next = next;
        }

        Node(int val){
            this.val=val;
        }

        public void print(){
            Node n = this;
            while(n != null)
            {
                System.out.println(n.val);
                n = n.next;
            }

        }

        public static Node reverse(Node head){
            Node prev = null;
            Node curr = head;
            Node next = null;
            while(curr !=null){
                next = curr.next;
                curr.next = prev;
                prev=curr;
                curr = next;
            }
            head = prev;
            return head;
        }

        public static void printMiddle(Node head){
            if(head == null)
                return;
            //else
            Node curr = head;
            int len = 0;
            while(curr != null){
                len++;
                curr = curr.next;
            }
            curr=head;
            len=len/2;
            while(--len > 0)
                curr=curr.next;
            System.out.println(curr.next.val);
        }

        public static Node mergeAndSort(Node n, Node m){
            Node merged = new Node(Integer.MIN_VALUE);
            Node currentMerged = merged;
            Node currN = n;
            Node currM = m;
            while(currN.next!= null || currM.next!=null){
                if(currN.val < currM.val) {
                    currentMerged.next = currN;
                    currentMerged = currentMerged.next;
                    currN = currN.next;
                }
                else if(currM.val <= currN.val) {
                    currentMerged.next = currM;
                    currentMerged = currentMerged.next;
                    currM = currM.next;
                }
            }
            while(currN.next!= null)
            {
                currentMerged.next = currN;
                currN = currN.next;
            }

            while(currM.next!= null)
            {
                currentMerged.next = currM;
                currM = currM.next;
            }
            return merged.next;
        }

    }

    public static void main(String a[]){
        //init
        //2->4->7->8->9->null
        Node n = new Node(2, new Node(4, new Node(7, new Node(8, new Node(9)))));
        //3->3->5->8->9->null
        Node m = new Node(3, new Node(3, new Node(5, new Node(8, new Node(9)))));
        Node merg = Node.mergeAndSort(n,m);
        merg.print();
        Node.reverse(merg).print();
    }
}
