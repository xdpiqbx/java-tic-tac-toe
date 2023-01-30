package com.dpiqb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameButton extends JButton{
  public void buttonProps(ActionListener listener){
    this.setFont(new Font("MV Boli", Font.BOLD, 120));
    this.setFocusable(false);
    this.setEnabled(false);
    this.addActionListener(listener);
  }
}
