package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;

public class ListCommand implements Command {

    private final GraphicObject go;

    public ListCommand(GraphicObject go) {
        this.go = go;
    }

    @Override
    public boolean execute() {
        System.out.println(go);
        return true;
    }

    @Override
    public boolean undo() {
        return false;
    }
}
