package org.example.Thread.ThreadCration.AbstractclassExample;

public abstract class LuxuryCar extends Car{
    LuxuryCar(int mileage){
        super(mileage);
    }

    public abstract void PressDualBreakSystem();

    @Override
    public void pressbreak() {

    }
}
