package ru.geekbrains.lesson01;

public class TreadMill implements Barrier {

    private float treadMillLength;

    public TreadMill() {
    }

    public TreadMill(float treadMillLength) {
        this.treadMillLength = treadMillLength;
    }

    public float getTreadMillLength() {
        return treadMillLength;
    }

    public void setTreadMillLength(float treadMillLength) {
        this.treadMillLength = treadMillLength;
    }

    public boolean run(JumpingAndRunning action) {
        return action.getRunLength() >= treadMillLength;
    }
}
