package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.Group;
import shapesMVC.model.GroupManager;
import shapesMVC.view.GraphicObjectPanel;

public class ListCommand implements Command {

    private final String id;

    public ListCommand(String id) {
        this.id = id;
    }

    @Override
    public boolean execute() {
        if (id.matches("all")) {
            for (GraphicObject go: GraphicObjectPanel.getInstance().getGraphicObjects().values())
                go.ls();
        } else if (id.matches("groups")) {
            for (Group group: GroupManager.getInstance().getGroups().values())
                group.ls();
        } else if (id.matches("circle|rectangle|image")) {
            for (GraphicObject go: GraphicObjectPanel.getInstance().getGraphicObjects().values())
                if (go.getType().equalsIgnoreCase(id))
                    go.ls();
        } else if (id.matches("^obj\\d+$")) {
            GraphicObject go = GraphicObjectPanel.getInstance().getObject(id);
            go.ls();
        } else if (id.matches("^grp\\d+$")) {
            Group group = GroupManager.getInstance().getGroup(id);
            group.ls();
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
