package com.dpiqb;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{
  boolean player;
  MainFrame mainFrame;
  TextLabel textLabel;
  TitlePanel titlePanel;
  ButtonPanel buttonPanel;
  Random random;
  GameButton[] buttons = new GameButton[9];
  public TicTacToe() {
    mainFrame = new MainFrame();
    textLabel = new TextLabel();
    titlePanel = new TitlePanel();
    buttonPanel = new ButtonPanel();
    random = new Random();
  }
  public TicTacToe buildGame(){
    for (int i = 0; i < 9; i++) {
      buttons[i] = new GameButton();
      buttonPanel.add(buttons[i]);
      buttons[i].buttonProps(this);
    }
    titlePanel.add(textLabel);
    mainFrame.add(titlePanel, BorderLayout.NORTH);
    mainFrame.add(buttonPanel);
    return this;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 9; i++) {
      if(e.getSource() == buttons[i]){
        if(player){
          if(buttons[i].getText().isEmpty()){
            buttons[i].setForeground(new Color(0, 0, 250));
            buttons[i].setText("X");
            player = false;
            textLabel.setText("O turn");
            check();
          }
        }else{
          if(buttons[i].getText().isEmpty()) {
            buttons[i].setForeground(new Color(255, 0, 0));
            buttons[i].setText("O");
            player = true;
            textLabel.setText("X turn");
            check();
          }
        }
      }
    }
  }
  public TicTacToe start(){
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    for (JButton button : buttons) {
      button.setEnabled(true);
    }
    boolean turn = random.nextBoolean();
    textLabel.setText(turn ? "X turn" : "O turn");
    player = turn;
    return this;
  }
  public void check(){
    if(isWins(0,1,2)){
      whoWon(0,1,2);
    }else if(isWins(3,4,5)){
      whoWon(3,4,5);
    }else if(isWins(6,7,8)){
      whoWon(6,7,8);
    }else if(isWins(0,3,6)){
      whoWon(0,3,6);
    }else if(isWins(1,4,7)){
      whoWon(1,4,7);
    }else if(isWins(2,5,8)){
      whoWon(2,5,8);
    }else if(isWins(0,4,8)){
      whoWon(0,4,8);
    }else if(isWins(2,4,6)){
      whoWon(2,4,6);
    }
  }
  private void whoWon(int a, int b, int c){
    if(buttons[a].getText().equals("X")){
      xWins(a, b, c);
    }else{
      oWins(a, b, c);
    }
  }
  private boolean isWins(int a, int b, int c){
    return !buttons[a].getText().isEmpty()
      && buttons[a].getText().equals(buttons[b].getText())
      && buttons[b].getText().equals(buttons[c].getText());
  }
  public void xWins(int a, int b, int c){
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);
    for (JButton button : buttons) {
      button.setEnabled(false);
    }
    textLabel.setText("X wins");
  }
  public void oWins(int a, int b, int c){
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);
    for (JButton button : buttons) {
      button.setEnabled(false);
    }
    textLabel.setText("O wins");
  }
}
