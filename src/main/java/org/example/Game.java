package org.example;

import javax.swing.*;
import java.awt.*;

public class Game {
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, loadButtonPanel;
    JLabel titleNameLabel;
    Container con;
    Font titleFont = new Font("Gotham", Font.PLAIN, 90);
    Font buttonText = new Font("Gotham", Font.PLAIN, 30);
    JButton startButton;
    JButton loadButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }

    public Game(){
        window = new JFrame("ADVENTURE");
        window.setSize(800,600);
        window.getContentPane().setBackground(Color.black);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setForeground(Color.white);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(210,400,200,100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFocusPainted(false);
        startButton.setFont(buttonText);

        loadButtonPanel = new JPanel();
        loadButtonPanel.setBounds(370,400,200,100);
        loadButtonPanel.setBackground(Color.black);

        loadButton = new JButton("LOAD");
        loadButton.setBackground(Color.black);
        loadButton.setForeground(Color.white);
        loadButton.setFocusPainted(false);
        loadButton.setFont(buttonText);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        loadButtonPanel.add(loadButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(loadButtonPanel);
    }
}
