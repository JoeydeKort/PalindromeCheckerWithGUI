package com.joey.de.kort.models;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

import static com.joey.de.kort.utils.Messages.*;

public class Palindrome implements ActionListener {

    JFrame frame;
    JTextField textFieldEnterAWord = new JTextField(ENTER_A_NUMBER_OR_WORD.getMessage());
    JTextField textFieldAnswer = new JTextField(20);
    JButton buttonToSubmit = new JButton("Submit");

    public Palindrome() {
        prepareGUI();
        addComponent();
    }

    // SET(PROPERTIES_WINDOW)
    public void prepareGUI() {
        frame = new JFrame("Palindrome checker!");
        frame.setSize(500, 400);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MAKES_THE_BUTTON_RESPOND_TO_THE_ENTER_KEY
        frame.getRootPane().setDefaultButton(buttonToSubmit);

    }

    public void addComponent() {

        // SET(PROPERTIES_TEXT_FIELD_INPUT)

        // SET(CLICK_TEXT_EMPTY_TEXT_BOX)
        textFieldEnterAWord.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFieldEnterAWord.setText("");
            }
        });

        textFieldEnterAWord.setBounds(100, 40, 300, 40);
        textFieldEnterAWord.setFont(new Font("Arial", Font.BOLD, 15));
        textFieldEnterAWord.setEditable(true);
        textFieldEnterAWord.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(textFieldEnterAWord);

        // SET(PROPERTIES_TEXT_FIELD_ANSWER)
        textFieldAnswer.setBounds(100, 240, 300, 40);
        textFieldAnswer.setFont(new Font("Arial", Font.BOLD, 15));
        textFieldAnswer.setEditable(false);
        textFieldAnswer.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(textFieldAnswer);

        // SET(PROPERTIES_BUTTON)
        buttonToSubmit.setBounds(175, 140, 150, 40);
        buttonToSubmit.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(buttonToSubmit);
        buttonToSubmit.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String input = e.getActionCommand();

        if (input.equals("Submit")) {

            String word = textFieldEnterAWord.getText();
            textFieldEnterAWord.setText("");

            StringBuilder reverseStr = new StringBuilder();
            int strLength = word.length();
            boolean condition = strLength == 0;

            // IF(WORD_IS_EMPTY)
            if (condition) {
                textFieldAnswer.setText(ERROR_MESSAGE_NO_INPUT.getMessage());
            }

            // ELSE (WITH_AN_INPUT)
            else {

                // COMPARE_INPUT
                for (int counter = (strLength - 1); counter >= 0; --counter) {
                    reverseStr.append(word.charAt(counter));
                }

                // PRINT -> CORRECT_MESSAGE
                if (word.equalsIgnoreCase(reverseStr.toString())) {
                    textFieldAnswer.setText(SUCCESS_MESSAGE.getMessage());
                }
                // PRINT -> INCORRECT_MESSAGE
                else {
                    textFieldAnswer.setText(FAIL_MESSAGE.getMessage());
                }

            }

        }

    }

}

