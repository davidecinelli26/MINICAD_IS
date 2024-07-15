package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.GroupManager;

import java.util.List;

public class GroupCommand implements Command {

    private List<GraphicObject> objectsToGroup;

    public GroupCommand(List<GraphicObject> objectsToGroup) {
        this.objectsToGroup = objectsToGroup;
    }

    @Override
    public boolean execute() {
        GroupManager groupManager = GroupManager.getInstance();
        groupManager.createGroup(objectsToGroup);
        return true;
    }

    @Override
    public boolean undo() {
        return true;
    }
}
