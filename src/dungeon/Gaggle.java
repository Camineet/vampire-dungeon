/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Marc
 */
public class Gaggle implements Character {

    private List<Vampire> vampires;
    private Random random;
    private int vampireCount;

    public Gaggle(int vampireCount) {
        this.vampires = new ArrayList<Vampire>();
        this.random = new Random();
        this.vampireCount = vampireCount;
    }

    public void deployGaggle(int length, int height, Player player) {

        Set<Vampire> vampireSet = new HashSet<Vampire>();
        Vampire vampire0 = new Vampire();
        vampire0.setX(0);
        vampire0.setY(0);
        for (int i = 0; i < vampireCount; i++) {
            Vampire vampire = new Vampire();
            vampire.setX(random.nextInt(length));
            vampire.setY(random.nextInt(height));
            vampires.add(vampire);
        }
        while (!(vampires.size() == vampireSet.size() && !vampires.contains(vampire0))) {
            vampireSet.clear();
            for (Vampire vampire : vampires) {
                vampire.setX(random.nextInt(length));
                vampire.setY(random.nextInt(height));
                vampireSet.add(vampire);
            }
        }
    }

    public boolean fight(Player player, Vampire vampire) {
        boolean killed = false;
        if (player.getX() == vampire.getX() && player.getY() == vampire.getY()) {
            killed = true;
        }

        return killed;
    }

    public void moveGaggle(Player player, int length, int height) {
        Vampire toBeRemoved = new Vampire();
        for (Vampire vampire : vampires) {

            Vampire vampirey = vampire;

            vampirey.move(length, height);
            if (!vampires.contains(vampirey)) {
                vampire = vampirey;
            }
            if (fight(player, vampire)) {
                toBeRemoved = vampire;
                break;
            }

        }

        vampires.remove(toBeRemoved);
        if (vampires.size()== 0) {
            System.out.println("Congratulations! You killed all the vampires :D");
        }
    }

    public List<Vampire> getVampires() {
        return vampires;
    }

    @Override
    public String toString() {
        String printout = "";
        for (Vampire vampire : this.vampires) {
            printout += vampire.toString() + "\n";
        }
        return printout;
    }
}
