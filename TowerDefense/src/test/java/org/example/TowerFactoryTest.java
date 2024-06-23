package org.example;

import org.example.model.towers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TowerFactoryTest {
    @Mock
    private TowerFactory towerFactoryMock;
    @Test
    public void testDartFactory() {
        // Configurar stub
        when(towerFactoryMock.createTower()).thenReturn(new DartTower());
        Tower createdTower = towerFactoryMock.createTower();
        assertEquals(20, createdTower.getDamage());
        assertEquals(3, createdTower.getRange());
        assertEquals(1, createdTower.getFireRate());
        assertInstanceOf(DartTower.class, createdTower);
    }
    @Test
    public void testLaserFactory() {
        // Configurar stub
        when(towerFactoryMock.createTower()).thenReturn(new LaserTower());
        Tower createdTower = towerFactoryMock.createTower();
        assertEquals(35, createdTower.getDamage());
        assertEquals(4, createdTower.getRange());
        assertEquals(3, createdTower.getFireRate());
        assertInstanceOf(LaserTower.class, createdTower);
    }
    @Test
    public void testCannonFactory() {
        // Configurar stub
        when(towerFactoryMock.createTower()).thenReturn(new CannonTower());
        Tower createdTower = towerFactoryMock.createTower();
        assertEquals(50, createdTower.getDamage());
        assertEquals(2, createdTower.getRange());
        assertEquals(3, createdTower.getFireRate());
        assertInstanceOf(CannonTower.class, createdTower);
    }
    @Test
    public void testSniperFactory() {
        // Configurar mock para posición válida
        when(towerFactoryMock.createTower()).thenReturn(new SniperTower());
        Tower createdTower = towerFactoryMock.createTower();
        assertEquals(50, createdTower.getDamage());
        assertEquals(4, createdTower.getRange());
        assertEquals(4, createdTower.getFireRate());
        assertInstanceOf(SniperTower.class, createdTower);
    }
}
