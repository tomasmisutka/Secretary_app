package Components.Panels;

import javax.swing.*;
import java.awt.*;

public class CommonRoundedPanel extends JPanel
{
    private int cornerRadius = 15;
    private Color backgroundColor;

    public CommonRoundedPanel() {}

    public CommonRoundedPanel(int radius)
    {
        super();
        this.cornerRadius = radius;
    }

    public CommonRoundedPanel(Color background, int radius)
    {
        super();
        this.backgroundColor = background;
        this.cornerRadius = radius;
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Dimension arcs = new Dimension(this.cornerRadius, this.cornerRadius);
        int width = this.getWidth();
        int height = this.getHeight();
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //draws the rounded panel with borders
        if (this.backgroundColor == null)
            graphics2D.setColor(this.getBackground());

        graphics2D.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //draws a border
        graphics2D.setColor(this.backgroundColor);
        graphics2D.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //draws a background color
    }

    public void setCornerRadius(int cornerRadius)
    {
        this.cornerRadius = cornerRadius;
    }

    public void setBackgroundColor(Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }
}
