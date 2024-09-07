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
        Grid grid = new Grid(2,2);
        assertEquals(2,grid.getRows());
        assertEquals(2,grid.getColumns());

        for(int row = 0;row<2;row++){
            for(int column = 0;column<2;column++){
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

        assertEquals(true, grid.getCellState(row,column));
    }
}
