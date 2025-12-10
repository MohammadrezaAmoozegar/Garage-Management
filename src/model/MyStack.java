package model;
public class MyStack{
    private MyLinkedList list;
    private int capacity;
    public MyStack(int capacity){
        this.capacity = capacity;
        this.list = new MyLinkedList();
    }
    //O(1)
    public boolean isEmpty(){
        return list.isEmpty();
    }
    //O(1)
    public boolean isFull(){
        return list.size() == capacity;
    }
    //O(n)
    public void push(Car car){
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        list.addLast(car);
    }
    //O(n)
    public Car pop(){
        if (isEmpty()) return null;
        return list.removeAt(list.size() - 1);
    }
    //O(n)
    public Car peek(){
        if (isEmpty()) return null;
        return list.getAt(list.size() - 1);
    }
    //O(1)
    public int size(){
        return list.size();
    }
    public MyLinkedList getList(){
        return list;
    }
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    Node temp = list.getHead();
    while (temp != null) {
        sb.append(temp.data.getCarId()).append("\n"); 
        temp = temp.next;
    }
    return sb.toString();
}

}
