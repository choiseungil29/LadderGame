package com.company;

import com.company.map.LadderMap;

import java.util.Scanner;

public class Main {

    private static Game game;

    public static void main(String[] args) {
	// write your code here
        // 사다리타기를 만들어봅시다

        game = new Game();
        game.start();
        game.update();
        game.end();
    }
}
