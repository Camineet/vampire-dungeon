/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Marc
 */
public class BoardRow {

    private String[] row;
    private Gaggle gaggle;

    public BoardRow(int length, Gaggle gaggle) {
        this.row = new String[length];
        this.gaggle = gaggle;
    }

     public String[] getRow() {
        return row;
    }

    public void addElements(Gaggle gaggle) {
        for (Vampire vampire : gaggle.getVampires()) {
            for (int i = 0; i < row.length; i++) {
                row[i] = ".";
            }
            row[vampire.getX()] = "V";

        }
    }

    public void printRow() {
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i]);
        }
    }
}
