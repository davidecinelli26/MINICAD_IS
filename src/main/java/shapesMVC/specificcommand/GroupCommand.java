package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.GroupManager;

import java.util.List;

public class GroupCommand implements Command {

    private List<GraphicObject> objectsToGroup;
    private String idG;

    public GroupCommand(List<GraphicObject> objectsToGroup) {
        this.objectsToGroup = objectsToGroup;
    }

    @Override
    public boolean execute() {
        GroupManager groupManager = GroupManager.getInstance();
        idG = groupManager.createGroup(objectsToGroup);
        return true;
    }

    @Override
    public boolean undo() {
        GroupManager.getInstance().removeGroup(idG);
        return true;
    }
}
