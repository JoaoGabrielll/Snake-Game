package game;

import entities.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScreenGame extends JFrame {
    private AssetsManager assetsManager;
    private Timer timer;
    private Snake snake;
    public ScreenGame(){
        setTitle("Snake Game");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        assetsManager = new AssetsManager();
        add(assetsManager);

        snake = new Snake();

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.moveSnake(getGraphics());
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