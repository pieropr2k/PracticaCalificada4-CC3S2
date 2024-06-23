package org.example.model.enemies;

public class SpeedyEnemyFactory implements EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new SpeedyEnemy();
    }
}
