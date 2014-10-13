package com.company.map;

/**
 * Created by CLogic on 2014. 10. 13..
 */
public class MapItem {
    private int direction = 0;
    private int destinationLocation = 0;

    public static final int DIR_RIGHT = 1;
    public static final int DIR_LEFT = -1;
    public static final int DIR_DEFAULT = 0;

    public MapItem() {

    }

    public MapItem(int _direction, int _destinationLocation) {
        direction = _direction;
        destinationLocation = _destinationLocation;
    }

    public void setDirection(int _direction) {
        if(_direction != DIR_LEFT && _direction != DIR_RIGHT) {
            return;
        } // 방향을 정할떄 아니면 받아주지 않는다
        direction = _direction;
    }

    public int getDirection() {
        return direction;
    }

    public boolean isDirectionDefault() {
        if(direction == DIR_DEFAULT) {
            return true;
        }
        return false;
    }

    public void setDestinationLocation(int _destinationLocation) {
        destinationLocation = _destinationLocation;
    }

    public int getDestinationLocation() {
        return destinationLocation;
    }
}
