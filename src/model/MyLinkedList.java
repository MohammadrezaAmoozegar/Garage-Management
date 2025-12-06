package model;
public class MyLinkedList{
    private Node head;
    private int size;
    public MyLinkedList(){
        head = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void addLast(Car car){
        Node newNode = new Node(car);
        if (head == null){
            head = newNode;
        } else{
            Node tmp = head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        size++;
    }
    public Car removeFirst(){
        if (isEmpty()) return null;
        Car removed = head.data;
        head = head.next;
        size--;
        return removed;
    }
    public Car removeAt(int index){
        if (index < 0 || index >= size) return null;
        if (index == 0) return removeFirst();
        Node tmp = head;
        for (int i = 0; i < index - 1; i++){
            tmp = tmp.next;
        }
        Car removed = tmp.next.data;
        tmp.next = tmp.next.next;
        size--;
        return removed;
    }
    public Car getAt(int index){
        if (index < 0 || index >= size) return null;
        Node tmp = head;
        for (int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return tmp.data;
    }
    public Node getHead(){
        return head;
    }
}
