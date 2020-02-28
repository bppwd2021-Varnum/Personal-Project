package com.company;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Enemy {
    int x;

    int y;
    int xchange;
    int ychange;
    int width;
    int height;
    //    int xr=(int) ((Math.random()*10)+1);
//    int yr=(int) ((Math.random()*10)+1);
    int xr=(1);
    int yr=(1);
    private BufferedImage img;


    public Enemy(int x1, int y1, int width1, int height1, BufferedImage img){
        x=x1;
        y=y1;
        height=height1;
        width=width1;
        this.img=img;
    }
    public void draw(Graphics pen){
        pen.drawImage(img,x,y,width,height,null);
//        pen.setColor(c);
//        pen.fillRect(x, y, width, height);
//        pen.setColor(Color.black);
//        pen.drawRect(x, y, width, height);


    }
    /*public void move() {
        x+=xr;
        y+=yr;
        if(x >1150 || x<0  ) {
            xr=xr*-1;
        }

        if(y >750 || y<0  ) {
            yr=yr*-1;
        }

    }*/
    public void follow(int px,int py){
        int run = x-px;
        int rise = y-py;
        double angle = Math.atan2(rise, run);



        xr= (int) (Math.cos(angle)*-3);
        yr= (int) (Math.sin(angle)*-3);

    }
    public void update(){
        x+=xr;
        y+=yr;
    }
//    public boolean update(Player rect) {
//        return(true);


//    }

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
    public boolean contains(int x1, int y1){
        if (x1>=this.x&& x1<=this.x+this.width && y1>=this.y && y1<=this.y+this.height){

            return true;
        }
        return(false);
    }
    public boolean intersection(Bullet rect) {


        int top = rect.getX() + rect.getWidth();
        int bottom = rect.getY() + rect.getHeight();
        int endX = 0;
        int endY = 0;
        boolean crossed = false;
        for (int k = 0; k < rect.getWidth() + 1; k++) {
            for (int l = 0; l < rect.getHeight() + 1; l++) {
                if (this.contains(rect.getX() + k, rect.getY() + l)) {

                    crossed = true;
                    if (rect.getX() + k > endX) {
                        endX = rect.getX() + k;

                    }
                    if (rect.getY() + l > endY) {
                        endY = rect.getY() + l;

                    }
                    if (rect.getX() + k < top) {
                        top = rect.getX() + k;

                    }
                    if (rect.getY() + l < bottom) {
                        bottom = rect.getY() + l;

                    }
                }
            }
        }
        return (true);
    }
//        Enemy newR;
//
//        newR=new Enemy(x,y,width,height);
//        if (crossed)
//            newR= new Enemy(top,bottom,endX-top,endY-bottom);
//        else{
//            newR= new Enemy(top,bottom,0,0);
//        }
//        return newR;
//    }

}





