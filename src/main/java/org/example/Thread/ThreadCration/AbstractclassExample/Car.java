package org.example.Thread.ThreadCration.AbstractclassExample;

public abstract class Car {
    int mileage;
    Car(int mileage){
        this.mileage = mileage;
    }
    public abstract void pressbreak();
    public abstract void pressclutch();
    public int getNumberofWheels(){
        return 4;
    }
}
