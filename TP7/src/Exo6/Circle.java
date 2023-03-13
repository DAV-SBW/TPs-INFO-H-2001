package Exo6;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import java.util.Random;

public class Circle extends Shape implements Runnable {

    static Random r = new Random();

    private javafx.scene.shape.Circle c;
    private double radius;
    private Thread t;

    public Circle(Drawing d, Point origin, double radius, Color color){
        super(d, origin);
        Random r = new Random();
        this.radius = radius;
        this.color = color;
        this.hDirection = r.nextInt(2)+1;
        this.vDirection = r.nextInt(2)+3;
        c = new javafx.scene.shape.Circle();
        c.setCenterX(origin.getX());
        c.setCenterY(origin.getY());
        c.setRadius(radius);
        c.setFill(color);

        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            if (bottomLeft == null) {
                computeBounds();
            } if (this.touchLine(topLeft, topRight)) {
                vDirection = Circle.DOWN;
                hDirection = r.nextInt(2) + 1;
            } else if (this.touchLine(bottomLeft, bottomRight)) {
                vDirection = Circle.UP;
                hDirection = r.nextInt(2) + 1;
            } if (this.touchLine(topLeft, bottomLeft)) {
                hDirection = Circle.RIGHT;
                vDirection = r.nextInt(2) + 3;
            } else if (this.touchLine(topLeft, bottomRight)) {
                hDirection = Circle.LEFT;
                vDirection = r.nextInt(2) + 3;
            }
            move();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void move() {
        if(hDirection == LEFT) {
            origin.setX(origin.getX() - 1);
        } else if(hDirection == RIGHT) {
            origin.setX(origin.getX() + 1);
        } if(vDirection == UP) {
            origin.setY(origin.getY() - 1);
        } else if(vDirection == DOWN) {
            origin.setY(origin.getY() + 1);
        }
    }

    private boolean touchLine(Point p1, Point p2) {
        // Calcul de la distance du centre ^ la ligne (p1, p2)
        double x0 = origin.getX();
        double y0 = origin.getY();
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p1.getX();
        double y2 = p2.getY();
        double distance = Math.abs(((x2-x1)*(y1-y0)-(x1-x0)*(y2-y1)))/Math.sqrt(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));

        return distance<radius;

    }

    @Override
    public void setOrigin(Point point) {
        origin.setX(point.getX());
        origin.setY(point.getY());
    }

    private double distanceToCenter(Point p){
        return this.origin.distance(p);
    }

    @Override
    public boolean isOn(Point p) {
        return distanceToCenter(p)<radius;
    }

    @Override
    public void update() {
        c.setCenterY(origin.getY());
        c.setCenterX(origin.getX());
    }

    @Override
    public Node getShape() {
        return c;
    }
}
