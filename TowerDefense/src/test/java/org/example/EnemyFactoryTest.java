package org.example;

import org.example.model.enemies.*;
import org.example.model.towers.DartTower;
import org.example.model.towers.Tower;
import org.example.model.towers.TowerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnemyFactoryTest {
    @Mock
    private EnemyFactory enemyFactoryMock;
    @Test
    public void testBasicEnemyFactory() {
        // Configurar stub
        when(enemyFactoryMock.createEnemy()).thenReturn(new BasicEnemy());
        Enemy createdEnemy = enemyFactoryMock.createEnemy();
        assertEquals(1, createdEnemy.getSpeed());
        assertEquals(100, createdEnemy.getHealth());
        assertEquals(10, createdEnemy.getReward());
        assertInstanceOf(BasicEnemy.class, createdEnemy);
    }

    @Test
    public void testBossEnemyFactory() {
        // Configurar stub
        when(enemyFactoryMock.createEnemy()).thenReturn(new BossEnemy());
        Enemy createdEnemy = enemyFactoryMock.createEnemy();
        assertEquals(1, createdEnemy.getSpeed());
        assertEquals(500, createdEnemy.getHealth());
        assertEquals(50, createdEnemy.getReward());
        assertInstanceOf(BossEnemy.class, createdEnemy);
    }

    @Test
    public void testSpeedyEnemyFactory() {
        // Configurar stub
        when(enemyFactoryMock.createEnemy()).thenReturn(new SpeedyEnemy());
        Enemy createdEnemy = enemyFactoryMock.createEnemy();
        assertEquals(2, createdEnemy.getSpeed());
        assertEquals(45, createdEnemy.getHealth());
        assertEquals(50, createdEnemy.getReward());
        assertInstanceOf(SpeedyEnemy.class, createdEnemy);
    }
}
