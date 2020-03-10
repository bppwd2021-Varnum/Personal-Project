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
    private int stam=7;
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
    BufferedImage bg;
    BufferedImage health1;
    BufferedImage stam1;
    BufferedImage grey;
    boolean timesup = true;
    long time= System.currentTimeMillis();
    long time1= System.currentTimeMillis();
    int time2 =0;

    private final long createdMillis = System.currentTimeMillis();

    public MyGame() throws IOException{
        try{
             bg=ImageIO.read(new File("dung.png"));
            health1=ImageIO.read(new File("health_bar.png"));
            stam1=ImageIO.read(new File("stam_bar.png"));
            grey=ImageIO.read(new File("grey_bar.png"));
            BufferedImage player=ImageIO.read(new File("wiz.png"));
            two = new Player(x,y,75,75,player);
            BufferedImage em=ImageIO.read(new File("girl.png"));
            for (int i = 0; i < 2; i++) {
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

        for(int i=0;i<count;i++){
            EnemyArray.get(i).follow(two.getX(),two.getY());
            EnemyArray.get(i).update();
        }
//        for(int i=0;i<count;i++){
//            EnemyArray.get(i).move();
//        }


//        for(int i=0;i<count;i++) {
//            getBullet;

            for (int i = 0; i < count; i++) {

                if(two.shot(EnemyArray.get(i))==true){

                    EnemyArray.remove(EnemyArray.get(i));
                    count-=1;
                    break;
                }
            }
        for (int i = 0; i < count; i++) {

            if(System.currentTimeMillis()-time>800){

                if(two.contains(EnemyArray.get(i).x,EnemyArray.get(i).y)==true) {
//                    System.out.println("Health: " + health);
                time = System.currentTimeMillis();
                health -= 1;

            }

                break;
            }
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








    }

    public void draw(Graphics pen) {

        pen.drawImage(bg,0,0,1200 , 800,null);
        pen.drawImage(grey,15,15, 350, 50,null);
        pen.drawImage(health1,15,15, health*50, 50,null);
        pen.drawImage(grey,815,15, 350, 50,null);
        pen.drawImage(stam1,815,15, stam*50, 50,null);
//        one.draw(pen);
        two.draw(pen);

        for(int i=0;i<count;i++) {
            EnemyArray.get(i).draw(pen);

        }

//            if (two.intersection(EnemyArray.get(i))==true) {
//                for(int i=0;i<1;i++) {
//                    EnemyArray.get(i).remove();
//
//                }
//
//                two.update();
//            }







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
        if (ke.getKeyCode() == KeyEvent.VK_D){
            two.setRight(true);
        }
        if (ke.getKeyCode() == KeyEvent.VK_A){
            two.setLeft(true);

        }
        if (ke.getKeyCode() == KeyEvent.VK_S){
            two.setDown(true);

        }
        if (ke.getKeyCode() == KeyEvent.VK_W){
            two.setUp(true);
        }
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if (ke.getKeyCode() == KeyEvent.VK_SHIFT){
            time1 = System.currentTimeMillis();

            if(System.currentTimeMillis()-time1<900) {
                if(stam!=0) {
                    two.run(true);
                    stam--;
                }



            }

        }

    }
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_D){
            two.setRight(false);
        }
        if (ke.getKeyCode() == KeyEvent.VK_A){
            two.setLeft(false);

        }
        if (ke.getKeyCode() == KeyEvent.VK_S){
            two.setDown(false);
        }
        if (ke.getKeyCode() == KeyEvent.VK_W){
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