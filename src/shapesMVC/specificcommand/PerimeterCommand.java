package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;

public class PerimeterCommand implements Command {

    private final GraphicObject go;

    public PerimeterCommand(GraphicObject go) {
        this.go = go;
    }

    @Override
    public boolean execute() {
        System.out.println("Perimeter: " + go.perimeter());
        return true;
    }

    @Override
    public boolean undo() {
        return true;
    }
}
