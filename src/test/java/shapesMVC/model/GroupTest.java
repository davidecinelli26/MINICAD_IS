package shapesMVC.model;

import org.junit.jupiter.api.Test;
import shapesMVC.view.GraphicObjectPanel;

import java.awt.geom.Point2D;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GroupTest {

    @Test
    public void testAddObject() {
        CircleObject circle = GraphicObjectPanel.getInstance().getCircle().clone();
        circle.setPosition(new Point2D.Double(30,30));
        circle.setRadius(100);
        LinkedList <GraphicObject> objects = new LinkedList<>();
        objects.add(circle);
        Group group = new Group("grp0", objects);
        assertTrue(group.getMembers().contains(circle));
    }
}
