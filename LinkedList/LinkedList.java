package LinkedList;

public class LinkedList {

    public static void main(String arg[]){
        Node a = new Node(2);
        a.append(3);
        a.append(1);
        a.append(90);
        a.append(60);
        Node.mergeSort(a).print();
    }
}
