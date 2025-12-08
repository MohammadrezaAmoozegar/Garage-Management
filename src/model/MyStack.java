package model;
public class MyStack{
    private MyLinkedList list;
    private int capacity;
    public MyStack(int capacity){
        this.capacity = capacity;
        this.list = new MyLinkedList();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public boolean isFull(){
        return list.size() == capacity;
    }
    public void push(Car car){
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        list.addLast(car);
    }
    public Car pop(){
        if (isEmpty()) return null;
        return list.removeAt(list.size() - 1);
    }
    public Car peek(){
        if (isEmpty()) return null;
        return list.getAt(list.size() - 1);
    }
    public int size(){
        return list.size();
    }
    public MyLinkedList getList(){
        return list;
    }
}
