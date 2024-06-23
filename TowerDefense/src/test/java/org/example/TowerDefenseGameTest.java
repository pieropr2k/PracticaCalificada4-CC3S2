package org.example;

import org.example.model.Game;
import org.example.model.Map;
import org.example.model.Wave;
import org.example.model.enemies.BasicEnemy;
import org.example.model.towers.CannonTower;
import org.example.model.towers.CannonTowerFactory;
import org.example.model.towers.Tower;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TowerDefenseGameTest {
    // tests 1
    @Mock
    private Map mockMap;
    // tests 2
    @Mock
    private Wave mockWave;
    @InjectMocks
    private Game game;
    @Test
    public void testPlaceTower_ValidPosition() {
        // Configurar mock para posición válida
        when(mockMap.isValidPosition(3, 4)).thenReturn(true);
        game.placeTower(new CannonTower(), 3, 4);
        // Verificar que la torre se haya colocado
        verify(mockMap).placeTower(any(Tower.class), eq(3), eq(4));

    }
    @Test
    public void testPlaceTower_InvalidPosition() {
        // Configurar mock para posición inválida
        when(mockMap.isValidPosition(3, 4)).thenReturn(false);
        game.placeTower(new CannonTower(), 3, 4);
        // Verificar que la torre no se haya colocado
        verify(mockMap, never()).placeTower(any(Tower.class), eq(3), eq(4));
    }

    @Test
    public void testStartWave_WithEnemies() {
        //Wave wave = new Wave(1);
        when(mockWave.spawnEnemies()).thenReturn(Arrays.asList(new BasicEnemy()));
        //game.setWave(wave);
        game.startWave();
        // Verificar que los enemigos han sido generados y la oleada ha comenzado
        assertFalse(game.getEnemies().isEmpty());
    }

    @Test
    public void testStartWave_WithEnemiesList() {
        when(mockWave.spawnEnemies()).thenReturn(Arrays.asList(new BasicEnemy(), new BasicEnemy(), new BasicEnemy()));
        game.startWave();
        // Verificar que los enemigos han sido generados y la oleada ha comenzado
        assertEquals(3, game.getEnemies().size());
    }

    @Test
    public void testStartWave_NoEnemies() {
        //Wave wave = new Wave(1);
        when(mockWave.spawnEnemies()).thenReturn(Collections.emptyList());
        //game.setWave(wave);
        game.startWave();
        // Verificar que no se han generado enemigos
        assertTrue(game.getEnemies().isEmpty());
    }
}
