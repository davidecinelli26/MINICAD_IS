package shapesMVC.view;

import shapesMVC.model.GraphicObject;
import shapesMVC.model.ImageObject;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class ImageObjectView implements GraphicObjectView {

    @Override
    public void drawGraphicObject(GraphicObject go, Graphics2D g) {
        ImageObject io = (ImageObject) go;
        Dimension2D dimension = io.getDimension();
        Point2D position = io.getPosition();
        Image image = io.getImage();
        int width = (int) (dimension.getWidth());
        int height = (int) (dimension.getHeight());
        int x = (int) (position.getX()) - width / 2;
        int y = (int) (position.getY()) - height / 2;
        g.drawImage(image, x, y, width, height, null);

    }

}
