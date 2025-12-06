package model;
public class ParkingManager{
    private MyStack[] stacks;
    private MyQueue queue;
    private int n;
    private int m;
    public ParkingManager(int n, int m){
        this.n = n;
        this.m = m;
        stacks = new MyStack[n];
        for (int i = 0; i < n; i++){
            stacks[i] = new MyStack(m);
        }
        queue = new MyQueue();
    }
    public String addCarToFirstAvailable(int carId){
        Car car = new Car(carId);
        if (!queue.isEmpty()){
            queue.enqueue(car);
            return "Parking is full. Car added to queue.";
        }
        for (int i = 0; i < n; i++){
            if (!stacks[i].isFull()){
                stacks[i].push(car);
                return "Car " + carId + " added to stack " + (i + 1);
            }
        }
        queue.enqueue(car);
        return "Parking full. Car moved to queue.";
    }
    public String addCarToStack(int carId, int stackNumber){
        int index = stackNumber - 1;
        if (index < 0 || index >= n){
            return "Invalid stack number.";
        }
        MyStack stack = stacks[index];
        if (stack.isFull()){
            return "Stack " + stackNumber + " is full.";
        }
        Car car = new Car(carId);
        stack.push(car);
        return "Car " + carId + " added to stack " + stackNumber;
    }
    public String removeFromStack(int stackNumber){
        int index = stackNumber - 1;
        if (index < 0 || index >= n) return "Invalid stack number.";
        MyStack stack = stacks[index];
        if (stack.isEmpty()) return "Stack is empty.";
        Car removed = stack.getList().removeAt(0);
        if (removed == null) return "Cannot remove — not at front.";
        return "Removed car " + removed.getCarId() + " from stack " + stackNumber;
    }
    public String find(int carId){
        for (int i = 0; i < n; i++){
            Node temp = stacks[i].getList().getHead();
            int pos = 0;
            while (temp != null){
                if (temp.data.getCarId() == carId){
                    return "Car found in stack " + (i + 1) + ", position " + pos;
                }
                temp = temp.next;
                pos++;
            }
        }
        return "Car not found.";
    }
    public void sortStack(int stackNumber){
        int index = stackNumber - 1;
        MyStack stack = stacks[index];
        Node head = stack.getList().getHead();
        Node sortedHead = mergeSort(head);
        MyLinkedList newList = new MyLinkedList();
        Node temp = sortedHead;
        while (temp != null) {
            newList.addLast(temp.data);
            temp = temp.next;
        }
        stacks[index] = new MyStack(m);
        temp = newList.getHead();
        while (temp != null){
            stacks[index].push(temp.data);
            temp = temp.next;
        }
    }
    private Node mergeSort(Node head){
        if (head == null || head.next == null) return head;
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;
        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(right);
        return merge(leftSorted, rightSorted);
    }
    private Node merge(Node a, Node b){
        if (a == null) return b;
        if (b == null) return a;
        if (a.data.getCarId() < b.data.getCarId()){
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }
    private Node getMid(Node head){
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public String swapStacks(int i, int j){
        int a = i - 1;
        int b = j - 1;
        if (a < 0 || a >= n || b < 0 || b >= n) return "Invalid stack numbers.";
        MyStack temp = stacks[a];
        stacks[a] = stacks[b];
        stacks[b] = temp;
        return "Stacks " + i + " and " + j + " swapped.";
    }
    public MyStack[] getStacks(){
        return stacks;
    }
    public MyQueue getQueue(){
        return queue;
    }
}