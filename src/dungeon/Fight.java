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
public class Fight {

    private Gaggle gaggle;
    private Player player;

    public Fight(Gaggle gaggle, Player player) {
        this.gaggle = gaggle;
        this.player = player;
    }

    public boolean killVampire() {
        boolean killed = false;
        for (Vampire vampire : gaggle.getVampires()) {
            if (player.equals(vampire)) {
                killed = true;
            }
        }
        return killed;
    }

}
