package com.company.player;

import com.company.map.MapItem;

/**
 * Created by Pooh on 2014-10-06.
 */
public class Player {
    private int x;
    private int y;
    private final int limitY;
    private boolean movedBeforeTurn = false;
    private boolean finishMoved = false;

    public Player(int position, int height) {
        x = position;
        y = 0;
        limitY = height;
    }

    public void update(final MapItem[][] map) {

        if(y >= limitY - 1) {
            finishMoved = true;
            return;
        }

        if(movedBeforeTurn == true) {
            y++;
            movedBeforeTurn = false;
            return;
        }

        if(map[x][y].getDirection() == MapItem.DIR_DEFAULT) {
            y++;
            return;
        }

        int originX = x;

        x += map[originX][y].getDirection();
        y = map[originX][y].getDestinationLocation();
        movedBeforeTurn = true;
    }

    public int getPositionX() {
        return x;
    }

    public boolean isFinishMoved() {
        return finishMoved;
    }
}
