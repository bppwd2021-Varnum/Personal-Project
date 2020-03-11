package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player  {
    public boolean right, left,up,down;


    private int x;
    private int y;
    private int width = 25;
    private int height = 25;
    private BufferedImage img;
    Sword[] sword;

    private boolean hasKey;
    private int gravity;
    private int jumpHeight;
    private int jumpCount;
    public boolean doFall;
    Bullet[] bullet;
    private ArrayList<Bullet> BulletArray=new ArrayList<>();
    private int q;
    public boolean doTheJump;
    public boolean touchBetweenJumps = true;
    private int xv = 0;
    private int yv = 0;
    private boolean upPressed,downPressed,leftPressed,rightPressed;

    public Player(int x1, int y1, int width1, int height1,BufferedImage img) {
        x = x1;
        y = y1;
        gravity = 0;
        jumpHeight = 10;
        height = height1;
        width = width1;
        this.img=img;
        sword = new Sword[1];
        bullet=new Bullet[1000];
    }

    public void draw(Graphics pen) {
//        pen.setColor(Color.blue);
//        pen.fillRect(x, y, width, height);
        pen.drawImage(img,x,y,width,height,null);
        for(int i=0;i<bullet.length;i++){
            if (bullet[i]!=null){
                bullet[i].draw(pen, Color.blue);
            }
        }
    }

    public void update() {
        if (x >= 1055) {
            x = 1055;

        } else if (x <= 55) {
            x = 55;
        }
        if (y >= 645) {
            y = 645;
        } else if (y <= 55) {
            y = 55;
        }
        if(left){
            xv=-3;
        }


        else if(right){
            xv=3;
        }
        else {
            xv=0;
        }

        if(up){
            yv=-3;
        }

        else if(down){
            yv=3;
        }
        else {
            yv=0;
        }

        x+=xv;
        System.out.println("X: " + x);
        System.out.println("XV: " + xv);
        y+=yv;
        for(int i=0;i<bullet.length;i++){
            if (bullet[i]!=null){
                bullet[i].update();


            }

        }
//        if (touchBetweenJumps && doTheJump) {
//            jumpCount++;
//            if (jumpCount > jumpHeight) {
//                jumpCount = 0;
//                doTheJump = false;
//            } else {
//                y -= 20;
//            }
//        }
//        y += speed;
    }
    public int getSpeed(){
        return xv;
    }
    public Bullet[] getBullet(){
        return(bullet);
    }
    public void move(int mx, int my) {
        this.x = mx;
        this.y = my;
    }
    public void shoot(int mx,int my){
        int run = x-mx;
        int rise = y-my;
        double angle = Math.atan2(rise, run);


        bullet[q]= new Bullet(x+50,y+50,Math.cos(angle)*10, Math.sin(angle)*10);
//        bullet.add(new Bullet(x+30, y+30, Math.cos(angle)*10, Math.sin(angle)*10));

        q+=1;

    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int movedown(int x1) {
        return y += x1;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
    public void setUp(boolean up) { this.up = up; }
    public void setDown(boolean down) { this.down = down;
    }
    public int moveup(int x1) {
        return y -= x1;
    }

    public void touchGround() {
        touchBetweenJumps = true;
    }

    //        public void Jump(){
//        y-=100;
//        System.out.println("Jumping: " + y + " And X is: " + x);
//    }
    public void jump() {
        doTheJump = true;
    }
    public int run(boolean run) {
        if(run==true) {
            System.out.println("spped * extra : " + (this.getSpeed()*2) + " And X is: " + x);
            return x += (this.getSpeed() * 2);

        }
        return(x+=this.getSpeed());
    }


    @Override
    public String toString() {
        return ("Rectangle X is : " + x + " The Y is : " + y + " The Width is : " + width + " The height is : " + height);
    }

    public boolean contains(int x1, int y1) {
        if (x1 >= this.x && x1 <= this.x + this.width && y1 >= this.y && y1 <= this.y + this.height) {

            return true;
        }
        return (false);
    }
    public boolean hit(int x1, int y1) {
        for (int i = 0; i <bullet.length; i++) {
            if (bullet[i] != null) {

                if (x1 >= bullet[i].getX() && x1 <= bullet[i].getX() + bullet[i].getWidth() && y1 >= bullet[i].getY() && y1 <= bullet[i].getY() + bullet[i].getHeight()) {
                    bullet[i]=null;
                    return true;

                }
            }
        }
        return (false);
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean getHasKey() {
        return hasKey;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean shot(Enemy rect) {
        int top = rect.getX() + rect.getWidth();
        int bottom = rect.getY() + rect.getHeight();
        int endX = 0;
        int endY = 0;
        boolean crossed = false;
        for (int k = 0; k < rect.getWidth() + 1; k++) {
            for (int l = 0; l < rect.getHeight() + 1; l++) {
                if (this.hit(rect.getX() + k, rect.getY() + l)) {

                    crossed = true;

                   return(true);
                }
            }
        }
        return (false);
    }
    public boolean touched(Enemy rect) {


        int top = rect.getX() + rect.getWidth();
        int bottom = rect.getY() + rect.getHeight();
        int endX = 0;
        int endY = 0;
        boolean crossed = false;
        for (int k = 0; k < rect.getWidth() + 1; k++) {
            for (int l = 0; l < rect.getHeight() + 1; l++) {
                if (this.contains(rect.getX() + k, rect.getY() + l)) {

                    crossed = true;

                    return(true);
                }
            }
        }
        return (false);
    }



}