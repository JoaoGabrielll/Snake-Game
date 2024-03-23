package entities;

import entities.enums.Direction;
import game.AssetsManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Snake implements ActionListener {
    private LinkedList<Point> body;
    private static Direction direction;
    private Timer timer;
    private int tileSize = AssetsManager.getTileSize();
    private Fruit fruit;

    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(5, 5));
        direction = Direction.RIGHT;
        timer = new Timer(100,this);
        timer.start();
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveSnake(Graphics g){
        Point head = body.getFirst();
        Point newHead = new Point(head);

        switch (direction){
            case UP:
                newHead.y--;
                break;
            case DOWN:
                newHead.y++;
                break;
            case RIGHT:
                newHead.x--;
                break;
            case LEFT:
                newHead.x++;
                break;
        }
        body.addFirst(newHead);
        body.removeLast();

        Image headImage = AssetsManager.getSnakeHeadIcon();
        g.drawImage(headImage, newHead.x * tileSize, newHead.y * tileSize, null);

        Rectangle snakeBounds = new Rectangle(newHead.x * tileSize, newHead.y * tileSize, tileSize, tileSize);
        Rectangle fruitBounds = fruit.getBounds();

        if(snakeBounds.intersects(fruitBounds)){
            fruit.setNewFruitPosition();
        }
    }
    public void growSnake(){
        Point head = body.getFirst();
        Point newHead = new Point(head);

        switch (direction){
            case UP:
                newHead.y--;
                break;
            case DOWN:
                newHead.y++;
                break;
            case RIGHT:
                newHead.x--;
                break;
            case LEFT:
                newHead.x++;
                break;
        }
        body.addFirst(newHead);
    }

    public static void changeDirection(Direction newDirection){
        if(newDirection != direction){
            direction = newDirection;
        }
    }

    public boolean checkCollisionSnake(Point point){
        return body.contains(point);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}