package shapesMVC.controller;

import command.Command;
import shapesMVC.model.CircleObject;
import shapesMVC.model.GraphicObject;
import shapesMVC.model.ImageObject;
import shapesMVC.model.RectangleObject;
import shapesMVC.specificcommand.*;
import shapesMVC.view.GraphicObjectPanel;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    private GraphicObjectPanel panel;

    public CommandParser(GraphicObjectPanel panel) {
        this.panel = panel;
    }

    public Command parse(String input) {
        String[] tokens = input.split(" ");
        String cmd = tokens[0];

        switch (cmd) {
            case "new":
                return new CreateCommand(panel, parseType(tokens));
            case "del":
                GraphicObject go_del = panel.getGraphicObjects().get(tokens[1]);
                return new DeleteCommand(panel, go_del);
            case "mv":
                GraphicObject go_mv = panel.getGraphicObjects().get(tokens[1]);
                return new MoveCommand(go_mv, parsePosition(tokens[2]), false);
            case "mvoff":
                GraphicObject go_mvoff = panel.getGraphicObjects().get(tokens[1]);
                return new MoveCommand(go_mvoff, parsePosition(tokens[2]), true);
            case "scale":
                GraphicObject go_scale = panel.getGraphicObjects().get(tokens[1]);
                return new ScaleCommand(go_scale, Double.parseDouble(tokens[2]));
            case "ls":
                GraphicObject go_ls = panel.getGraphicObjects().get(tokens[1]);
                return new ListCommand(go_ls);
                /*
            case "grp":
                return new GroupCommand();
            case "ungrp":
                return new UngroupCommand();
                 */
            case "area":
                GraphicObject go_area = panel.getGraphicObjects().get(tokens[1]);
                return new AreaCommand(go_area);
            case "perimeter":
                GraphicObject go_perimeter = panel.getGraphicObjects().get(tokens[1]);
                return new PerimeterCommand(go_perimeter);
            default:
                throw new IllegalArgumentException("Comando sconosciuto: " + cmd);
        }
    }

    private GraphicObject parseType(String[] tokens) {
        String type = tokens[1];
        switch (type) {
            case "circle":
                double radius = Double.parseDouble(tokens[2].substring(1, tokens[2].length()-1));
                Point2D circle_center = parsePosition(tokens[3]);
                return new CircleObject(circle_center, radius);
            case "rectangle":
                Point2D rectangle_center = parsePosition(tokens[2]);
                Point2D rectangle_dimension = parsePosition(tokens[3]);
                return new RectangleObject(rectangle_center, rectangle_dimension.getX(), rectangle_dimension.getY());
            case "image":
                String path = tokens[2].substring(1, tokens[2].length()-1);
                Point2D image_center = parsePosition(tokens[3]);
                return new ImageObject(path, image_center);
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    private Point2D parsePosition(String token) {
        String[] coords = token.replace("(", "").replace(")", "").split(",");
        return new Point2D.Double(Double.parseDouble(coords[0]), Double.parseDouble(coords[1]));
    }

    private List<String> parseList(String token) {
        String[] ids = token.split(",");
        List<String> objIDs = new ArrayList<>();
        for (String id : ids) {
            objIDs.add(id.trim());
        }
        return objIDs;
    }
}
