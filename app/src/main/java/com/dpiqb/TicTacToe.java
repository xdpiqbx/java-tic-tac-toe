package com.dpiqb;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class TicTacToe implements ActionListener{
  Random random = new Random();
  JFrame jFrame = new JFrame();
  JPanel titlePanel = new JPanel();
  JPanel buttonPanel = new JPanel();
  JLabel textField = new JLabel();
  JButton[] buttons = new JButton[9];
  boolean player1_turn;
  public TicTacToe() {
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(800, 800);
    jFrame.getContentPane().setBackground(new Color(50,50,50));
    jFrame.setLayout(new BorderLayout());
    jFrame.setVisible(true);

    textField.setBackground(new Color(25,25,25));
    textField.setForeground(new Color(25, 255, 0));
    textField.setFont(new Font("Ink Free", Font.BOLD, 75));
    textField.setHorizontalAlignment(JLabel.CENTER);
    textField.setText("Tic-Tac-Toe");
    textField.setOpaque(true);

    titlePanel.setLayout(new BorderLayout());
    titlePanel.setBounds(0,0,800,100);

    buttonPanel.setLayout(new GridLayout(3,3));
    buttonPanel.setBackground(new Color(150, 150, 150));

    for (int i = 0; i < 9; i++) {
      buttons[i] = new JButton();
      buttonPanel.add(buttons[i]);
      buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
      buttons[i].setFocusable(false);
      buttons[i].addActionListener(this);
    }

    titlePanel.add(textField);
    jFrame.add(titlePanel, BorderLayout.NORTH);
    jFrame.add(buttonPanel);

    firstTurn();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 9; i++) {
      if(e.getSource() == buttons[i]){
        if(player1_turn){
          if(buttons[i].getText().isEmpty()){
            buttons[i].setForeground(new Color(0, 0, 250));
            buttons[i].setText("X");
            player1_turn = false;
            textField.setText("O turn");
            check();
          }
        }else{
          if(buttons[i].getText().isEmpty()) {
            buttons[i].setForeground(new Color(255, 0, 0));
            buttons[i].setText("O");
            player1_turn = true;
            textField.setText("X turn");
            check();
          }
        }
      }
    }
  }
  public void firstTurn(){
    for (JButton button : buttons) {
      button.setEnabled(false);
    }
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    for (JButton button : buttons) {
      button.setEnabled(true);
    }
    boolean turn = random.nextBoolean();
    if (turn){
      textField.setText("X turn");
    }else{
      textField.setText("O turn");
    }
    player1_turn = turn;
  }
  public void check(){
    boolean comb1 = !buttons[0].getText().isEmpty() && buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText());
    boolean comb2 = !buttons[3].getText().isEmpty() && buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText());
    boolean comb3 = !buttons[6].getText().isEmpty() && buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText());

    boolean comb4 = !buttons[0].getText().isEmpty() && buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText());
    boolean comb5 = !buttons[1].getText().isEmpty() && buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText());
    boolean comb6 = !buttons[2].getText().isEmpty() && buttons[2].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[8].getText());

    boolean comb7 = !buttons[0].getText().isEmpty() && buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText());
    boolean comb8 = !buttons[2].getText().isEmpty() && buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[6].getText());

    if(comb1){
      if(buttons[0].getText().equals("X")){
        xWins(0, 1,2);
      }else{
        oWins(0, 1,2);
      }
    }else if(comb2){
      if(buttons[3].getText().equals("X")){
        xWins(3, 4,5);
      }else{
        oWins(3, 4,5);
      }
    }else if(comb3){
      if(buttons[6].getText().equals("X")){
        xWins(6, 7,8);
      }else{
        oWins(6, 7,8);
      }
    }else if(comb4){
      if(buttons[0].getText().equals("X")){
        xWins(0, 3,6);
      }else{
        oWins(0, 3,6);
      }
    }else if(comb5){
      if(buttons[1].getText().equals("X")){
        xWins(1, 4,7);
      }else{
        oWins(1, 4,7);
      }
    }else if(comb6){
      if(buttons[2].getText().equals("X")){
        xWins(2, 5,8);
      }else{
        oWins(2, 5,8);
      }
    }else if(comb7){
      if(buttons[0].getText().equals("X")){
        xWins(0, 4,8);
      }else{
        oWins(0, 4,8);
      }
    }else if(comb8){
      if(buttons[2].getText().equals("X")){
        xWins(2, 4,6);
      }else{
        oWins(2, 4,6);
      }
    }
  }
  public void xWins(int a, int b, int c){
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);
    for (JButton button : buttons) {
      button.setEnabled(false);
    }
    textField.setText("X wins");
  }
  public void oWins(int a, int b, int c){
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);
    for (JButton button : buttons) {
      button.setEnabled(false);
    }
    textField.setText("O wins");
  }
}
