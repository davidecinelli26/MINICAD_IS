package shapesMVC.model;

import org.junit.jupiter.api.Test;
import shapesMVC.view.GraphicObjectPanel;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

public class CircleObjectTest {
    @Test
    public void testCircleArea() {
        CircleObject circle = GraphicObjectPanel.getInstance().getCircle();
        circle.setPosition(new Point2D.Double(30,30));
        circle.setRadius(5);
        double expectedArea = Math.PI * 5 * 5;
        assertEquals(expectedArea, circle.area(), 0.001);
    }

    @Test
    public void testCirclePerimeter() {
        CircleObject circle = GraphicObjectPanel.getInstance().getCircle();
        circle.setPosition(new Point2D.Double(30,30));
        circle.setRadius(5);
        double expectedPerimeter = 2 * Math.PI * 5;
        assertEquals(expectedPerimeter, circle.perimeter(), 0.001);
    }
}
