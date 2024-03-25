package com.mygdx.game;


public class Coord{
    public int x;
    public int y;

    public static Coord GerRandomCoord(int[][] form){
        int random_x = (int)(Math.random() * (570 - form[0].length * 40));
        return new Coord(random_x, 800 - form.length * 40);
    }

    public Coord(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}