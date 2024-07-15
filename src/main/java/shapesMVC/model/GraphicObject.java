package shapesMVC.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public interface GraphicObject extends Cloneable {

    String getId();

    void setId(String id);

    void addGraphicObjectListener(GraphicObjectListener listener);

    void removeGraphicObjectListener(GraphicObjectListener listener);

    Point2D getPosition();

    Dimension2D getDimension();

    void moveTo(Point2D point);

    default void moveTo(double x, double y) {this.moveTo(new Point2D.Double(x,y));}

    void scale(double factor);

    boolean contains(Point2D point);

    double area();

    double perimeter();

    void ls();

    String getType();

}
