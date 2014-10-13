package com.company.map;

/**
 * Created by CLogic on 2014. 10. 13..
 */
public class DirectSetMap extends Map {

    public DirectSetMap(int playerCount, int mapHeight) {
        super(playerCount, mapHeight);
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

        map[x1][y1].setDirection(x1-x2);
        map[x1][y1].setDestinationLocation(y2);

        map[x2][y2].setDirection(x2-x1);
        map[x2][y2].setDestinationLocation(y1);
    }
}
