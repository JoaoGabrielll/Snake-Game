package game;

import javax.swing.*;
import java.awt.*;

public class GameClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScreenGame screenGame = new ScreenGame();

            Image snakeHeadImage = AssetsManager.getSnakeHeadIcon();

            AssetsManager assetsManager = new AssetsManager();
            screenGame.add(assetsManager);

            screenGame.setLocationRelativeTo(null);
        });
    }
}