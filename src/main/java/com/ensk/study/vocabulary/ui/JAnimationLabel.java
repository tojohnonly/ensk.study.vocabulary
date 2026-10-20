package com.ensk.study.vocabulary.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class JAnimationLabel extends JLabel {
    private static final long serialVersionUID = 1L;

    private final Timer timer;
    private String animationText = "";
    private int animationTextIndex = 0;

    public JAnimationLabel() {
        this("", 20);
    }

    public JAnimationLabel(String text) {
        this(text, 20);
    }

    /**
     * 创建逐字动画标签，并仅在初始文本非空时启动该标签的定时器。
     * <p>
     *
     * @author Codex
     * @date 2026/10/20
     * @version 1.0.0
     * @param text 初始展示文本
     * @param delay 每个字符的展示间隔，单位为毫秒
     */
    public JAnimationLabel(String text, int delay) {
        this.animationText = (null != text) ? text : "";
        this.animationTextIndex = 0;
        timer = new Timer(delay, new ReboundListener());
        if (animationText.isEmpty()) {
            super.setText("<html><body></body></html>");
        } else {
            timer.start();
        }
    }

    private class ReboundListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            animateText();
            // repaint();
        }
    }

    /**
     * 设置逐字展示的文本，并根据文本内容启动或停止当前标签的动画。
     * <p>
     *
     * @author Codex
     * @date 2026/10/20
     * @version 1.0.0
     * @param text 要展示的文本
     */
    public void setAnimationText(String text) {
        if (null == text) {
            text = "";
        }
        if (null != animationText && animationText.equals(text)) {
            return;
        }
        super.setText("");
        this.animationText = text;
        this.animationTextIndex = 0;
        if (animationText.isEmpty()) {
            super.setText("<html><body></body></html>");
            timer.stop();
        } else if (!timer.isRunning()) {
            timer.start();
        }
    }

    /**
     * 推进当前标签的逐字动画，并在文本展示完成后停止定时器。
     * <p>
     *
     * @author Codex
     * @date 2026/10/20
     * @version 1.0.0
     */
    public void animateText() {
        if (animationTextIndex >= animationText.length()) {
            super.setText("<html><body>" + animationText + "</body></html>");
            timer.stop();
            return;
        }
        super.setText("<html><body>" + animationText.substring(0, ++animationTextIndex) + "</body></html>");
        if (animationTextIndex >= animationText.length()) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JAnimationLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JAnimationLabel("asdoflaslfdhasdldfhlA"));
        frame.setSize(300, 300);
        frame.setLocation(400, 400);
        frame.setVisible(true);
    }

}
