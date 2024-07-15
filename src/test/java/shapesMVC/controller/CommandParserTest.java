package shapesMVC.controller;

import command.Command;
import org.junit.jupiter.api.Test;
import shapesMVC.model.CircleObject;
import shapesMVC.specificcommand.CreateCommand;

import static org.junit.jupiter.api.Assertions.*;

public class CommandParserTest {

    @Test
    public void testParse() {
        CommandParser parser = new CommandParser();
        String input = "new circle (80.0) (200.0,200.0)";
        Command cmd = parser.parse(input);
        assertTrue(cmd instanceof CreateCommand);

        CreateCommand createCommand = (CreateCommand) cmd;

        CircleObject circle = (CircleObject) createCommand.getGraphicObject() ;
        assertEquals(80.0, circle.getRadius());
        assertEquals(200.0, circle.getPosition().getX());
        assertEquals(200.0, circle.getPosition().getY());
    }
}
