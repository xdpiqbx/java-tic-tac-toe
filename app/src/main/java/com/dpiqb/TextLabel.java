package com.dpiqb;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel {
  public TextLabel(){
    this.setBackground(new Color(25,25,25));
    this.setForeground(new Color(25, 255, 0));
    this.setFont(new Font("Ink Free", Font.BOLD, 75));
    this.setHorizontalAlignment(JLabel.CENTER);
    this.setText("Tic-Tac-Toe");
    this.setOpaque(true);
  }
}
