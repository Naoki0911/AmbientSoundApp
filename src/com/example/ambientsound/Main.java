package com.example.ambientsound;

import javax.swing.SwingUtilities;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    });
  }
}

