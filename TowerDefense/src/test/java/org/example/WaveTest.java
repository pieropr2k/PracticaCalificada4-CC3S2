package org.example;

import org.example.model.Wave;
import org.example.model.enemies.Enemy;
import org.example.model.enemies.SpeedyEnemy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class WaveTest {
    @Mock
    private Wave waveMock;
    @Test
    public void testGetEnemies() {
        // Arrange
        when(waveMock.getEnemies()).thenReturn(Arrays.asList(new SpeedyEnemy(), new SpeedyEnemy(), new SpeedyEnemy(), new SpeedyEnemy(), new SpeedyEnemy()));
        // Act
        List<Enemy> enemies = waveMock.getEnemies();
        // Assert
        assertEquals(5, enemies.size());
    }
}
