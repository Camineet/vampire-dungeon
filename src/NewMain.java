
import dungeon.Dungeon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marc
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon(10, 5, true);
        dungeon.run();
    }

}
