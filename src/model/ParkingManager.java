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
}
