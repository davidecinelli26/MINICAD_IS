package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;

public class AreaCommand implements Command {

    private final GraphicObject go;

    public AreaCommand(GraphicObject go) {
        this.go = go;
    }

    @Override
    public boolean execute() {
        System.out.println("Area: " + go.area());
        return true;
    }

    @Override
    public boolean undo() {
        return true;
    }
}
