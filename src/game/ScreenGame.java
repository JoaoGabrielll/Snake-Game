package game;

import entities.Fruit;
import entities.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScreenGame extends JFrame implements ActionListener, KeyListener {
    private AssetsManager assetsManager;
    private Timer timer;
    private Snake snake;
    private Fruit fruit;
    private GameControls gameControls;

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    public ScreenGame(){
        setTitle("Snake Game");
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        assetsManager = new AssetsManager();
        add(assetsManager);

        snake = new Snake();
        fruit = new Fruit();
        gameControls = new GameControls();

        timer = new Timer(100, this);
        timer.start();

        setFocusable(true);
        addKeyListener(this);

        AssetsManager.loadAssets();

        pack();
        setVisible(true);
    }

    public static int getScreenWidth(){
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight(){
        return SCREEN_HEIGHT;
    }

    public void actionPerformed(ActionEvent e){
        snake.moveSnake();
        snake.checkCollisionSnake(fruit.getFruitPosition());

        if(snake.hasEatenFruit()){
            fruit.spawFruitRandom();
        }
        repaint();
    }

    public void keyPressed(KeyEvent e){
        gameControls.keyPressedControl(e);
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }

}