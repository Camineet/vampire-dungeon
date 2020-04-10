/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marc
 */
public class Board {

    private List<String[]> rows = new ArrayList<String[]>();
    private int length;
    private int height;
    private Gaggle gaggle;
    private Player player;

    public Board(int length, int height, Gaggle gaggle, Player player) {
        this.rows = new ArrayList<String[]>();
        this.length = length;
        this.height = height;
        this.gaggle = gaggle;
        this.player = player;
        buildBoard();
    }

    public void buildBoard() {
        for (int i = 0; i < height; i++) {
            this.rows.add(new String[length]);
        }
        fillBoard();
        addElements();
    }

    public void fillBoard() {
        for (String[] row : rows) {
            for (int i = 0; i < this.length; i++) {
                row[i] = ".";
            }

        }
    }

//    public void addElements() {
//        Map<Integer, Integer> coordinates = new HashMap<Integer, Integer>();
//        for (Vampire vampire : gaggle.getVampires()) {
//            coordinates.put(vampire.getX(), vampire.getY());
//        }
//        rows.get(coordinates.)
//    }
    public void addElements() {

        for (Vampire vampire : gaggle.getVampires()) {
            rows.get(vampire.getY())[vampire.getX()] = "V";
        }
        rows.get(player.getY())[player.getX()] = "@";

    }

    public void printBoard() {
        fillBoard();
        addElements();
        for (String[] row : rows) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
            }
            System.out.println("");

        }

    }
}
