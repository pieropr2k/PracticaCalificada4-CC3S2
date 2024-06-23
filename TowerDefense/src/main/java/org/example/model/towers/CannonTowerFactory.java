package org.example.model.towers;

public class CannonTowerFactory implements TowerFactory {
    @Override
    public Tower createTower() {
        return new CannonTower();
    }
}
