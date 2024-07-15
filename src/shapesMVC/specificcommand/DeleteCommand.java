package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.Group;
import shapesMVC.model.GroupManager;
import shapesMVC.view.GraphicObjectPanel;

public class DeleteCommand implements Command {

    private final GraphicObjectPanel panel;
    private final String id;

    public DeleteCommand(GraphicObjectPanel panel, String id) {
        this.panel = panel;
        this.id = id;
    }

    @Override
    public boolean execute() {
        GroupManager groupManager = GroupManager.getInstance();
        GraphicObjectPanel panel = GraphicObjectPanel.getInstance();

        if (groupManager.getGroup(id) != null) {
            Group group = groupManager.getGroup(id);
            System.out.println(group + ": " + group.getMembers());
            groupManager.removeGroup(id);
            for (GraphicObject go: group.getMembers())
                panel.remove(go);
        } else if (panel.getObject(id) != null) {
            GraphicObject go = panel.getObject(id);
            panel.remove(go);
        } else {
            throw new IllegalArgumentException("Nessun oggetto o gruppo trovato con ID: " + id);
        }
        return true;
    }

    @Override
    public boolean undo() {
        return true;
    }
}
