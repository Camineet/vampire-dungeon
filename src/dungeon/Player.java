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
public class Player implements Character {

    private int x;
    private int y;
    private int moves;
    private int steps;
    private char[] stepChars;

    public Player() {
        this.x = 0;
        this.y = 0;
        this.steps = 0;
    }

    public void loadMoves(int moveCount) {
        this.moves = moveCount;
    }

    public void move(String step) {
        switch (step) {
            case "a":
                this.x -= 1;
                if (this.x < 0) {
                    this.x = 0;
                }
                break;
            case "w":
                this.y -= 1;
                if (this.y < 0) {
                    this.y = 0;
                }
                break;
            case "d":
                this.x += 1;
                if (this.x > 9) {
                    this.x = 9;
                }
                break;
            case "s":
                this.y += 1;
                if (this.y > 4) {
                    this.y = 4;
                }
                break;
        }
    }

    public void collectSteps(String steps) {
        this.stepChars = steps.toCharArray();
    }

    public char[] getStepChars() {
        return stepChars;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.x;
        hash = 71 * hash + this.y;
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
        final Player other = (Player) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    public void decrementMoves() {
        this.moves--;
    }

    @Override
    public String toString() {
        return "@ " + this.x + " " + this.y;
    }
}
