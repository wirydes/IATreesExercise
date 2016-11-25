/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
/**
 *
 * @author luisj
 */
public class ScrollBar extends BasicScrollBarUI  {

    public ScrollBar() {
       
    }
    
    
     @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(new Color(247,247,247));
        if (this.trackHighlight == BasicScrollBarUI.DECREASE_HIGHLIGHT) {
            this.paintDecreaseHighlight(g);
        } else if (this.trackHighlight == BasicScrollBarUI.INCREASE_HIGHLIGHT) {
            this.paintIncreaseHighlight(g);
        }
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        int w = thumbBounds.width;
        int h = thumbBounds.height;
        if (thumbBounds.isEmpty() || !this.scrollbar.isEnabled()) {
            return;
        }
        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor(new Color(217,217,217));
        g.drawRect( 0, 2, w - 1, h - 5);
        g.setColor(new Color(217,217,217));
        g.fillRect(0, 2, w - 1, h - 5);
        g.setColor(new Color(217,217,217));
        g.setColor(new Color(217,217,217));
        g.translate(-thumbBounds.x, -thumbBounds.y);
    }
    @Override
    protected JButton createIncreaseButton(int orientation)  {
        return new BasicArrowButton(orientation,
                                    UIManager.getColor(new Color(237,237,237)),
                                    UIManager.getColor(new Color(237,237,237)),
                                    UIManager.getColor(new Color(237,237,237)),
                                    UIManager.getColor(new Color(237,237,237)));
    }
    @Override
    protected JButton createDecreaseButton(int orientation)  {
        return new BasicArrowButton(orientation,
                                    UIManager.getColor(new Color(237,237,237)),
                                    UIManager.getColor(new Color(237,237,237)),
                                    UIManager.getColor(new Color(237,237,237)),
                                    UIManager.getColor(new Color(237,237,237)));
    }
}
