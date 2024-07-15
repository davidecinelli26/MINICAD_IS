package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.Group;

public class UngroupCommand implements Command {

    private GraphicObject go;
    private Group group;

    public UngroupCommand(GraphicObject go) {
        this.go = go;
    }

    @Override
    public boolean execute() {
        group = null;
        return true;
    }

    @Override
    public boolean undo() {
        return false;
    }
}

