package shapes.view;

import shapes.model.GraphicObject;

import java.awt.*;

public interface GraphicObjectView {
	void drawGraphicObject(GraphicObject go, Graphics2D g);
}
