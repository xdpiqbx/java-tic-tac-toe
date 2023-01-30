package com.dpiqb;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
  public MainFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(800, 800);
    this.getContentPane().setBackground(new Color(50,50,50));
    this.setLayout(new BorderLayout());
    this.setVisible(true);
  }
}
