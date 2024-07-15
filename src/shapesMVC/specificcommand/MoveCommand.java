package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;

import java.awt.geom.Point2D;

public class MoveCommand implements Command {

    private final Point2D oldPos, newPos;
    private final GraphicObject go;


    public MoveCommand(GraphicObject go, Point2D newPos, boolean offset) {
        this.oldPos = go.getPosition();
        if (!offset)
            this.newPos = newPos;
        else
            this.newPos = new Point2D.Double(oldPos.getX() + newPos.getX(), oldPos.getY() + newPos.getY());
        this.go = go;
    }

    @Override
    public boolean execute() {
        go.moveTo(newPos);
        return true;
    }

    @Override
    public boolean undo() {
        go.moveTo(oldPos);
        return true;
    }
}
