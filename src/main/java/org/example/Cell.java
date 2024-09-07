package org.example;


public class Cell {
    private boolean alive;

    Cell(boolean alive) {
        this.alive = alive;
    }


    public void update(int liveNeighbours) {
        if (liveNeighbours == 1) {
            this.alive = false;
        }

        if(liveNeighbours == 3 && !alive){
            this.alive = true;
        }

        if (liveNeighbours == 2 || liveNeighbours == 3) {
            this.alive = true;
        }

        if(liveNeighbours>3 && liveNeighbours<=8){
            this.alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setState(boolean state){
        alive = state;
    }
}
