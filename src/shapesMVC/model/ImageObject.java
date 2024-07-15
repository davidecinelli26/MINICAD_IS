package shapesMVC.model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class ImageObject extends AbstractGraphicObject {

    private final Image image;

    private double factor = 1.0;

    private Point2D position;

    public ImageObject(String id, String path, Point2D position)
    {
        super(id);
        this.position = new Point2D.Double(position.getX(), position.getY());
        this.image = new ImageIcon(path).getImage();
    }

    @Override
    public Point2D getPosition() {
        return new Point2D.Double(position.getX(), position.getY());
    }

    @Override
    public Dimension2D getDimension() {
        Dimension dim = new Dimension();
        dim.setSize(image.getWidth(null) * factor, image.getHeight(null) * factor);
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
        this.factor *= factor;
        notifyListeners(new GraphicObjectEvent(this));
    }

    @Override
    public boolean contains(Point2D point) {
        double width = (factor * image.getWidth(null)) / 2;
        double height = (factor * image.getHeight(null)) / 2;
        double dx = Math.abs(point.getX() - position.getX());
        double dy = Math.abs(point.getY() - position.getY());
        return dx <= width && dy <= height;
    }

    @Override
    public double area() {
        return image.getWidth(null) * image.getHeight(null);
    }

    @Override
    public double perimeter() {
        return 2 * (image.getWidth(null) + image.getHeight(null));
    }

    @Override
    public String getType() {
        return "Image";
    }

    @Override
    public String toString() {
        return "ImageObject{" +
                "image=" + image +
                ", factor=" + factor +
                ", center=" + position +
                '}';
    }

    @Override
    public ImageObject clone() {
        ImageObject cloned = (ImageObject) super.clone();
        cloned.position = (Point2D) position.clone();
        return cloned;
    }

    public Image getImage() {
        return image;
    }
}
