package org.example.model.towers;

public class SniperTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new SniperTower();
    }
}
