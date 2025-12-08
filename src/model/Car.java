package model;
public class Car{
    private int carId;
    public Car(int carId){
        this.carId = carId;
    }
    public int getCarId(){
        return carId;
    }
    @Override
    public String toString(){
        return "Car(" + carId + ")";
    }
}
