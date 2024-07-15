package shapesMVC.view;

import org.junit.jupiter.api.Test;
import shapesMVC.model.CircleObject;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

public class GraphicObjectPanelTest {

    @Test
    public void testAddGraphicObject() {
        GraphicObjectPanel panel = GraphicObjectPanel.getInstance();
        CircleObject circle = GraphicObjectPanel.getInstance().getCircle().clone();
        circle.setPosition(new Point2D.Double(40,40));
        circle.setRadius(50);
        panel.add(circle);
        assertTrue(panel.getGraphicObjects().containsValue(circle));
    }
}
