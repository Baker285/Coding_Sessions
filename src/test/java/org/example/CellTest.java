package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @DisplayName("Should initialize the new cell")
    @Test
    public void testInitializeCell(){
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

    @DisplayName("A live cell with fewer than two live neighbours should die")
    @Test
    public void testLiveCellWithFewerThanLiveNeighboursShouldDie() {
        int liveNeighbours = 1;
        Cell cell = new Cell(true);
        cell.update(liveNeighbours);
        assertFalse(cell.isAlive());
    }

    @DisplayName("A live cell with two or three live neighbours survives")
    @ParameterizedTest(name = "Alive Cell with {0} live  neighbours should survive")
    @ValueSource(ints = {2,3})
    public void testLiveCellWithTwoOrThreeNeighboursSurvives(int liveNeighbours){
        Cell cell = new Cell(true);
        cell.update(liveNeighbours);
        assertTrue(cell.isAlive());
    }

    @DisplayName("A live cell with more than three live neighbours should die")
    @ParameterizedTest(name = "Alive Cell with {0} live neighbours should die")
    @ValueSource(ints = {4,5,6,7,8})
    public void testLiveCellWithMoreThanThreeLiveNeighboursShouldDie(int liveNeighbours) {
        Cell cell = new Cell(true);
        cell.update(liveNeighbours);
        assertFalse(cell.isAlive());
    }

    @DisplayName("A dead cell with exactly three live neighbours should become alive")
    @Test
    public void testWithDeadCellExactlyThreeLiveNeighboursShouldBecomeAlive(){
        int liveNeighbours = 3;
        Cell cell = new Cell(false);
        cell.update(liveNeighbours);
        assertTrue(cell.isAlive());
    }

    @DisplayName("Set state of a cell")
    @Test
    public void setStateOfCell(){
        Cell cell = new Cell(true);
        cell.setState(false);
        assertEquals(false,cell.isAlive());
    }

}
