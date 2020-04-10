/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Scanner;

/**
 *
 * @author Marc
 */
public class Dungeon {

    private int length;
    private int height;
    private boolean vampiresMove;
    private Player player;
    private int playerMoves;
    private Scanner reader;
    private Gaggle gaggle;
    private Board board;

    public Dungeon(int length, int height, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampiresMove = vampiresMove;
        this.player = new Player();
        this.playerMoves = 0;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public void run() {
        reader = new Scanner(System.in);
        System.out.print("input player moves: ");
        playerMoves = Integer.parseInt(reader.nextLine());
        System.out.print("input number of vampires: ");
        int vampireCount = Integer.parseInt(reader.nextLine());
        this.gaggle = new Gaggle(vampireCount);
        gaggle.deployGaggle(length, height, player);
        this.board = new Board(length, height, gaggle, player);
        printCharacters();
        board.printBoard();

        for (int i = 0; i < playerMoves; i++) {
            turn();
        }
    }

    public void turn() {
        System.out.print("input move steps: ");
        String steps = reader.nextLine();
        player.collectSteps(steps);
        for (char step : player.getStepChars()) {
            String stepe = String.valueOf(step);
            player.move(stepe);
            gaggle.moveGaggle(this.player, this.length, this.height);
        }
        printCharacters();
        board.printBoard();
    }

    public void printCharacters() {
        System.out.println(player);
        System.out.println(gaggle);
    }

}
