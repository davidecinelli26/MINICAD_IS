package shapesMVC.view;

import shapesMVC.model.CircleObject;
import shapesMVC.model.GraphicObject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class CircleObjectView implements GraphicObjectView {

    @Override
    public void drawGraphicObject(GraphicObject go, Graphics2D g) {
        CircleObject co = (CircleObject) go;
        Point2D position = co.getPosition();
        double radius = co.getRadius();
        double x = position.getX() - radius;
        double y = position.getY() - radius;
        g.draw(new Ellipse2D.Double(x, y, radius * 2.0, radius * 2.0));
    }

}
