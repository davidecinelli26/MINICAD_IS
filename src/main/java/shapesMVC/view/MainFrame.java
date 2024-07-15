package shapesMVC.view;

import shapesMVC.controller.CommandInterpreter;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static JTextArea outputArea;

    public static void setup(CommandInterpreter interpreter) {
        JFrame frame = new JFrame("PROGETTO MINICAD IS");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font textFont = new Font("Arial", Font.PLAIN, 18);

        GraphicObjectPanel panel = GraphicObjectPanel.getInstance();
        mainPanel.add(panel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3,1));

        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel inputLabel = new JLabel("Inserisci un comando:");
        inputLabel.setFont(labelFont);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        JTextArea commandInputArea = new JTextArea(3, 30);
        commandInputArea.setFont(textFont);
        inputPanel.add(new JScrollPane(commandInputArea), BorderLayout.CENTER);
        bottomPanel.add(inputPanel);

        JPanel outputPanel = new JPanel(new BorderLayout());
        JLabel outputLabel = new JLabel("Output:");
        outputLabel.setFont(labelFont);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputArea = new JTextArea(5, 30);
        outputArea.setFont(textFont);
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        bottomPanel.add(outputPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton executeButton = new JButton("Execute");
        executeButton.setPreferredSize(new Dimension(120,40));
        executeButton.setFont(labelFont);
        executeButton.addActionListener(e -> {
            String commandText = commandInputArea.getText();
            executeCommand(interpreter, commandText);
            commandInputArea.setText("");
        });
        buttonPanel.add(executeButton);
        bottomPanel.add(buttonPanel);

        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void executeCommand(CommandInterpreter interpreter, String input) {
        if (input.equalsIgnoreCase("undo")) {
            interpreter.undo();
        } else if (input.equalsIgnoreCase("redo")) {
            interpreter.redo();
        } else {
            interpreter.executeCommand(input);
        }
    }

    public static void appendOutput(String output) {
        outputArea.append(output + "\n");
    }
}
