package org.example.model;

import org.example.model.enemies.Enemy;
import org.example.model.towers.Tower;

import java.util.List;

public class Map {
    final int DIM = 5;
    private int rows;
    private int columns;
    private char[][] mapGrid;
    private List<Position> road;
            //= List.of(new Position(1,1));
    private Position base;

    public Map(){
        this.rows = DIM;
        this.columns = DIM;
        //this.mapGrid = new int[rows][columns];
        this.base = new Position(2, 4);
        this.mapGrid = new char[][] {
                {' ', ' ', 'C', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {'C', ' ', ' ', 'C', 'B'},
                {' ', ' ', 'C', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };
        generateRoad();

    }

    public void generateRoad() {
        this.road = List.of(new Position(2,0),
                new Position(1,1),
                new Position(0,2),
                new Position(3,1),
                new Position(3,2),
                new Position(2,3),
                new Position(2, 4)
        );
    }

    public char[][] getMapGrid() {
        return this.mapGrid;
    }

    public void printMap(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String mapElement = "[" + mapGrid[i][j] + "]";
                System.out.print(mapElement);
            }
            System.out.println();
        }
    }

    public boolean isValidPosition(int x, int y){
        return (x >= 0 && x < rows) && (y >= 0 && y < columns) && mapGrid[x][y] == ' ';
    }

    public void placeTower(Tower tower, int x, int y) {
        if (this.isValidPosition(x,y)) {
            mapGrid[x][y] = 'T';
            tower.setPosition(x, y);
        }
    }

    public void placeEnemy(Enemy enemy, int x, int y) {
        mapGrid[x][y] = 'E';
        enemy.setPosition(x, y);
    }
/*
    public void placeRoad(int x, int y) {
        mapGrid[x][y] = 'C';
    }

    public boolean checkTower(int i,int j){
        return mapGrid[i][j] == 'T';
    }

    public boolean checkEnemy(int i,int j){
        return mapGrid[i][j] == 'E';
    }

    public boolean checkRoad(int i,int j){
        return mapGrid[i][j] == 'C';
    }

    public boolean checkPlace(int i,int j){
        return mapGrid[i][j] == 'B';
    }

    public List<Position> getRoad(){
        return this.road;
    }

    public Position getBase(){
        return this.base;
    }
    */
}