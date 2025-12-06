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
}
