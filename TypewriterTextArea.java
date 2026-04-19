import javax.swing.*;
import java.awt.*;

public class TypewriterTextArea extends JTextArea {
    private String fullText = "";
    private int charIndex = 0;
    private Timer timer;
    private int speed = 25; // ms per character

    public TypewriterTextArea() {
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(false);
        setForeground(new Color(220, 200, 170));
        setFont(new Font("Serif", Font.PLAIN, 17));
        setCaretColor(new Color(0, 0, 0, 0)); // invisible caret
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public void setTypewriterText(String text) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        fullText = text;
        charIndex = 0;
        setText("");

        timer = new Timer(speed, e -> {
            if (charIndex < fullText.length()) {
                // Add multiple chars per tick for speed
                int end = Math.min(charIndex + 2, fullText.length());
                setText(fullText.substring(0, end));
                charIndex = end;
                setCaretPosition(getText().length());
            } else {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }

    public void skipAnimation() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        setText(fullText);
    }

    public void setSpeed(int ms) {
        this.speed = ms;
    }
}
