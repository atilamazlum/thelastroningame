import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class StyledButton extends JButton {
    private Color normalBg = new Color(30, 30, 30);
    private Color hoverBg = new Color(60, 50, 50);
    private Color pressedBg = new Color(139, 69, 19);
    private Color borderColor = new Color(139, 115, 85);
    private Color textColor = new Color(220, 200, 170);
    private boolean hovering = false;
    private boolean pressing = false;
    private float alpha = 1.0f;

    public StyledButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(textColor);
        setFont(new Font("Serif", Font.BOLD, 18));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                pressing = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressing = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressing = false;
                repaint();
            }
        });
    }

    public void setAlpha(float a) {
        this.alpha = a;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        int w = getWidth();
        int h = getHeight();
        int arc = 12;

        // Background
        Color bg = pressing ? pressedBg : (hovering ? hoverBg : normalBg);
        g2.setColor(bg);
        g2.fill(new RoundRectangle2D.Float(1, 1, w - 2, h - 2, arc, arc));

        // Border
        g2.setColor(hovering ? new Color(200, 170, 120) : borderColor);
        g2.setStroke(new BasicStroke(hovering ? 2f : 1.5f));
        g2.draw(new RoundRectangle2D.Float(1, 1, w - 3, h - 3, arc, arc));

        // Text
        g2.setFont(getFont());
        g2.setColor(hovering ? Color.WHITE : textColor);
        FontMetrics fm = g2.getFontMetrics();
        String text = getText();
        if (text != null && !text.isEmpty()) {
            int textX = (w - fm.stringWidth(text)) / 2;
            int textY = (h - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(text, textX, textY);
        }

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(280, 45);
    }
}
