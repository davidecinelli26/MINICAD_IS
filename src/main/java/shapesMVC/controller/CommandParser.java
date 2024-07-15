package shapesMVC.controller;

import command.Command;
import shapesMVC.model.*;
import shapesMVC.specificcommand.*;
import shapesMVC.view.GraphicObjectPanel;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class CommandParser {

    public Command parse(String input) {
        String[] tokens = input.split(" ");
        String cmd = tokens[0];

        switch (cmd) {
            case "new":
                return new CreateCommand(parseType(tokens));
            case "del":
                return new DeleteCommand(tokens[1]);
            case "mv":
                return new MoveCommand(tokens[1], parsePosition(tokens[2]), false);
            case "mvoff":
                return new MoveCommand(tokens[1], parsePosition(tokens[2]), true);
            case "scale":
                return new ScaleCommand(tokens[1], Double.parseDouble(tokens[2]));
            case "ls":
                return new ListCommand(tokens[1]);
            case "grp":
                return new GroupCommand(parseList(tokens));
            case "ungrp":
                return new UngroupCommand(tokens[1]);
            case "area":
                return new AreaCommand(tokens[1]);
            case "perimeter":
                return new PerimeterCommand(tokens[1]);
            default:
                throw new IllegalArgumentException("Comando sconosciuto: " + cmd);
        }
    }

    private GraphicObject parseType(String[] tokens) {
        GraphicObjectPanel panel = GraphicObjectPanel.getInstance();
        String type = tokens[1];
        switch (type) {
            case "circle":
                String id_c = panel.generateNextObjectId();
                double radius = Double.parseDouble(tokens[2].substring(1, tokens[2].length()-1));
                Point2D circle_center = parsePosition(tokens[3]);
                CircleObject circle = panel.getCircle().clone();
                circle.setId(id_c);
                circle.setRadius(radius);
                circle.setPosition(circle_center);
                return circle;
            case "rectangle":
                String id_r = panel.generateNextObjectId();
                Point2D rectangle_center = parsePosition(tokens[2]);
                Point2D rectangle_dimension = parsePosition(tokens[3]);
                RectangleObject rectangle = panel.getRectangle();
                rectangle.setId(id_r);
                rectangle.setPosition(rectangle_center);
                rectangle.setDimension(new Dimension((int) rectangle_dimension.getX(), (int) rectangle_dimension.getY()));
                return rectangle;
            case "image":
                String id_i = panel.generateNextObjectId();
                String path = tokens[2].substring(1, tokens[2].length()-1);
                Point2D image_center = parsePosition(tokens[3]);
                ImageObject image = panel.getImage();
                image.setId(id_i);
                image.setPath(path);
                image.setPosition(image_center);
                return image;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    private Point2D parsePosition(String token) {
        String[] coords = token.replace("(", "").replace(")", "").split(",");
        return new Point2D.Double(Double.parseDouble(coords[0]), Double.parseDouble(coords[1]));
    }

    private List<GraphicObject> parseList(String[] tokens) {
        List<GraphicObject> objects = new LinkedList<>();
        for (int i = 1; i < tokens.length; i++) {
            objects.add(GraphicObjectPanel.getInstance().getObject(tokens[i]));
        }
        return objects;
    }
}
