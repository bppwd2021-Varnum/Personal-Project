package com.company;

        import java.awt.BorderLayout;
        import java.awt.Cursor;

        import java.awt.Graphics;
        import java.awt.Point;
        import java.awt.Toolkit;

        import java.awt.event.KeyListener;

        import java.awt.event.MouseListener;
        import java.awt.image.BufferedImage;

        import javax.swing.JFrame;

        import javax.swing.JPanel;



public abstract class Game implements KeyListener, MouseListener

{

    private JFrame frame;

    private GamePanel gamePanel;

    boolean running;

    private MyGame game;



    protected void start(String title, int width, int height)

    {

        this.game = (MyGame)this;

        running = true;

        frame = new JFrame(title);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel();

        frame.getContentPane().add(BorderLayout.CENTER, gamePanel);

        frame.setResizable(false);

        frame.setSize(width, height);

//        frame.setLocationByPlatform(true);
        frame.setLocation(0, 0);

        frame.setVisible(true);

        frame.addKeyListener(this);

        frame.addMouseListener(this);

//        Cursor matt = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(3,3,BufferedImage.TYPE_INT_ARGB),new Point(0,0),"");
//
//        frame.getContentPane().setCursor(matt);

        run();

    }





    class GamePanel extends JPanel

    {

        private static final long serialVersionUID = 1L;

        @Override

        public void paintComponent(Graphics g) { game.draw(g); }

    }



    private void run()

    {

        while (true)

        {

            game.update();

            try { Thread.sleep(7); }

            catch (InterruptedException e) {}

            frame.repaint();

        }

    }

}