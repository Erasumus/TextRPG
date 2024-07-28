package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, galleryButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleNameFont = new Font("Gotham", Font.PLAIN, 60);
    Font textButton = new Font("Gotham", Font.PLAIN, 30);
    Font normalText = new Font("Gotham", Font.PLAIN, 28);
    JButton galleryButton, startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }

    public Game(){
        window = new JFrame("ADVENTURE");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,600);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        //Создание панели titleNamePanel
        titleNamePanel = PanelFactory.createPanel(
                Color.black,
                80, 100, 600, 150);
        titleNameLabel = PanelFactory.createLabel(
                "ADVENTURE",
                titleNameFont,
                Color.white);
        titleNamePanel.add(titleNameLabel);
        con.add(titleNamePanel);

        //Создание панели startButtonPanel
        startButtonPanel = PanelFactory.createPanel(
                Color.black,
                180, 400, 200, 100);
        startButton = PanelFactory.createButton(
                "START",
                textButton,
                Color.black,
                Color.white,
                false,
                tsHandler);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        //Создание панели galleryButtonPanel
        galleryButtonPanel = PanelFactory.createPanel(Color.black, 405, 400, 200, 100);
        galleryButton = PanelFactory.createButton(
                "GALLERY",
                textButton,
                Color.black,
                Color.white,
                false);
        galleryButtonPanel.add(galleryButton);
        con.add(galleryButtonPanel);
    }

    //Создание нового окна
    public void createGameScreen(){
        //Скрываем панели при переходе окна
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        galleryButtonPanel.setVisible(false);

        //Панель текст окна
        mainTextPanel = PanelFactory.createPanel(Color.black, 100, 100, 600, 250);
        mainTextArea = PanelFactory.createTextArea(
                "This is the main text area. This game is going to be great. I'm sure of it!!!",
                normalText,
                Color.black,
                Color.white,
                false,
                100, 100, 600, 250);
        mainTextPanel.add(mainTextArea);
        con.add(mainTextPanel);

        //Панель для кнопок выбора действий
        choiceButtonPanel = PanelFactory.createPanel(Color.black, 250, 350, 300, 150);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

        // Выбор действия
        choice1 = PanelFactory.createButton(
                "Choice 1",
                textButton,
                Color.black,
                Color.white,
                false,
                choiceHandler,
                "c1");
        choiceButtonPanel.add(choice1);
        choice2 = PanelFactory.createButton(
                "Choice 2",
                textButton,
                Color.black,
                Color.white,
                false,
                choiceHandler,
                "c2");
        choiceButtonPanel.add(choice2);
        choice3 = PanelFactory.createButton(
                "Choice 3",
                textButton,
                Color.black,
                Color.white,
                false,
                choiceHandler,
                "c3");
        choiceButtonPanel.add(choice3);
        choice4 = PanelFactory.createButton(
                "Choice 4",
                textButton,
                Color.black,
                Color.white,
                false,
                choiceHandler,
                "c4");
        choiceButtonPanel.add(choice4);

        //Панель характеристик
        playerPanel = PanelFactory.createPanel(Color.black, 100, 15, 600, 50);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        // hp панель
        hpLabel = PanelFactory.createLabel(
                "HP: ",
                textButton,
                Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = PanelFactory.createLabel(
                "",
                normalText,
                Color.white);
        playerPanel.add(hpLabelNumber);

        // weapon панель
        weaponLabel = PanelFactory.createLabel(
                "Weapon: ",
                normalText,
                Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName = PanelFactory.createLabel(
                "",
                textButton,
                Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();
    }

    //Задаем стандартные значения игрока
    public void playerSetup(){
         playerHP = 15;
         weapon = "Knife";
         weaponLabelName.setText(weapon);
         hpLabelNumber.setText("" + playerHP);

         townGate();
    }

    public void townGate(){
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you.\n\nWhat do you do?");

        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello stranger.\nI have never seen you face.I'm sorry but we cannot let a stranger enter our town");

        choice1.setText("OK");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back hit you hard.\n(You receive 3 damage)");
        playerHP = playerHP - 3;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("OK");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad(){}

    //Обработчик нажатий кнопки
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }


    public class ChoiceHandler extends TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch(position){
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            talkGuard();
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "talkGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "attackGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
            }

            }
        }
    }
