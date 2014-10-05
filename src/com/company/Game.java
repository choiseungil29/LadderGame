package com.company;

import com.company.map.LadderMap;

import java.util.Scanner;

/**
 * Created by Pooh on 2014-10-06.
 */
public class Game {

    private LadderMap map;
    private int playerCount = 0;

    public Game() {

    }

    public void start() {
        System.out.println("사다리타기 게임을 시작합니다.");
        System.out.print("플레이어 숫자를 입력해주세요. : ");
        Scanner scan = new Scanner(System.in);
        do {
            playerCount = scan.nextInt();

            if(playerCount <= 1) {
                System.out.println("잘못된 입력입니다. 2 이상의 숫자를 입력해주세요");
            } else {
                break;
            }
        } while(true);

        map = new LadderMap(playerCount);
        map.displayPlayersStatus();
    }

    public void update() {
        map.update();
    }

    public void end() {
        System.out.println("게임이 종료되었습니다.");
        System.out.println("다음은 결과입니다.");

        map.displayPlayersStatus();
    }


}
