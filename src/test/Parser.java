package test;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Parser {
    private final StreamTokenizer tokenizer;

    public Parser(String input) {
        tokenizer = new StreamTokenizer(new StringReader(input));
    }

    public void parse() throws IOException {
        int token = tokenizer.nextToken();
        switch (token) {
            case StreamTokenizer.TT_WORD:
                switch (tokenizer.sval) {
                    case "new":
                        parseCreate();
                        break;
                    case "del":
                        //return parseRemove();
                    case "mv":
                    case "mvoff":
                        //return parseMove(tokenizer.getString());
                    case "scale":
                        //return parseScale();
                    case "ls":
                        //return parseList();
                    case "grp":
                        //return parseGroup();
                    case "ungrp":
                        //return parseUngroup();
                    case "area":
                        //return parseArea();
                    case "perimeter":
                        //return parsePerimeter();
                    default:
                        throw new IllegalArgumentException("Unknown command: " + tokenizer.sval);
                }
            default:
                throw new IllegalArgumentException("Unexpected token: " + token);
        }
    }

    private void parseCreate() throws IOException {
        tokenizer.nextToken();
        String type = tokenizer.sval;
        switch (type) {
            case "circle":
                System.out.println("cerchio");
                break;
            case "rectangle":
                System.out.println("rettangolo");
                break;
            case "img":
                System.out.println("image");
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

/*
    private double parsePosFloat() throws IOException {
        tokenizer.nextToken();
        if (tokenizer.getTokenType() == StreamTokenizer.TT_NUMBER) {
            return tokenizer.getNumber();
        } else {
            throw new IllegalArgumentException("Expected a floating point number");
        }
    }

    private Point2D parsePos() throws IOException {
        tokenizer.nextToken(); // '('
        double x = parsePosFloat();
        tokenizer.nextToken(); // ','
        double y = parsePosFloat();
        tokenizer.nextToken(); // ')'
        return new Point2D.Double(x, y);
    }

    private String parsePath() throws IOException {
        tokenizer.nextToken(); // '"'
        return tokenizer.getString();
    }

    private String parseObjID() throws IOException {
        tokenizer.nextToken();
        return tokenizer.getString();
    }

    private List<String> parseListID() throws IOException {
        List<String> ids = new ArrayList<>();
        do {
            ids.add(parseObjID());
            tokenizer.nextToken(); // ',' or end
        } while (tokenizer.getTokenType() == ',');
        return ids;
    }
*/
}

