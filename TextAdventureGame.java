import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAdventureGameGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JButton choiceButton1;
    private JButton choiceButton2;

    private Player player;

    private int currentDecision;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextAdventureGameGUI gameGUI = new TextAdventureGameGUI();
            gameGUI.createAndShowGUI();
        });
    }

    public TextAdventureGameGUI() {
        player = new Player();
        currentDecision = 1;

        frame = new JFrame("Text Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        choiceButton1 = new JButton("Choice 1");
        choiceButton2 = new JButton("Choice 2");

        choiceButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChoice(1);
            }
        });

        choiceButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChoice(2);
            }
        });

        panel.add(textArea);
        panel.add(choiceButton1);
        panel.add(choiceButton2);

        frame.getContentPane().add(panel);
    }

    public void createAndShowGUI() {
        frame.pack();
        frame.setVisible(true);
        String playerName = JOptionPane.showInputDialog(frame, "Enter your character's name:");
        player.setName(playerName);
        displayStory("Welcome, " + player.getName() + ". You are a brave adventurer on a quest to find a treasure in a dark cave. You enter the cave and come across a fork in the path. What do you do?\n1. Go left\n2. Go right");
    }

    private void displayStory(String message) {
        textArea.setText(message);
    }

    private void handleChoice(int choice) {
        switch (currentDecision) {
            case 1:
                if (choice == 1) {
                    displayStory("You chose to go left. You encounter a dragon! What's your next move?\n1. Fight the dragon\n2. Run away");
                    currentDecision = 2;
                } else {
                    displayStory("You chose to go right. You find a treasure chest! What will you do now?\n1. Open the chest\n2. Leave the chest");
                    currentDecision = 3;
                }
                break;
            case 2:
                if (choice == 1) {
                    displayStory("You bravely fight the dragon and win! As you continue your journey, you find a mysterious key.");
                    player.addToInventory("Mysterious Key");
                    currentDecision = 4;
                } else {
                    displayStory("You run away from the dragon, back to the crossroads. What's your next move?\n1. Go left\n2. Go right");
                    currentDecision = 1;
                }
                break;
            case 3:
                if (choice == 1) {
                    displayStory("You decide to open the treasure chest. You find valuable jewels and gold!");
                    player.addToInventory("Jewels");
                    player.addToInventory("Gold");
                    currentDecision = 4;
                } else {
                    displayStory("You choose to leave the treasure chest and proceed further into the cave. You find a locked door.\n1. Try the mysterious key on the door\n2. Leave the door and explore more");
                    currentDecision = 5;
                }
                break;
            case 4:
                displayStory("With the key in hand, you venture deeper into the cave. You come across the locked door you saw earlier.\n1. Use the key to unlock the door\n2. Leave the door and continue exploring");
                if (choice == 1) {
                    displayStory("You use the key to unlock the door. Beyond it, you discover the long-lost treasure! Congratulations, you've succeeded!");
                    player.addToInventory("Long-Lost Treasure");
                    currentDecision = 6;
                } else {
                    displayStory("You decide to leave the locked door and continue exploring. Unfortunately, you get lost in the cave.");
                    currentDecision = 7;
                }
                break;
            case 5:
                displayStory("You are at the locked door. What will you do?\n1. Use the mysterious key on the door\n2. Leave the door and explore more");
                if (choice == 1) {
                    displayStory("You use the mysterious key to unlock the door. Beyond it, you discover the long-lost treasure! Congratulations, you've succeeded!");
                    player.addToInventory("Long-Lost Treasure");
                    currentDecision = 6;
                } else {
                    displayStory("You decide to leave the locked door and continue exploring. Unfortunately, you get lost in the cave.");
                    currentDecision = 7;
                }
                break;
            case 6:
                displayStory("Congratulations, you've successfully found the treasure and completed your adventure!");
                displayStory("You are now carrying the following items: " + player.getInventory());
                choiceButton1.setEnabled(false);
                choiceButton2.setEnabled(false);
                break;
            case 7:
                displayStory("You're lost in the cave with no way out. The adventure has come to a sad end.");
                displayStory("You are carrying the following items: " + player.getInventory());
                choiceButton1.setEnabled(false);
                choiceButton2.setEnabled(false);
                break;
        }
    }
}

class Player {
    private String name;
    private boolean gameOver = false;
    private StringBuilder inventory;

    public Player() {
        inventory = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getInventory() {
        return inventory.toString();
    }

    public void addToInventory(String item) {
        inventory.append(item).append(", ");
    }
}
