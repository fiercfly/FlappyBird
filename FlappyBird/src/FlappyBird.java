import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;



public class Game
 implements ActionListener, MouseListener , KeyListener{

    public static Game Game;
    public final int height=600,width=900;
    public Renderer renderer;
    public Rectangle bird;
    public int ticks, yMotion, score;
    public boolean gameOver, started;
    public ArrayList<Rectangle> columns;
    public Random rand;


    public Game() {
        JFrame jframe = new JFrame();

        Timer timer = new Timer(20,this);  //objects
        renderer = new Renderer();
        rand = new Random();
        jframe.add(renderer);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.setSize(width,height);  // frame ki size
        jframe.setResizable(false);
        jframe.setTitle("Flappy Bird");
        jframe.setVisible(true); // frame ceartion
        jframe.addMouseListener(this);
        jframe.addKeyListener(this);

        bird = new Rectangle(width/2-10 , height/2-10,20,20); //chidiya ki size
        columns = new ArrayList<Rectangle>(); //obstackles
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        timer.start();
    }

    public void addColumn(boolean start){
        int space = 300;
        int WIDTH = 100;
        int HEIGHT = 50 + rand.nextInt(300);  // randomly boxes generate honge with max height of 300

        if (start){
            columns.add(new Rectangle(width + WIDTH + columns.size()*300, height - HEIGHT - 120, WIDTH , HEIGHT));
            columns.add(new Rectangle(width + WIDTH + (columns.size() - 1)*300, 0, WIDTH , height - HEIGHT - space));}
        else{
            columns.add(new Rectangle(columns.get(columns.size()-1).x + 600, height - HEIGHT - 120, WIDTH , HEIGHT));
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, WIDTH , height - HEIGHT - space));}
    }

    public void paintColumn(Graphics g, Rectangle column){
        g.setColor(Color.magenta); //pillers ka color
        g.fillRect(column.x,column.y,column.width,column.height);
    }
    public void jump(){
        if(gameOver){
            bird = new Rectangle(width/2-10 , height/2-10,20,20);
            columns.clear();
            yMotion = 0;
            score = 0;
            columns = new ArrayList<Rectangle>();
            addColumn(true);
            addColumn(true);
            addColumn(true);
            addColumn(true);

            gameOver = false;
        }
        if(!started){
            started = true;
        }
        else if(!gameOver){
            if(yMotion>0){
                yMotion = 0;
            }
            yMotion -= 10;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 10;
        ticks++;
        if (started) {
            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                column.x -= speed;
            }

            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;
            }
            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                if (column.x + column.width < 0) {
                    columns.remove(column);
                    if (column.y == 0) {
                        addColumn(false);
                    }
                }
            }

            bird.y += yMotion;
            for (Rectangle column : columns) { //agar bird columns se intersect kar gya ya screen k bahar gya toh game over ho jana h
                if(column.y == 0 && bird.x + bird.width/2>column.x + column.width /2 -5 && bird.x + bird.width/2 < column.x + column.width/2 + 10){
                    score++;
                }

                if (column.intersects(bird)) {
                    gameOver = true;
                    if(bird.x <= column.x){
                        bird.x = column.x - bird.width;
                    }
                    else{
                        if(column.y != 0 ){
                            bird.y = column.y - bird.height;
                        }
                        else if (bird.y<column.height){
                            bird.y = column.height;
                        }
                    }
                }
          }
        }
        if (bird.y>height-120 || bird.y < 0){
            gameOver = true;
        }
        if (bird.y + yMotion >= height-120){
            bird.y = height - 120 - bird.height;
        }
        renderer.repaint();
    }


    public void repaint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,width,height);

        g.setColor(Color.red);
        g.fillRect(0,height- 120,width,150 );

        g.setColor(Color.pink);
        g.fillRect(0,height - 120, width,20 );

        g.setColor(Color.cyan);
        g.fillRect(bird.x,bird.y, bird.width, bird.height);



        for (Rectangle column : columns){
            paintColumn(g, column);
        }
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD,100));

        if (!started) {
            g.drawString("Click to start!",75,height/2 - 50);
        }

        if (gameOver) {
            g.drawString("Game Over",100,height/2 - 50);
        }
        if(!gameOver && started){
            g.drawString(String.valueOf(score), width/2-25,100);
        }
    }

    public static void  main(String[] args) {
        Game = new Game();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jump();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            jump();
        }
    }
}

