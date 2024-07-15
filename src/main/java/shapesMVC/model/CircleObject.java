package shapesMVC.model;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class CircleObject extends AbstractGraphicObject {

    private Point2D position;

    private double radius;

    public CircleObject() {
        super("prototype");
    }

    @Override
    public Point2D getPosition() {
        return new Point2D.Double(position.getX(), position.getY());
    }

    @Override
    public Dimension2D getDimension() {
        Dimension dim = new Dimension();
        dim.setSize(2 * radius, 2 * radius);
        return dim;
    }

    @Override
    public void moveTo(Point2D point) {
        position.setLocation(point);
        notifyListeners(new GraphicObjectEvent(this));
    }

    @Override
    public void scale(double factor) {
        if (factor <= 0)
            throw new IllegalArgumentException();
        radius = radius * factor;
        notifyListeners(new GraphicObjectEvent(this));
    }

    @Override
    public boolean contains(Point2D point) {
        return position.distance(point) <= radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    public String toString() {
        return "CircleObject{" +
                "center=" + position +
                ", radius=" + radius +
                '}';
    }

    @Override
    public CircleObject clone() {
        CircleObject cloned = (CircleObject) super.clone();
        cloned.position = new Point2D.Double(0,0);
        cloned.radius = 0;
        return cloned;
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
