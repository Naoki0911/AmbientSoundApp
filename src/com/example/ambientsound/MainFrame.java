package com.example.ambientsound;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
  private Sound rainSound;

  public MainFrame() {
    super("Ambient Sound App");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setLayout(new BorderLayout());

        // RainSoundオブジェクトの生成（音源ファイルのパスを指定）
        // プロジェクトのルートディレクトリに「sounds」フォルダを作成し、その中にrain.wavを配置する想定です。
    rainSound = new RainSound("sounds/rain.wav");

        // パネルの作成
    JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        // 再生・停止ボタンを配置
    JButton playButton = new JButton("Play Rain");
    playButton.addActionListener(e -> rainSound.play());
    JButton stopButton = new JButton("Stop Rain");
    stopButton.addActionListener(e -> rainSound.stop());
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(playButton);
        buttonPanel.add(stopButton);

        // 音量調整用のスライダー（0～100の値）
    JSlider volumeSlider = new JSlider(0, 100, (int)(rainSound.getVolume() * 100));
    volumeSlider.setMajorTickSpacing(20);
    volumeSlider.setPaintTicks(true);
    volumeSlider.setPaintLabels(true);
    volumeSlider.addChangeListener(e -> {
      int value = volumeSlider.getValue();
      rainSound.setVolume(value / 100.0f);
    });

    panel.add(buttonPanel);
    panel.add(volumeSlider);

    add(panel, BorderLayout.CENTER);
  }
}
