package shapesMVC.specificcommand;

import org.junit.jupiter.api.Test;
import shapesMVC.model.CircleObject;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.GroupManager;
import shapesMVC.view.GraphicObjectPanel;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class UngroupCommandTest {

    @Test
    public void testExecute() {
        GroupManager groupManager = GroupManager.getInstance();
        GraphicObjectPanel panel = GraphicObjectPanel.getInstance();
        CircleObject circle1 = panel.getCircle();
        circle1.setPosition(new Point2D.Double(30,30));
        circle1.setRadius(100);
        circle1.setId("obj0");

        CircleObject circle2 = panel.getCircle();
        circle2.setPosition(new Point2D.Double(100,200));
        circle2.setRadius(200);
        circle2.setId("obj1");

        panel.add(circle1);
        panel.add(circle2);

        LinkedList <GraphicObject> objects = new LinkedList<>();
        objects.add(circle1);
        objects.add(circle2);

        String idG = groupManager.createGroup(objects);

        assertTrue(groupManager.getGroup(idG).getMembers().contains(circle1));
        assertTrue(groupManager.getGroup(idG).getMembers().contains(circle2));

        UngroupCommand ungroupCommand = new UngroupCommand(idG);
        ungroupCommand.execute();

        assertTrue(groupManager.getGroup(idG) == null);

        Collection <GraphicObject> objects_all = panel.getGraphicObjects().values();
        assertTrue(objects_all.contains(circle1));
        assertTrue(objects_all.contains(circle2));
    }
}
