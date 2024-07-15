package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;

public class ScaleCommand implements Command {

    private final GraphicObject go;
    private final double factor;

    public ScaleCommand(GraphicObject go, double factor) {
        this.go = go;
        this.factor = factor;
    }

    @Override
    public boolean execute() {
        go.scale(factor);
        return true;
    }

    @Override
    public boolean undo() {
        go.scale(1.0 / factor);
        return true;
    }

}
