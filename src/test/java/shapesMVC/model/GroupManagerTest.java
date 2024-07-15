package shapesMVC.model;

import org.junit.jupiter.api.Test;
import shapesMVC.view.GraphicObjectPanel;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GroupManagerTest {

    @Test
    public void testCreateGroup() {
        GroupManager manager = GroupManager.getInstance();
        CircleObject circle = GraphicObjectPanel.getInstance().getCircle().clone();
        circle.setPosition(new Point2D.Double(30,30));
        circle.setRadius(100);
        LinkedList<GraphicObject> objects = new LinkedList<>();
        objects.add(circle);
        assertTrue(manager.getGroups().isEmpty());
        String idG = manager.createGroup(objects);
        assertTrue(manager.getGroup(idG).getMembers().equals(objects));
    }

    @Test
    public void testDeleteGroup() {
        GroupManager manager = GroupManager.getInstance();
        RectangleObject rectangle = GraphicObjectPanel.getInstance().getRectangle();
        rectangle.setPosition(new Point2D.Double(30,30));
        rectangle.setDimension(new Dimension(100,200));
        LinkedList<GraphicObject> objects = new LinkedList<>();
        objects.add(rectangle);
        assertTrue(manager.getGroups().isEmpty());
        String idG = manager.createGroup(objects);
        manager.removeGroup(idG);
        assertTrue(manager.getGroup(idG) == null);
    }
}
