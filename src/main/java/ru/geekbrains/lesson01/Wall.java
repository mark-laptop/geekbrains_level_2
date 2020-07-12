package ru.geekbrains.lesson01;

public class Wall implements Barrier {

    private float wallHeight;

    public Wall() {
    }

    public Wall(float wallHeight) {
        this.wallHeight = wallHeight;
    }

    public float getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(float wallHeight) {
        this.wallHeight = wallHeight;
    }

    public boolean jump(JumpingAndRunning action) {
        return action.getJumpHeight() >= wallHeight;
    }
}
