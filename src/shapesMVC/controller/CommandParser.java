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
import java.util.LinkedList;
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
                return new DeleteCommand(panel, tokens[1]);
            case "mv":
                return new MoveCommand(tokens[1], parsePosition(tokens[2]), false);
            case "mvoff":
                return new MoveCommand(tokens[1], parsePosition(tokens[2]), true);
            case "scale":
                GraphicObject go_scale = panel.getGraphicObjects().get(tokens[1]);
                return new ScaleCommand(go_scale, Double.parseDouble(tokens[2]));
            case "ls":
                return new ListCommand(tokens[1]);
            case "grp":
                LinkedList <GraphicObject> objects = new LinkedList<>();
                for (int i = 1; i < tokens.length; i++)
                    objects.add(panel.getGraphicObjects().get(tokens[i]));
                return new GroupCommand(objects);
                /*
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
                String id_c = panel.generateNextObjectId();
                double radius = Double.parseDouble(tokens[2].substring(1, tokens[2].length()-1));
                Point2D circle_center = parsePosition(tokens[3]);
                return new CircleObject(id_c, circle_center, radius);
            case "rectangle":
                String id_r = panel.generateNextObjectId();
                Point2D rectangle_center = parsePosition(tokens[2]);
                Point2D rectangle_dimension = parsePosition(tokens[3]);
                return new RectangleObject(id_r, rectangle_center, rectangle_dimension.getX(), rectangle_dimension.getY());
            case "image":
                String id_i = panel.generateNextObjectId();
                String path = tokens[2].substring(1, tokens[2].length()-1);
                Point2D image_center = parsePosition(tokens[3]);
                return new ImageObject(id_i, path, image_center);
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
