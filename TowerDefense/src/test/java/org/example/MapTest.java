package org.example;

import org.example.model.Map;
import org.example.model.towers.CannonTower;
import org.example.model.towers.CannonTowerFactory;
import org.example.model.towers.Tower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class MapTest {
    @Test
    public void testPlaceTower_ValidPosition() {
        Map map = new Map();
        map.placeTower(new CannonTowerFactory().createTower(), 0, 0);
        assertTrue(map.isValidPosition(0, 3));
    }
    @Test
    public void testPlaceTower_NotOverrideHimself() {
        Map map = new Map();
        map.placeTower(new CannonTowerFactory().createTower(), 0, 0);
        assertFalse(map.isValidPosition(0, 0));
    }
    @Test
    public void testPlaceTower_InvalidPosition() {
        Map map = new Map();
        map.placeTower(new CannonTowerFactory().createTower(), -1, -1);
        assertTrue(map.isValidPosition(0, 3));
    }

    @Test
    public void testInvalidPositionForX() {
        Map map = new Map();
        assertFalse(map.isValidPosition(-1, 3));
    }

    @Test
    public void testInvalidPositionForY() {
        Map map = new Map();
        assertFalse(map.isValidPosition(0, -1));
    }

    @Test
    public void testInvalidPositionForTower() {
        Map map = new Map();
        assertFalse(map.isValidPosition(0, 2));
    }

    @Test
    public void testValidPosition() {
        Map map = new Map();
        assertTrue(map.isValidPosition(0, 0));
    }

    @Test
    public void testGridSize() {
        Map map = new Map();
        char[][] grid = map.getMapGrid();
        assertEquals(5, grid.length);
    }
}
