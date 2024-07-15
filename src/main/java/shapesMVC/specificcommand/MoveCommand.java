package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.Group;
import shapesMVC.model.GroupManager;
import shapesMVC.view.GraphicObjectPanel;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class MoveCommand implements Command {

    private final Point2D newPos;
    private Point2D oldPos;
    private List<Point2D> oldPosGroup;
    private final String id;
    private final boolean offset;


    public MoveCommand(String id, Point2D point, boolean offset) {
        this.id = id;
        this.offset = offset;
        this.newPos = point;
        oldPosGroup = new LinkedList<>();
    }

    @Override
    public boolean execute() {
        Point2D posOff = null;
        if (id.matches("^obj\\d+$")) {
            GraphicObject go = GraphicObjectPanel.getInstance().getObject(id);
            oldPos = go.getPosition();
            if (offset) {
                posOff = new Point2D.Double(oldPos.getX()+newPos.getX(), oldPos.getY()+newPos.getY());
                go.moveTo(posOff);
            }
            else
                go.moveTo(newPos);
        } else if (id.matches("^grp\\d+$")) {
            Group group = GroupManager.getInstance().getGroup(id);
            oldPosGroup = new LinkedList<>();
            for (GraphicObject go: group.getMembers())
                oldPosGroup.add(go.getPosition());
            if (offset)
                for (GraphicObject go: group.getMembers()) {
                    posOff = new Point2D.Double(go.getPosition().getX()+newPos.getX(), go.getPosition().getY()+newPos.getY());
                    go.moveTo(posOff);
                }
            else
                group.moveTo(newPos);
        } else {
            throw new IllegalArgumentException("id non valido");
        }
        return true;
    }

    @Override
    public boolean undo() {
        if (id.matches("^obj\\d+$")) {
            GraphicObject go = GraphicObjectPanel.getInstance().getObject(id);
            go.moveTo(oldPos);
        } else if (id.matches("^grp\\d+$")) {
            Group group = GroupManager.getInstance().getGroup(id);
            for (int i = 0; i < oldPosGroup.size(); i++)
                group.getMembers().get(i).moveTo(oldPosGroup.get(i));
        } else {
            throw new IllegalArgumentException("id non valido");
        }
        return true;
    }
}
