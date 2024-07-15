package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.Group;
import shapesMVC.model.GroupManager;

public class UngroupCommand implements Command {

    private String id;
    private Group group;

    public UngroupCommand(String id) {
        this.id = id;
    }

    @Override
    public boolean execute() {
        if (id.matches("^grp\\d+$")) {
            group = GroupManager.getInstance().getGroup(id);
            GroupManager.getInstance().removeGroup(id);
        } else
            throw new IllegalArgumentException("id non valido");
        return true;
    }

    @Override
    public boolean undo() {
        GroupManager.getInstance().getGroups().put(id, group);
        return true;
    }
}

