package shapesMVC.view;

import shapesMVC.model.GraphicObject;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RectangleObjectView implements  GraphicObjectView {

    @Override
    public void drawGraphicObject(GraphicObject go, Graphics2D g) {
        Point2D position = go.getPosition();
        Dimension2D dimension = go.getDimension();
        double x = position.getX() - dimension.getWidth() / 2.0;
        double y = position.getY() - dimension.getHeight() / 2.0;
        g.draw(new Rectangle2D.Double(x, y, dimension.getWidth(), dimension.getHeight()));
    }

}
