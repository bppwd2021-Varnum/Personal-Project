package com.company;

import java.awt.*;

public class Tile {
    private int _x;
    private int _y;
    private int _width;
    private int _height;

    public Tile() {
        _x = 0;
        _y = 0;
        _width = 0;
        _height = 0;
    }

    public Tile(int x, int y, int width, int height) {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }// im fr fr dead
    public void draw(Graphics pen){
        pen.fillRect(_x,_y,_width,_height);
    }public void setColor(Graphics pen, Color color){
        pen.setColor(color);
    }public boolean collideDown(Player player){
        return ((_y+player.getSpeed())<=(player.getY()+player.getHeight()) && (player.getY()+player.getHeight()<=_y+_height) && ((player.getX()+player.getWidth())>_x) && (player.getX()<(_x+_width)));
    }public boolean collideUp(Player player){
        return (player.getY()+player.getSpeed()<=(_y+_height) && (player.getY()>=_y) && ((player.getX()+player.getWidth())>_x) && (player.getX()<(_x+_width)));
    }public boolean collideLeft(Player player){
        return ((player.getX()+player.getSpeed())<=(_x+_width) && (player.getX()>=_x) && (player.getY()<(_y+_height)) && ((player.getY()+player.getHeight())>_y));
    }public boolean collideRight(Player player){
        return ((((player.getX()+player.getWidth())-player.getSpeed())>=_x) && (player.getX()<=_x) && (player.getY()<(_y+_height)) && ((player.getY()+player.getHeight())>_y));
    }

    public int getWidth() {
        return _width;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public int getHeight() {
        return _height;
    }

}