package org.example.model.towers;

public class DartTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new DartTower();
    }
}
