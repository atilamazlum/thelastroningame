import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Color topColor = new Color(10, 5, 15);
    private Color bottomColor = new Color(30, 15, 10);
    private Color targetTop = topColor;
    private Color targetBottom = bottomColor;
    private Timer transitionTimer;
    private float transitionProgress = 1f;

    // Preset themes
    public static final int THEME_DARK = 0;      // default dark
    public static final int THEME_FOREST = 1;     // greenish
    public static final int THEME_TOWN = 2;       // warm brown
    public static final int THEME_BATTLE = 3;     // red tint
    public static final int THEME_CASTLE = 4;     // cold blue/gray
    public static final int THEME_BAR = 5;        // warm amber
    public static final int THEME_CEMETERY = 6;   // eerie green

    public BackgroundPanel() {
        setLayout(new BorderLayout());
    }

    public void setTheme(int theme) {
        Color newTop, newBottom;
        switch (theme) {
            case THEME_FOREST:
                newTop = new Color(5, 20, 10);
                newBottom = new Color(15, 40, 20);
                break;
            case THEME_TOWN:
                newTop = new Color(25, 15, 10);
                newBottom = new Color(50, 30, 15);
                break;
            case THEME_BATTLE:
                newTop = new Color(30, 5, 5);
                newBottom = new Color(50, 10, 10);
                break;
            case THEME_CASTLE:
                newTop = new Color(10, 10, 25);
                newBottom = new Color(20, 20, 40);
                break;
            case THEME_BAR:
                newTop = new Color(30, 20, 5);
                newBottom = new Color(50, 35, 10);
                break;
            case THEME_CEMETERY:
                newTop = new Color(5, 15, 10);
                newBottom = new Color(10, 25, 15);
                break;
            default:
                newTop = new Color(10, 5, 15);
                newBottom = new Color(30, 15, 10);
                break;
        }
        animateTransition(newTop, newBottom);
    }

    private void animateTransition(Color newTop, Color newBottom) {
        if (transitionTimer != null && transitionTimer.isRunning()) {
            transitionTimer.stop();
            topColor = targetTop;
            bottomColor = targetBottom;
        }
        targetTop = newTop;
        targetBottom = newBottom;
        transitionProgress = 0f;

        final Color startTop = topColor;
        final Color startBottom = bottomColor;

        transitionTimer = new Timer(30, e -> {
            transitionProgress += 0.05f;
            if (transitionProgress >= 1f) {
                transitionProgress = 1f;
                ((Timer) e.getSource()).stop();
            }
            topColor = blendColor(startTop, targetTop, transitionProgress);
            bottomColor = blendColor(startBottom, targetBottom, transitionProgress);
            repaint();
        });
        transitionTimer.start();
    }

    private Color blendColor(Color a, Color b, float t) {
        int r = (int) (a.getRed() + (b.getRed() - a.getRed()) * t);
        int g = (int) (a.getGreen() + (b.getGreen() - a.getGreen()) * t);
        int bl = (int) (a.getBlue() + (b.getBlue() - a.getBlue()) * t);
        return new Color(Math.max(0, Math.min(255, r)),
                         Math.max(0, Math.min(255, g)),
                         Math.max(0, Math.min(255, bl)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int w = getWidth();
        int h = getHeight();

        // Main gradient
        GradientPaint gp = new GradientPaint(0, 0, topColor, 0, h, bottomColor);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);

        // Subtle vignette effect
        RadialGradientPaint vignette = new RadialGradientPaint(
                new java.awt.geom.Point2D.Float(w / 2f, h / 2f),
                Math.max(w, h) * 0.7f,
                new float[]{0f, 0.7f, 1f},
                new Color[]{
                        new Color(0, 0, 0, 0),
                        new Color(0, 0, 0, 30),
                        new Color(0, 0, 0, 120)
                }
        );
        g2.setPaint(vignette);
        g2.fillRect(0, 0, w, h);

        // Subtle noise-like texture with small dots
        g2.setColor(new Color(255, 255, 255, 3));
        java.util.Random rng = new java.util.Random(42); // fixed seed for consistency
        for (int i = 0; i < 200; i++) {
            int x = rng.nextInt(w);
            int y = rng.nextInt(h);
            g2.fillRect(x, y, 1, 1);
        }

        g2.dispose();
    }
}
