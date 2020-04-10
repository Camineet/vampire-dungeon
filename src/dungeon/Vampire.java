/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author Marc
 */
public class Vampire implements Character {

    private int x;
    private int y;
    private Random random;

    public Vampire() {
        random = new Random();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.x;
        hash = 61 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vampire other = (Vampire) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int length, int height) {
//        this.x -= 1;
        int move = random.nextInt(4);
        switch (move) {
            case 0:
                this.x -= 1;

                if (this.x < 0) {
                    this.x = 0;
                }
                break;

            case 1:
                this.y += 1;
                if (this.y > height - 1) {
                    this.y = height - 1;
                }
                break;

            case 2:
                this.x += 1;
                if (this.x > length - 1) {
                    this.x = length - 1;
                }
                break;
            case 3:
                this.y -= 1;
                if (this.y < 0) {
                    this.y = 0;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "V " + this.x + " " + this.y;
    }
}
