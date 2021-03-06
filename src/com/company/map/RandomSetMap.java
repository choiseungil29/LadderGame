package com.company.map;

import java.util.Random;

/**
 * Created by CLogic on 2014. 10. 13..
 */
public class RandomSetMap extends Map {
    public RandomSetMap(int playerCount, int mapHeight) {
        super(playerCount, mapHeight);

        Random random = new Random();

        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                if((i == width - 1) ||
                        (j == 0) ||
                        (j == height - 1)) {
                    continue;
                }

                if(!map[i][j].isDirectionDefault()) {
                    continue;
                }

                if(random.nextInt(3) == 0) { // 1/3확률로 다리를 생성한다.
                    int location = random.nextInt(height - 2);

                    if(location == 0 ||
                            location == height - 1) {
                        continue;
                    }

                    if(map[i+1][location].getDirection() != MapItem.DIR_DEFAULT) { // 값이 겹치는 예외 처리
                        continue;
                    }

                    map[i][j].setDestinationLocation(location);
                    map[i+1][location].setDestinationLocation(j);

                    map[i][j].setDirection(MapItem.DIR_RIGHT);
                    map[i+1][location].setDirection(MapItem.DIR_LEFT);
                }
            }
        }
    }

    public void start() {
        System.out.println("시작합니다.");
    }


    public void update() {
        super.update();
    }
}
