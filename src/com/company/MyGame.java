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
    private int stam=14;
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
    BufferedImage key;
    boolean timesup = true;
    long time= System.currentTimeMillis();
    long time1= System.currentTimeMillis();
    long Regtime= System.currentTimeMillis();
    int time2 =0;
    boolean keyVisble=true;

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
            key=ImageIO.read(new File("key.png"));
            for (int i = 0; i < 3; i++) {
                EnemyArray.add(new Enemy((int)(Math.random()*(1150-49)+50),(int)(Math.random()*(750-49)+50),50,50,em));
                count+=1;

            }

        }catch(IOException e){

        }


    }

    public void update() throws IOException {

        for (int i = 0; i < count; i++) {
            EnemyArray.get(i).follow(two.getX(), two.getY());
            EnemyArray.get(i).update();
        }


        for (int i = 0; i < count; i++) {

            if (two.shot(EnemyArray.get(i)) == true) {

                EnemyArray.remove(EnemyArray.get(i));
                count -= 1;
                break;
            }
        }
        for (int i = 0; i < count; i++) {

            if (System.currentTimeMillis() - time > 800) {

                if (two.contains(EnemyArray.get(i).x, EnemyArray.get(i).y) == true) {
//                    System.out.println("Health: " + health);
                    time = System.currentTimeMillis();
                    health -= 1;

                }


                break;
            }

        }
//        for (int i = 0; i < count; i++) {
//            if (two.contains(EnemyArray.get(i).x, EnemyArray.get(i).y) == false) {
//                Regtime = System.currentTimeMillis();
//                break;
//            }
//        }
//        if (health < 7 && System.currentTimeMillis() - Regtime > 500) {
//            health += 1;
//                }



        two.update();

        if(health<=0){

            System.exit(0);
        }
//    System.out.println(two.getX()+":X  "+two.getY()+":Y  ");
    }
    public void draw(Graphics pen) {

        pen.drawImage(bg,0,0,1200 , 800,null);
        pen.drawImage(grey,15,15, 350, 25,null);
        pen.drawImage(health1,15,15, health*50, 25,null);
        pen.drawImage(grey,815,15, 350, 25,null);
        pen.drawImage(stam1,815,15, stam*25, 25,null);
//        one.draw(pen);
        two.draw(pen);
        if(count==0){
            Font font = new Font("Verdana", Font.BOLD, 50);
            pen.setFont(font);
            pen.setColor(Color.black);

            pen.drawString("Room Cleared",400,400);

            if(keyVisble==true) {
                pen.drawImage(key, 580, 400, 50, 50, null);
                if (two.getX() > 540 && two.getX() < 600 && two.getY() > 355 && two.getY() < 400) {
                    keyVisble=false;

                }
            }
            if (health!=7){
                health+=1;
            }
            if (stam!=14){
                stam+=1;
            }
        }
        for(int i=0;i<count;i++) {
            EnemyArray.get(i).draw(pen);

        }


        mX =(int) MouseInfo.getPointerInfo().getLocation().getX();
        mY = (int)MouseInfo.getPointerInfo().getLocation().getY();
    }
    public void keyTyped(KeyEvent ke) {}
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE){
            two.jump();
            System.out.println("X: "+two.getX()+" Y: "+ two.getY());
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
        if (ke.getKeyCode() == KeyEvent.VK_E){
            System.out.println("x is :"+two.getX());
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
        if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {

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