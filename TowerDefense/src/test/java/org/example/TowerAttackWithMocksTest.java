package org.example;

import org.example.model.Position;
import org.example.model.enemies.Enemy;
import org.example.model.towers.Tower;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TowerAttackWithMocksTest {
    @Mock
    private Enemy enemyMock1;
    @Test
    public void testAttackInRange() {
        Tower tower = new Tower(10, 3, 1);
        // Posicion enemigo
        when(enemyMock1.getPosition()).thenReturn(new Position(1, 1));
        // Posición de la torre
        tower.setPosition(0, 0);
        tower.attack(List.of(enemyMock1));
        // Verificar que la salud del enemigo en rango se reduce
        verify(enemyMock1).downHealth(10);
    }

    @Mock
    private Enemy enemyMock2;
    @Test
    public void testAttackWithMocks() {
        Tower tower = new Tower(10, 3, 1);
        // Posicion enemigo
        when(enemyMock2.getPosition()).thenReturn(new Position(4, 4));
        // Posición de la torre
        tower.setPosition(0, 0);
        tower.attack(List.of(enemyMock2));
        // Verificar que la salud del enemigo fuera de rango no se reduce
        verify(enemyMock2, never()).downHealth(anyInt());
    }

}
