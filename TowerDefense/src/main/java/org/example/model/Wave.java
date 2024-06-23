package org.example.model;

import org.example.model.enemies.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Wave {
    private List<Enemy> enemies;
    private int waveNumber;
    private Map map;

    public Wave(int waveNumber) {
        this.waveNumber = waveNumber;
        this.enemies = generateEnemies(waveNumber);
    }
    private List<Enemy> generateEnemies(int waveNumber) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < waveNumber * 5; i++) { // más enemigos cada oleada
            enemies.add(new BasicEnemyFactory().createEnemy());
        }
        if (waveNumber % 5 == 0) { // jefe cada 5 oleadas
            enemies.add(new BossEnemyFactory().createEnemy());
        }
        if (waveNumber % 7 == 0) { // jefe cada 5 oleadas
            enemies.add(new SpeedyEnemyFactory().createEnemy());
        }
        return enemies;
    }
    // Métodos para manejar el progreso de la oleada
    public List<Enemy> spawnEnemies() {
        char[][] map = this.map.getMapGrid();

        List<Position> spawnPoints = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'C') {
                    spawnPoints.add(new Position(i, j));
                }
            }
        }
        for (Enemy enemy : enemies) {
            if (!spawnPoints.isEmpty()) {
                Position spawnPoint = spawnPoints.remove(0);
                this.map.placeEnemy(enemy, spawnPoint.getX(), spawnPoint.getY());
                System.out.println("Enemy spawned at (" + spawnPoint.getX() + ", " + spawnPoint.getY() + ")");
            } else {
                break;
            }
        }
        return enemies;
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public void setEnemies(List<Enemy> enemies){
        this.enemies = enemies;
    }

}