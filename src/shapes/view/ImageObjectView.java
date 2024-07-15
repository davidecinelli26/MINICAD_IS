package shapes.view;

import shapes.model.GraphicObject;
import shapes.model.ImageObject;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class ImageObjectView implements GraphicObjectView {
	@Override
	public void drawGraphicObject(GraphicObject go, Graphics2D g) {
		ImageObject io = (ImageObject) go;
		Dimension2D dim = io.getDimension();
		Point2D position = io.getPosition();
		Image image = io.getImage();
		int w = (int) (dim.getWidth());
		int h = (int) (dim.getHeight());
		int x = (int) (position.getX()) - w / 2;
		int y = (int) (position.getY()) - h / 2;

		g.drawImage(image, x, y, w, h, null);

	}
}
