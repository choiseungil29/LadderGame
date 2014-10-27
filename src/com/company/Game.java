package com.company;

import com.company.map.DirectSetMap;
import com.company.map.Map;
import com.company.map.RandomSetMap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Pooh on 2014-10-06.
 */
public class Game {

    //private LadderMap nowMap;
    private Map nowMap;
    private int playerCount = 0;
    private int mapHeight = 50;
    private int mapStatus = 0;
    private ArrayList<Map> mapList;

    public Game() {

    }

    public void start() {
        Scanner scan = new Scanner(System.in);

        System.out.println("사다리타기 게임을 시작합니다.");
        System.out.println("1. 랜덤 맵 사다리타기");
        System.out.println("2. 지정 맵 사다리타기");
        System.out.print("맵을 선택해주세요 : ");

        do {
            mapStatus = scan.nextInt();

            if(mapStatus != 1 &&
                    mapStatus != 2) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            } else {
                break;
            }
        } while(true);

        System.out.print("플레이어 숫자를 입력해주세요. : ");
        do {
            playerCount = scan.nextInt();

            if(playerCount <= 1) {
                System.out.println("잘못된 입력입니다. 2 이상의 숫자를 입력해주세요");
            } else {
                break;
            }
        } while(true);

        mapList = new ArrayList<Map>();
        mapList.add(new RandomSetMap(playerCount, mapHeight));
        mapList.add(new DirectSetMap(playerCount, mapHeight));

        nowMap = mapList.get(mapStatus - 1);

        nowMap.start();
        nowMap.displayPlayersStatus();
        nowMap.displayMap();
    }

    public void update() {
        nowMap.update();
    }

    public void end() {
        System.out.println("게임이 종료되었습니다.");
        System.out.println("다음은 결과입니다.");

        nowMap.displayPlayersStatus();
    }
}
