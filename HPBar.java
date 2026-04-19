import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class HPBar extends JPanel {
    private int currentHp;
    private int maxHp;

    public HPBar(int maxHp) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        setOpaque(false);
        setPreferredSize(new Dimension(150, 22));
    }

    public void setHp(int hp) {
        this.currentHp = Math.max(0, hp);
        repaint();
    }

    public void setMaxHp(int max) {
        this.maxHp = max;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth() - 4;
        int h = getHeight() - 4;
        int x = 2, y = 2;
        int arc = 10;

        // Background
        g2.setColor(new Color(40, 10, 10));
        g2.fill(new RoundRectangle2D.Float(x, y, w, h, arc, arc));

        // Fill
        float ratio = Math.min(1f, (float) currentHp / maxHp);
        int fillW = (int) (w * ratio);

        Color hpColor;
        if (ratio > 0.6f) hpColor = new Color(50, 160, 50);
        else if (ratio > 0.3f) hpColor = new Color(200, 160, 30);
        else hpColor = new Color(180, 30, 30);

        if (fillW > 0) {
            GradientPaint gp = new GradientPaint(x, y, hpColor.brighter(), x, y + h, hpColor.darker());
            g2.setPaint(gp);
            g2.fill(new RoundRectangle2D.Float(x, y, fillW, h, arc, arc));
        }

        // Border
        g2.setColor(new Color(100, 80, 60));
        g2.setStroke(new BasicStroke(1.5f));
        g2.draw(new RoundRectangle2D.Float(x, y, w, h, arc, arc));

        // Text
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Serif", Font.BOLD, 12));
        String text = currentHp + " / " + maxHp;
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(text, (getWidth() - fm.stringWidth(text)) / 2,
                (getHeight() + fm.getAscent() - fm.getDescent()) / 2);

        g2.dispose();
    }
}
