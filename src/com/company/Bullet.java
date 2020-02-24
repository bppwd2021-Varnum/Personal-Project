/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author d.varnum
 */
public class Bullet {
    int x;

    int y;
    int xc;
    int yc;
    int width;
    int height;
    double speedx;
    double speedy;
    int xr=(int) ((Math.random()*10)+1);
    int yr=(int) ((Math.random()*10)+1);
    int speed=20;




    public Bullet(int x1, int y1,double speedx1,double speedy1){
        x=x1;
        y=y1;
        height=10;
        width=10;
        speedx=speedx1;
        speedy=speedy1;

    }

    public void draw(Graphics pen,Color c){
        pen.setColor(c);
        pen.fillRect(x, y, 10, 10);
//        pen.setColor(Color.black);
//        pen.drawRect(x, y, 10, 10);


    }
    public void update() {
        x-=speedx;
        y-=speedy;

    }

    //    public void move() {
//        x+=xr;
//        y+=yr;
//        if(x >1150 || x<0  ) {
//            xr=xr*-1;
//        }
//
//        if(y >750 || y<0  ) {
//            yr=yr*-1;
//        }
//
//    }
    public void move(int mx, int my) {
        this.x = mx;
        this.y = my;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public void setxc(int xc){
        this.x=xc;
    }
    public void setyc(int yc){
        this.y=yc;
    }
    public int movedown(int x1){
        return y+=yc;
    }
    public int moveup(int x1){
        return y-=yc;
    }
    public int moveright(int x1){
        return x+=xc;
    }
    public int moveleft(int x1){
        return x-=xc;
    }
    public String toString(){
        return ("Rectangle X is : " + x+" The Y is : "+ y);
    }
    public boolean contains(int x1, int y1){
        if (x1>=this.x&& x1<=this.x+this.width && y1>=this.y && y1<=this.y+this.height){

            return true;
        }
        return(false);
    }
    public boolean intersection(Enemy rect){

        System.out.println("fdhfhdlkhdffdlkjdfkl");
        int top=rect.getX()+rect.getWidth();
        int bottom=rect.getY()+rect.getHeight();
        int endX=0;
        int endY=0;
        boolean crossed = false;
        for(int k=0;k<rect.getWidth()+1;k++){
            for(int l=0;l<rect.getHeight()+1;l++){
                if(this.contains(rect.getX()+k,rect.getY()+l)){

                    crossed=true;
                    if(rect.getX()+k>endX){
                        endX=rect.getX()+k;

                    }
                    if(rect.getY()+l>endY){
                        endY=rect.getY()+l;

                    }
                    if(rect.getX()+k<top){
                        top=rect.getX()+k;

                    }
                    if(rect.getY()+l<bottom){
                        bottom=rect.getY()+l;

                    }
                }
            }
        }
//         Bullet newR;
//
//        newR=new Bullet(x,y);
        if (crossed){
            System.out.println("fdhfhdlkhdffdlkjdfkl");
            return true;
        }
        else{
            return false;
        }
    }


}
