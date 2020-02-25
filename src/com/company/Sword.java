package com.company;

import java.awt.*;

public class Sword {
    int x;

    int y;
    int xc;
    int yc;
    int width;
    int height;

    int speed=20;




    public Sword(int x1, int y1){
        x=x1;
        y=y1;
        height=10;
        width=10;

    }

    public void draw(Graphics pen, Color c){
        pen.setColor(c);
        pen.fillRect(x, y, 10, 10);
//        pen.setColor(Color.black);
//        pen.drawRect(x, y, 10, 10);


    }
    public void update() {
        x+=speed;
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

