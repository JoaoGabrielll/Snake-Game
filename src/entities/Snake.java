package entities;

import entities.enums.Direction;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;

    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(5, 5));
        direction = Direction.RIGHT;
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

    public void move(){
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
    }
    public void grow(){
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

    public boolean checkCollisionSnake(Point point){
        return body.contains(point);
    }

}