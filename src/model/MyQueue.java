package model;
public class MyQueue{
    private MyLinkedList list;
    public MyQueue(){
        this.list = new MyLinkedList();
    }
    public void enqueue(Car car){
        list.addLast(car);
    }
    public Car dequeue(){
        return list.removeFirst();
    }
    public Car front(){
        return list.getAt(0);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int size(){
        return list.size();
    }
}
