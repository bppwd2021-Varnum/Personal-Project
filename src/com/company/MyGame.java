package com.company;



import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class    MyGame extends Game  {




    public static final String TITLE = "BPPWD Game";

    public static final int SCREEN_WIDTH = 1200;

    public static final int SCREEN_HEIGHT = 800;
    public  int x=500;
    public  int y=500;
    public  int i=500;
    public  int l=500;
    public  int xchange=10;
    public  int ychange=10;
    public  int x1=(int) ((Math.random()*10)+1);
    public  int y1=(int) ((Math.random()*10)+1);
    Player two ;
    private int health=7;
    private Room room = new Room();
    private int playerVelocity = 5;
    private ArrayList<Tile> tileSet = room.getTileSet();
    private int maxH=100;
    private int w;
    private int h;

    public  int mX;
    public  int mY;


    private ArrayList<Enemy> EnemyArray=new ArrayList<>();

    public int count=0;
    public int count1=0;
    int seconds = 0;
    boolean timesup = true;
    int time=(int) System.currentTimeMillis();
    int time2 =0;
    private final long createdMillis = System.currentTimeMillis();

    public MyGame() throws IOException{
        try{
            BufferedImage player=ImageIO.read(new File("wiz.png"));
            two = new Player(x,y,100,100,player);
            BufferedImage em=ImageIO.read(new File("girl.png"));
            for (int i = 0; i < 5; i++) {
                EnemyArray.add(new Enemy((int)(Math.random()*(1150-49)+50),(int)(Math.random()*(750-49)+50),50,50,em));
                count+=1;
            }
        }catch(IOException e){

        }

//        one = new Player(x,y,100,100);









    }

    public int[] startPos(){
        int startX;
        int startY;
        for(int i=0;i<tileSet.size();i++){
            if(tileSet.get(i) instanceof Start){
                startX=((Start) tileSet.get(i)).getStartLocation()[0];
                startY=((Start) tileSet.get(i)).getStartLocation()[1];
                return new int[]{startX,startY};
            }
        }return new int[]{100,100};
    }
    public void update() throws IOException{

//        for(int i=0;i<count;i++){
//            EnemyArray.get(i).move();
//        }
//        for(int i=0;i<count;i++){
//            EnemyArray.get(i).move();
//        }


        for(int i=0;i<count;i++) {
//            getBullet;

//            for (int i = 0; i < count; i++) {
//                EnemyArray.get(i).intersection();
//            }
        }

//        if (time2-time>15000){
//            for (int i = count; i<count+5; i++) {
//                EnemyArray.add(new Enemy((int)(Math.random()*(1150-49)+50),(int)(Math.random()*(750-49)+50),50,50,em));
//
//            }
//            count+=5;
//            time=(int) System.currentTimeMillis();
//        }

        two.update();

        if(health<=0){

            System.exit(0);
        }
//    System.out.println(two.getX()+":X  "+two.getY()+":Y  ");
//        tileSet = room.getTileSet();
        if (health <= 0) {
            System.exit(0);
        }
//        for (int i = 0; i < tileSet.size(); i++) {
//            if (tileSet.get(i) instanceof Wall || (tileSet.get(i) instanceof Door && !(two.getHasKey()))) {
//                if (tileSet.get(i).collideDown(two))
//                    two.setY(two.getY() - playerVelocity);
////                two.doFall = false;
//                if (tileSet.get(i).collideUp(two))
//                    two.setY(two.getY() + playerVelocity);
//
//                if (tileSet.get(i).collideLeft(two))
//                    two.setX(two.getX() + playerVelocity);
//                if (tileSet.get(i).collideRight(two))
//                    two.setX(two.getX() - playerVelocity);
//            } else if (tileSet.get(i) instanceof Key) {
//                if (tileSet.get(i).collideLeft(two) || tileSet.get(i).collideRight(two) || tileSet.get(i).collideUp(two) || tileSet.get(i).collideDown(two)) {
//                    tileSet.add(i + 1, new Air(tileSet.get(i).getX(), tileSet.get(i).getY(), 25, 25));
//                    tileSet.remove(i);
//                    two.setHasKey(true);
//                }
//            } else if (tileSet.get(i) instanceof Door) {
//                if (two.getHasKey() && (tileSet.get(i).collideLeft(two) || tileSet.get(i).collideRight(two) || tileSet.get(i).collideUp(two) || tileSet.get(i).collideDown(two))) {
//                    for (int door = 0; door < tileSet.size(); door++) {
//                        if (tileSet.get(door) instanceof Door) {
//                            tileSet.add(door + 1, new Air(tileSet.get(door).getX(), tileSet.get(door).getY(), 25, 25));
//                            tileSet.remove(door);
//                        }
//                    }
//                }
//            } else if (tileSet.get(i) instanceof Lava) {
//                if (tileSet.get(i).collideLeft(two) || tileSet.get(i).collideRight(two) || tileSet.get(i).collideUp(two) || tileSet.get(i).collideDown(two)) {
//                    room.clear();
//                    room.fillMap();
//                    two.setHasKey(false);
//                    for (int start = 0; start < tileSet.size(); start++) {
//                        if (tileSet.get(start) instanceof Start) {
//                            two.setX(((Start) tileSet.get(start)).getStartLocation()[0]);
//                            two.setY(((Start) tileSet.get(start)).getStartLocation()[1]);
//                        }
//                    }
//                }
//            } else if (tileSet.get(i) instanceof Exit) {
//                if (tileSet.get(i).collideLeft(two) || tileSet.get(i).collideRight(two) || tileSet.get(i).collideUp(two) || tileSet.get(i).collideDown(two)) {
//                    tileSet.remove(i);
//                    room.nextLevel();
//                    room.clear();
//                    room.fillMap();
//                    two.setHasKey(false);
//                    for (int start = 0; start < tileSet.size(); start++) {
//                        if (tileSet.get(start) instanceof Start) {
//                            two.setX(((Start) tileSet.get(start)).getStartLocation()[0]);
//                            two.setY(((Start) tileSet.get(start)).getStartLocation()[1]);
//                        }
//                    }
//                }
//            }
//        }
//




    }

    public void draw(Graphics pen) {

//        room.draw(pen);

//        one.draw(pen);
        two.draw(pen);
        for(int i=0;i<1;i++) {
            EnemyArray.get(i).draw(pen);

        }
//            if (one.intersection(EnemyArray.get(i)).getWidth() != 0) {
//                pen.setColor(Color.BLACK);
//                pen.fillRect(one.intersection(EnemyArray.get(i)).getX(), one.intersection(EnemyArray.get(i)).getY(), one.intersection(EnemyArray.get(i)).getWidth(), one.intersection(EnemyArray.get(i)).getHeight());
//                two.update();
//            }
//        }






        mX =(int) MouseInfo.getPointerInfo().getLocation().getX();
        mY = (int)MouseInfo.getPointerInfo().getLocation().getY();
//
//        if(x>=1083) {
//            x=1083;
//
//        }
//
//        else if(x<=0) {
//            x=1;
//
//        }
//        if(y >=660) {
//            y=660;
//
//        }
//        else if(y<=0){
//            y=1;
//        }
//
//
//        one.move(mX,mY);



    }
//    public int getAgeInSeconds() {
//        long nowMillis = System.currentTimeMillis();
//        return (int)((nowMillis - this.createdMillis) / 1000);
//    }


    public void keyTyped(KeyEvent ke) {}





    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE){
            two.jump();
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
            two.setRight(true);
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT){
            two.setLeft(true);

        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN){
            two.setDown(true);
            System.out.println("Down");
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP){
            two.setUp(true);
        }
    }
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
            two.setRight(false);
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT){
            two.setLeft(false);

        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN){
            two.setDown(false);
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP){
            two.setUp(false);
        }

    }

    public void mouseClicked(MouseEvent ke) {

    }





    public void mousePressed(MouseEvent me) {
        two.shoot(mX,mY);
    }





    public void mouseReleased(MouseEvent me) {}





    public void mouseEntered(MouseEvent me) {}






    public void mouseExited(MouseEvent me) {}






    //Launches the Game

    public static void main(String[] args) throws IOException { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT);




    }

}