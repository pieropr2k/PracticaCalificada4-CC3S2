package org.example.model.towers;

public class LaserTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new LaserTower();
    }
}
