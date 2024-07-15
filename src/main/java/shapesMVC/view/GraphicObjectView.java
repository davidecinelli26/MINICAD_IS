package shapesMVC.view;

import shapesMVC.model.GraphicObject;

import java.awt.*;

public interface GraphicObjectView {

    void drawGraphicObject(GraphicObject go, Graphics2D g);

}
