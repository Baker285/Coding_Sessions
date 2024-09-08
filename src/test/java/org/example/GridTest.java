package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @DisplayName("Initialize a grid with all dead cells and confirm its dimensions and cell state")
    @Test
    public void testInitializeGrid(){
        Grid grid = new Grid(5,5);
        assertEquals(5,grid.getRows());
        assertEquals(5,grid.getColumns());

        for(int row = 0;row<5;row++){
            for(int column = 0;column<5;column++){
                assertFalse(grid.getCellState(row,column));
            }
        }
    }

    @DisplayName("Should set and retrieve the state of a specific cell in the grid")
    @ParameterizedTest(name = "Set and retrieve the state of a specific cell")
    @CsvSource({
            "5,5",
            "6,5",
            "4,3",
            "6,6"
    })
    public void testSetStateOfACell(int row,int column){
        Grid grid = new Grid(7,7);
        grid.setCellState(row,column,true);

        assertTrue(grid.getCellState(row, column));
    }

    @DisplayName("Should determine a cell is present inside a grid")
    @ParameterizedTest(name = "Determining presence of a cell inside a grid")
    @CsvSource({
            "5,5",
            "6,5",
            "4,3",
            "6,6"
    })
    public void testToCheckIfACellIsInsideGrid(int row,int col){
        Grid grid = new Grid(7,7);
        assertTrue(grid.checkPresence(row, col));
    }

    @DisplayName("Should determine a cell is present outside a grid")
    @ParameterizedTest(name = "Determining presence of a cell outside a grid")
    @CsvSource({
            "7,7",
            "8,3",
            "8,5",
            "8,1"
    })
    public void testToCheckIfACellIsOutsideGrid(int row,int col){
        Grid grid = new Grid(7,7);
        assertFalse(grid.checkPresence(row, col));
    }

    @DisplayName("Calculate the number of live neighbours for the centre cell in a given grid")
    @ParameterizedTest(name = "Determining number of live neighbours for centre cell")
    @CsvSource({
            "7,7",
            "8,3",
            "8,5",
            "8,1"
    })
    public void testToCalculateNumberOfLiveNeighboursForCentralCell(int row,int col){
        Grid grid = new Grid(row,col);
        assertEquals(8,grid.liveNeighboursForCentre());
    }

    @DisplayName("Calculate the number of live neighbours for an edge cell in a given grid")
    @ParameterizedTest(name = "Determining number of live neighbours for an edge cell")
    @CsvSource({
            "1,0",
            "0,1",
            "2,1",
            "1,2"
    })
    public void testToCalculateNumberOfLiveNeighboursForEdgeCell(int row,int col){
        Grid grid = new Grid(3,3);
        assertEquals(5,grid.liveNeighboursForEdgeCell(row,col));
    }

    @DisplayName("Calculate the number of live neighbours for an corner cell in a given grid")
    @ParameterizedTest(name = "Determining number of live neighbours for an corner cell")
    @CsvSource({
            "0,0",
            "0,2",
            "2,0",
            "2,2"
    })
    public void testToCalculateNumberOfLiveNeighboursForCornerCell(int row,int col){
        Grid grid = new Grid(3,3);
        assertEquals(3,grid.liveNeighboursForCornerCell(row,col));
    }

    @DisplayName("Calculate the number of dead neighbours for a corner cell grid")
    @ParameterizedTest(name = "Determining number of dead neighbours for corner cell")
    @CsvSource({
            "0,0",
            "0,2",
            "2,0",
            "2,2"
    })
    public void testToCalculateNumberOfDeadNeighboursForCornerCell(int row,int col){
        Grid grid = new Grid(3,3);
        assertEquals(4,grid.deadNeighbourCountForBoundaryCells(row,col));
    }

    @DisplayName("Calculate the number of dead neighbours for an edge cell grid")
    @ParameterizedTest(name = "Determining number of dead neighbours for edge cell")
    @CsvSource({
            "1,0",
            "0,1",
            "2,1",
            "1,2"
    })
    public void testToCalculateNumberOfDeadNeighboursForEdgeCell(int row,int col){
        Grid grid = new Grid(3,3);
        assertEquals(3,grid.deadNeighbourCountForBoundaryCells(row,col));
    }


}
