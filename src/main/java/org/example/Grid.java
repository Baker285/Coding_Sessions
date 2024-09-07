package org.example;

public class Grid {

    private final int rows;
    private final int columns;
    private final Cell[][] cells;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                this.cells[i][j] = new Cell(false);
            }
        }
    }

    public int getRows(){
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean getCellState(int row, int column) {
        return cells[row][column].isAlive();
    }

    public void setCellState(int row, int col,boolean state) {
        cells[row][col].setState(state);
    }
}
