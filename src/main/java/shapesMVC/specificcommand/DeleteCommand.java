package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.Group;
import shapesMVC.model.GroupManager;
import shapesMVC.view.GraphicObjectPanel;

public class DeleteCommand implements Command {

    private final String id;
    private Group group;
    private GraphicObject go;

    public DeleteCommand(String id) {
        this.id = id;
    }

    @Override
    public boolean execute() {
        GroupManager groupManager = GroupManager.getInstance();
        GraphicObjectPanel panel = GraphicObjectPanel.getInstance();

        if (groupManager.getGroup(id) != null) {
            group = groupManager.getGroup(id);
            groupManager.removeGroup(id);
            for (GraphicObject go: group.getMembers())
                panel.remove(go);
        } else if (panel.getObject(id) != null) {
            go = panel.getObject(id);
            panel.remove(go);
        } else {
            throw new IllegalArgumentException("Nessun oggetto o gruppo trovato con ID: " + id);
        }
        return true;
    }

    @Override
    public boolean undo() {
        if (group != null) {
            GroupManager.getInstance().getGroups().put(group.getId(), group);
            for (GraphicObject gr_obj: group.getMembers())
                GraphicObjectPanel.getInstance().add(gr_obj);
        } else
            GraphicObjectPanel.getInstance().add(go);
        return true;
    }
}
