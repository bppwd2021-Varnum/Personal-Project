
package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player  {
    public boolean right, left, up, down;


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
    private ArrayList<Bullet> BulletArray = new ArrayList<>();
    private int q;
    public boolean doTheJump;
    public boolean touchBetweenJumps = true;
    private int speed = 5;
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Player(int x1, int y1, int width1, int height1, BufferedImage img) {
        x = x1;
        y = y1;
        gravity = 0;
        jumpHeight = 10;
        height = height1;
        width = width1;
        this.img = img;
        sword = new Sword[1];
        bullet = new Bullet[1000];
    }

    public void draw(Graphics pen) {
//        pen.setColor(Color.blue);
//        pen.fillRect(x, y, width, height);
        pen.drawImage(img, x, y, width, height, null);
        for (int i = 0; i < bullet.length; i++) {
            if (bullet[i] != null) {
                bullet[i].draw(pen, Color.ORANGE);
            }
        }
    }

    public void update() {
        if (x >= 1150) {
            x = 1150;

        } else if (x <= 0) {
            x = 1;
        }
        if (y >= 750) {
            y = 750;
        } else if (y <= 0) {
            y = 1;
        }
        if (left) {
            x -= speed;
        }
        if (right) {
            x += speed;
        }
        if (up) {
            y -= speed;
        }
        if (down) {
            y += speed;
        }
        for (int i = 0; i < bullet.length; i++) {
            if (bullet[i] != null) {
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

    public int getSpeed() {
        return speed;
    }

    public Bullet[] getBullet() {
        return (bullet);
    }

    public void move(int mx, int my) {
        this.x = mx;
        this.y = my;
    }

    public void shoot(int mx, int my) {
        int run = x - mx;
        int rise = y - my;
        double angle = Math.atan2(rise, run);


        bullet[q] = new Bullet(x + 50, y + 50, Math.cos(angle) * 20, Math.sin(angle) * 20);
//        bullet.add(new Bullet(x+30, y+30, Math.cos(angle)*10, Math.sin(angle)*10));

        q += 1;

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

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
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

    public int moveright(int x1) {
        return x += x1;
    }

    public int moveleft(int x1) {
        return x -= x1;
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

}