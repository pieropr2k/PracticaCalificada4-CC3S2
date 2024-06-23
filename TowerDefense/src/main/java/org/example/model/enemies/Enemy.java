package org.example.model.enemies;

import org.example.model.Position;

public class Enemy {
    private int speed; // número de celdas por turno
    private int health;
    private int reward;
    private Position position;

    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
        this.position = new Position(0, 0);
    }
    // Constructores, getters y setters
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getHealth(){
        return this.health;
    }
    public void downHealth(int damage){
        this.health = this.health - damage;
    }
    public int getReward(){
        return this.reward;
    }
    public void setReward(int extra){
        this.reward = this.reward + extra;
    }
    public void setPosition(int x, int y) {
        position.setPosition(x, y);
    }
    public Position getPosition() {
        return this.position;
    }
}