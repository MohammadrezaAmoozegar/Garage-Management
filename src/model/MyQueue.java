package model;
public class MyQueue{
    private MyLinkedList list;
    public MyQueue(){
        this.list = new MyLinkedList();
    }
    //O(n)
    public void enqueue(Car car){
        list.addLast(car);
    }
    public Car dequeue(){
        return list.removeFirst();
    }
    //O(1)
    public Car front(){
        return list.getAt(0);
    }
    //O(1)
    public boolean isEmpty(){
        return list.isEmpty();
    }
    //O(1)
    public int size(){
        return list.size();
    }
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Front -> ");

    Node temp = list.getHead(); 
    while (temp != null) {
        sb.append(temp.data.getCarId());
        if (temp.next != null) sb.append("  |  "); 
        temp = temp.next;
    }

    sb.append(" <- Rear");
    return sb.toString();
}

}
