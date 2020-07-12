package ru.geekbrains.lesson01;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

//        JumpingAndRunning[] participants = new JumpingAndRunning[3];
//        participants[0] = new Human(1.5F, 1000F);
//        participants[1] = new Cat(2.0F, 1000F);
//        participants[2] = new Robot(3.0F, 2000F);
//
//        Barrier[] barriers = new Barrier[4];
//        barriers[0] = new Wall(1.5F);
//        barriers[1] = new Wall(1.8F);
//        barriers[2] = new TreadMill(2000F);
//        barriers[3] = new TreadMill(1000F);
//
//        for (Barrier barrier : barriers) {
//            for (int i = 0; i < participants.length; i++) {
//                if (participants[i] == null) continue;
//
//                if (barrier instanceof Wall) {
//                    Wall wall = (Wall) barrier;
//                    if (wall.jump(participants[i])) {
//                        System.out.printf("%s it's do it, jump the wall height %.2f%n", participants[i].getClass().getSimpleName(), wall.getWallHeight());
//                    } else {
//                        System.out.printf("%s it's can't do it, jump the wall height %.2f%n", participants[i].getClass().getSimpleName(), wall.getWallHeight());
//                        participants[i] = null;
//                    }
//                } else if (barrier instanceof TreadMill) {
//                    TreadMill treadMill = (TreadMill) barrier;
//                    if (treadMill.run(participants[i])) {
//                        System.out.printf("%s it's do it, jump the wall height %.2f%n", participants[i].getClass().getSimpleName(), treadMill.getTreadMillLength());
//                    } else {
//                        System.out.printf("%s it's can't do it, jump the wall height %.2f%n", participants[i].getClass().getSimpleName(), treadMill.getTreadMillLength());
//                        participants[i] = null;
//                    }
//                }
//            }
//        }
    }
}