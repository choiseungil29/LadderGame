package com.company.map;

import com.company.player.Player;

import java.util.ArrayList;

/**
 * Created by CLogic on 2014. 10. 13..
 */
public class Map {

    protected MapItem[][] map;
    protected final int height;
    protected final int width;
    protected ArrayList<Player> players;

    public Map(int playerCount, int mapHeight) { // create random laddermap
        //Random random = new Random();
        width = playerCount;
        height = mapHeight;
        map = new MapItem[width][height];
        players = new ArrayList<Player>();

        for(int i=0; i<width; i++) {
            Player player = new Player(i, height);
            players.add(player);
        }

        reset();
    }

    protected void reset() {
        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                map[i][j] = new MapItem(0, 0);
            }
        }
    }

    public void start() {

    }

    public void update() {
        while(true) {
            boolean result = true;
            for(int i=0; i<players.size(); i++) {
                Player player = players.get(i);
                player.update(map);

                if (!player.isFinishMoved()) {
                    result = false;
                }
            }

            if (result == true) {
                return;
            }

            //this.displayPlayersStatus();
        }
    }

    public void displayPlayersStatus() {
        for(int i=0; i<players.size(); i++) {
            System.out.println("" + (i+1) + "번쨰 플레이어의 위치 : " + players.get(i).getPositionX());
        }
        System.out.println();
    }

    public void displayMap() {
        for(int y=0; y<height; y++) {
            for(int x=0; x<width; x++) {
                if(map[x][y].getDirection() == MapItem.DIR_DEFAULT ||
                        map[x][y].getDirection() == MapItem.DIR_RIGHT) {
                    System.out.print(" ");
                }
                System.out.print(" " + map[x][y].getDirection() * map[x][y].getDestinationLocation());
            }
            System.out.println();
        }
    }
}
