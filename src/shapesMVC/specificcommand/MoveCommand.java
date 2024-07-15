package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.Group;
import shapesMVC.model.GroupManager;
import shapesMVC.view.GraphicObjectPanel;

import java.awt.geom.Point2D;

public class MoveCommand implements Command {

    private Point2D newPos;
    private final String id;
    private boolean offset;


    public MoveCommand(String id, Point2D point, boolean offset) {
        this.id = id;
        this.offset = offset;
        this.newPos = point;
    }

    @Override
    public boolean execute() {
        if (id.matches("^obj\\d+$")) {
            GraphicObject go = GraphicObjectPanel.getInstance().getObject(id);
            if (offset)
                newPos = new Point2D.Double(go.getPosition().getX()+newPos.getX(), go.getPosition().getY()+newPos.getY());
            go.moveTo(newPos);
        } else if (id.matches("^grp\\d+$")) {
            Group group = GroupManager.getInstance().getGroup(id);
            if (offset)
                for (GraphicObject go: group.getMembers()) {
                    newPos = new Point2D.Double(go.getPosition().getX()+newPos.getX(), go.getPosition().getY()+newPos.getY());
                    go.moveTo(newPos);
                }
            else {
                for (GraphicObject go: group.getMembers())
                    go.moveTo(newPos);
            }
        } else {
            throw new IllegalArgumentException("id non valido");
        }
        return true;
    }

    @Override
    public boolean undo() {
        return true;
    }
}
