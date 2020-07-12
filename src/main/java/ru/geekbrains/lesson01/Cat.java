package ru.geekbrains.lesson01;

public class Cat implements JumpingAndRunning {

    private float jumpHeight;
    private float runLength;

    public Cat() {
    }

    public Cat(float jumpHeight, float runLength) {
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public float getRunLength() {
        return runLength;
    }

    public void setRunLength(float runLength) {
        this.runLength = runLength;
    }
}
