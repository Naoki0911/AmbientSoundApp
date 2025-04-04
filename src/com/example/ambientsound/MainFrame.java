package com.example.ambientsound;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

  public MainFrame() {
    super("Ambient Sound App");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setLayout(new BorderLayout());

    List<ChillSound> soundList = new ArrayList<>();
    soundList.add(new ChillSound("sounds/rain.wav", "雨"));
    soundList.add(new ChillSound("sounds/wave.wav", "波"));
    soundList.add(new ChillSound("sounds/sewer.wav", "下水道"));
    soundList.add(new ChillSound("sounds/midnighttown.wav", "夜の繁華街"));
    soundList.add(new ChillSound("sounds/black-taledgull.wav", "ウミネコ"));
    soundList.add(new ChillSound("sounds/cicada.wav", "ミンミンゼミ"));
    soundList.add(new ChillSound("sounds/eveningcicada.wav", "ヒグラシ"));
    soundList.add(new ChillSound("sounds/Meimunaopalifera.wav", "ツクツクボウシ"));
    soundList.add(new ChillSound("sounds/sparrow.wav", "ツバメ"));
    soundList.add(new ChillSound("sounds/crow.wav", "カラス"));
    soundList.add(new ChillSound("sounds/windbell.wav", "風鈴"));
    

        // パネルの作成
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    // soundList の各要素に対して UI を動的に生成する
    for (ChillSound sound : soundList) {
        // 個別のパネルを作成（タイトル付きの枠で音源名を表示）
        JPanel soundPanel = new JPanel(new BorderLayout());
        soundPanel.setBorder(BorderFactory.createTitledBorder(sound.getName()));

        // 再生・停止ボタンのパネルを作成
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton playButton = new JButton("Play " + sound.getName());
        playButton.addActionListener(e -> sound.play());
        JButton stopButton = new JButton("Stop " + sound.getName());
        stopButton.addActionListener(e -> sound.stop());
        buttonPanel.add(playButton);
        buttonPanel.add(stopButton);

        // 音量調整用スライダーを作成
        JSlider volumeSlider = new JSlider(0, 100, (int) (sound.getVolume() * 100));
        volumeSlider.setMajorTickSpacing(20);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.addChangeListener(e -> {
            int value = volumeSlider.getValue();
            sound.setVolume(value / 100.0f);
        });

        // soundPanel にボタンパネルとスライダーを配置
        soundPanel.add(buttonPanel, BorderLayout.NORTH);
        soundPanel.add(volumeSlider, BorderLayout.CENTER);

        // メインパネルに追加
        mainPanel.add(soundPanel);
    }

    // 音源が多い場合のため、スクロール可能なパネルとして追加
    JScrollPane scrollPane = new JScrollPane(mainPanel);
    add(scrollPane, BorderLayout.CENTER);
  }
}