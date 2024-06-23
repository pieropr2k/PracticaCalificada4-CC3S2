package org.example.model.enemies;

public class BossEnemyFactory implements EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new BossEnemy();
    }
}
