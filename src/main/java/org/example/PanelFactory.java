package org.example;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;

public class PanelFactory {
    public static JPanel createPanel(Color background, int x, int y, int width, int height){
        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setBounds(x, y, width, height);
        return panel;
    }

    public static JLabel createLabel(String text, Font font, Color background, Color foreground){
        JLabel label = createLabel(text, font, foreground);
        label.setBackground(background);
        return label;
    }

    public static JLabel createLabel(String text, Font font, Color foreground){
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(foreground);
        return label;
    }

    public static JButton createButton(String text, Font font, Color background, Color foreground, Boolean setFocus, Game.TitleScreenHandler handler, String command){
        JButton button = createButton(text, font, background, foreground, setFocus, handler);
        button.setActionCommand(command);
        return button;
    }

    public static JButton createButton(String text, Font font, Color background, Color foreground, Boolean setFocus, Game.TitleScreenHandler handler){
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFocusPainted(setFocus);
        button.setFont(font);
        button.addActionListener(handler);
        return button;
    }

    public static JButton createButton(String text, Font font, Color foreground, Boolean setFocus, Game.TitleScreenHandler handler){
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setForeground(foreground);
        button.setFont(font);
        button.addActionListener(handler);
        return button;
    }

    public static JButton createButton(String text, Font font, Color background, Color foreground, Boolean setFocus){
        JButton button = new JButton(text);
        button.setFocusPainted(setFocus);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFont(font);
        return button;
    }

    public static JTextArea createTextArea(String text, Font font, Color background, Color foreground, Boolean setFocus, int x, int y, int width, int height){
        JTextArea textArea = new JTextArea(text);
        textArea.setFont(font);
        textArea.setBounds(x, y, width, height);
        textArea.setForeground(foreground);
        textArea.setBackground(background);
        textArea.setLineWrap(true);
        return textArea;
    }
}
