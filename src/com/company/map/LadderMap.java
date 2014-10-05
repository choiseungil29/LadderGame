package com.company.map;

import com.company.player.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Pooh on 2014-10-06.
 */
public class LadderMap {
    private int[][] map;
    private final int height;
    private final int width;
    private ArrayList<Player> players;

    public LadderMap(int playerCount) { // create random laddermap
        Random random = new Random();
        width = playerCount;
        height = random.nextInt(100);
        map = new int[width][height];
        players = new ArrayList<Player>();

        for(int i=0; i<width; i++) {
            Player player = new Player(i, height);
            players.add(player);
        }

        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                map[i][j] = 0;
            }
        }

        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                if((i == width - 1) ||
                        (j == 0) ||
                        (j == height - 1)) {
                    continue;
                }

                if(map[i][j] != 0) {
                    continue;
                }

                if(random.nextInt(3) == 0) { // 1/3확률로 다리를 생성한다.
                    map[i][j] = 1;
                    map[i+1][j] = -1;
                }
            }
        }
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

            this.displayPlayersStatus();
        }
    }

    public void displayPlayersStatus() {
        for(int i=0; i<players.size(); i++) {
            System.out.println("" + (i+1) + "번쨰 플레이어의 위치 : " + players.get(i).getPositionX());
        }
        System.out.println();
    }
}
