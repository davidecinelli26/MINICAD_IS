package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.Group;
import shapesMVC.model.GroupManager;
import shapesMVC.view.GraphicObjectPanel;
import shapesMVC.view.MainFrame;

public class AreaCommand implements Command {

    private final String id;

    public AreaCommand(String id) {
        this.id = id;
    }

    @Override
    public boolean execute() {
        if (id.matches("all")) {
            for (GraphicObject go: GraphicObjectPanel.getInstance().getGraphicObjects().values())
                MainFrame.appendOutput(go.area() + "");
        } else if (id.matches("circle|rectangle|image")) {
            for (GraphicObject go : GraphicObjectPanel.getInstance().getGraphicObjects().values())
                if (go.getType().equalsIgnoreCase(id))
                    MainFrame.appendOutput(go.area() + "");
        } else if (id.matches("^grp\\d+$")) {
            Group group = GroupManager.getInstance().getGroup(id);
            MainFrame.appendOutput(group.area() + "");
        } else if (id.matches("^obj\\d+$")) {
            GraphicObject go = GraphicObjectPanel.getInstance().getObject(id);
            MainFrame.appendOutput(go.area() + "");
        } else
            throw new IllegalArgumentException("id non valido");
        return true;
    }

    @Override
    public boolean undo() {
        return true;
    }
}
