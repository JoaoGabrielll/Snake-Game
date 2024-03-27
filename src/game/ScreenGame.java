package game;

import entities.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class ScreenGame extends JFrame {
    private AssetsManager assetsManager;
    private Timer timer;
    private Snake snake;

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    public ScreenGame(){
        setTitle("Snake Game");
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        assetsManager = new AssetsManager();
        add(assetsManager);

        snake = new Snake();


        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.moveSnake();
                repaint();
            }
        });

        timer.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                    GameControls.keyPressedControl(e);
            }
        });

        AssetsManager.loadAssets();
    }
}