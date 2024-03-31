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
    private boolean hasEatenFruit;
    private Fruit fruit;

    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(5, 5));
        hasEatenFruit = false;
        direction = Direction.RIGHT;
        timer = new Timer(100,this);
        timer.start();
        this.fruit = new Fruit();
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

    public void moveSnake(){
        Point head = new Point(body.getFirst());

        switch (direction){
            case UP:
                head.y -= tileSize;
                break;
            case DOWN:
                head.y += tileSize;
                break;
            case LEFT:
                head.x -= tileSize;
                break;
            case RIGHT:
                head.x += tileSize;
                break;
        }

        if(head.equals(fruit.getFruitPosition())) {
            increaseSize();
            fruit.spawFruitRandom();
            hasEatenFruit = true;
        }else{
            body.removeLast();
            hasEatenFruit = false;
        }

        Rectangle snakeBounds = new Rectangle(head.x, head.y, tileSize, tileSize);
        Rectangle fruitBounds = fruit.getBounds();

        if(snakeBounds.intersects(fruitBounds)){
            fruit.setNewFruitPosition();
            hasEatenFruit = true;
        }else{
            hasEatenFruit = false;
        }
    }
    public void growSnake(){
        Point head = new Point(body.getFirst());

        switch (direction){
            case UP:
                head.y--;
                break;
            case DOWN:
                head.y++;
                break;
            case RIGHT:
                head.x--;
                break;
            case LEFT:
                head.x++;
                break;
        }
        body.addFirst(head);
    }

    public boolean hasEatenFruit(){
        return hasEatenFruit;
    }

    public void increaseSize(){
        Point tail = body.getLast();
        Point newSegment = new Point(tail.x, tail.y);
        body.addLast(newSegment);
    }

    public void checkCollisionSnake(Point fruitPosition){
        Point head = body.getFirst();

        if(head.equals(fruitPosition)){
            increaseSize();
            hasEatenFruit = true;
        }
    }

    public static void changeDirection(Direction newDirection){
        if(newDirection != direction){
            direction = newDirection;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
    }
}