package shapesMVC.model;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class RectangleObject extends AbstractGraphicObject {

    private Point2D position;

    private Dimension2D dimension;


    public RectangleObject(Point2D position, double width, double height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException();
        //this.id = id;
        this.dimension = new Dimension();
        this.dimension.setSize(width, height);
        this.position = new Point2D.Double(position.getX(), position.getY());
    }

    @Override
    public Point2D getPosition() {
        return new Point2D.Double(position.getX(), position.getY());
    }

    @Override
    public Dimension2D getDimension() {
        Dimension dim = new Dimension();
        dim.setSize(dimension);
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
        dimension.setSize(dimension.getWidth() * factor, dimension.getHeight() * factor);
        notifyListeners(new GraphicObjectEvent(this));
    }

    @Override
    public boolean contains(Point2D point) {
        double width = dimension.getWidth() / 2;
        double height = dimension.getHeight() / 2;
        double dx = Math.abs(point.getX() - position.getX());
        double dy = Math.abs(point.getY() - position.getY());
        return dx <= width && dy <= height;
    }

    @Override
    public double area() {
        return dimension.getWidth() * dimension.getHeight();
    }

    @Override
    public double perimeter() {
        return 2 * (dimension.getWidth() + dimension.getHeight());
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return "RectangleObject{" +
                "center=" + position +
                ", dimension=" + dimension +
                '}';
    }

    @Override
    public RectangleObject clone() {
        RectangleObject cloned = (RectangleObject) super.clone();
        cloned.position = (Point2D) position.clone();
        cloned.dimension = (Dimension2D) dimension.clone();
        return cloned;

    }
}
