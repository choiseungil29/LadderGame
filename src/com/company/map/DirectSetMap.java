package com.company.map;

import java.util.Scanner;

/**
 * Created by CLogic on 2014. 10. 13..
 */
public class DirectSetMap extends Map {

    public DirectSetMap(int playerCount, int mapHeight) {
        super(playerCount, mapHeight);
    }

    public void start() {
        Scanner scan = new Scanner(System.in);

        int result = 0;
        do {
            System.out.println("1. 사다리를 추가합니다");
            System.out.println("2. 현재 맵 상태를 봅니다.");
            System.out.println("3. 맵을 리셋합니다");
            System.out.println("4. 사다리타기를 시작합니다.");

            result = scan.nextInt();

            if(result == 1) {
                int x1 = 0;
                int y1 = 0;
                int x2 = 0;
                int y2 = 0;

                System.out.println("x1의 위치를 찍어주세요.");
                x1 = scan.nextInt();
                System.out.println("y1의 위치를 찍어주세요.");
                y1 = scan.nextInt();
                System.out.println("x2의 위치를 찍어주세요.");
                x2 = scan.nextInt();
                System.out.println("y2의 위치를 찍어주세요.");
                y2 = scan.nextInt();

                setTile(x1, y1, x2, y2);
            } else if(result == 2) {
                this.displayMap();
            } else if(result == 3) {
                this.reset();
            }
        } while(result != 4);
    }

    /**
     * Direction map[x1][y1] to map[x2][y2]
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void setTile(int x1, int y1, int x2, int y2) {
        if(Math.abs(x1 - x2) != 1) { // 한칸은 차이나야지 인간적으로
            return;
        }

        if(!(y1 > 0 && y1 < height) ||
                !(y2 > 0 && y2 < height)) {
            return;
        }

        if(!(x1 >= 0 && x1 < width) ||
                !(x2 >= 0 &&x2 < width)) {
            return;
        }

        map[x1][y1].setDirection(x2-x1);
        map[x1][y1].setDestinationLocation(y2);

        map[x2][y2].setDirection(x1-x2);
        map[x2][y2].setDestinationLocation(y1);
    }

    public void update() {
        super.update();
    }
}
