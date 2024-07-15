package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.Group;
import shapesMVC.model.GroupManager;
import shapesMVC.view.GraphicObjectPanel;

public class ScaleCommand implements Command {

    private final String id;
    private final double factor;

    public ScaleCommand(String id, double factor) {
        this.id = id;
        this.factor = factor;
    }

    @Override
    public boolean execute() {
        if (id.matches("^grp\\d+$")) {
            Group group = GroupManager.getInstance().getGroup(id);
            group.scale(factor);
        } else if (id.matches("^obj\\d+$")) {
            GraphicObject go = GraphicObjectPanel.getInstance().getObject(id);
            go.scale(factor);
        } else
            throw new IllegalArgumentException("id non valido");
        return true;
    }

    @Override
    public boolean undo() {
        if (id.matches("^grp\\d+$")) {
            Group group = GroupManager.getInstance().getGroup(id);
            group.scale(1/factor);
        } else if (id.matches("^obj\\d+$")) {
            GraphicObject go = GraphicObjectPanel.getInstance().getObject(id);
            go.scale(1/factor);
        } else
            throw new IllegalArgumentException("id non valido");
        return true;
    }

}
