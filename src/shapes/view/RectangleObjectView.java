package shapes.view;

import shapes.model.GraphicObject;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RectangleObjectView implements GraphicObjectView {
	@Override
	public void drawGraphicObject(GraphicObject go, Graphics2D g) {
		Point2D position = go.getPosition();
		Dimension2D dim = go.getDimension();
		double x = position.getX() - dim.getWidth() / 2.0;
		double y = position.getY() - dim.getHeight() / 2.0;
		g.draw(new Rectangle2D.Double(x, y, dim.getWidth(), dim.getHeight()));

	}
}
