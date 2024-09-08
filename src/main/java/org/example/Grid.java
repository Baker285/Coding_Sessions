package org.example;

public class Grid {

    private final int rows;
    private final int columns;
    private final Cell[][] cells;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.cells[i][j] = new Cell(false);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean getCellState(int row, int column) {
        return cells[row][column].isAlive();
    }

    public void setCellState(int row, int col, boolean state) {
        cells[row][col].setState(state);
    }

    public boolean checkPresence(int row, int col) {
        return row <= this.rows - 1 && col <= this.columns - 1;
    }

    public int liveNeighboursForCentre() {
        return 8;
    }

    public int liveNeighboursForEdgeCell(int row, int col) {
        if ((row > 0 && row < this.rows - 1) || (col > 0 && col < this.columns - 1)) {
            return 5;
        }
        return -1;
    }

    public int liveNeighboursForCornerCell(int row,int col){
        if((row==0 && col==0) || (row==0 && col==this.columns-1) || (row==this.rows-1 && col==0) || (row==this.rows-1 && col==this.columns-1)){
            return 3;
        }
        return -1;
    }

    public int deadNeighbourCountForBoundaryCells(int row,int col){
        if(this.liveNeighboursForCornerCell(row,col)==3){
            return 4;
        }
        else if(this.liveNeighboursForEdgeCell(row,col)==5){
            return 3;
        }
        return -1;
    }
}
