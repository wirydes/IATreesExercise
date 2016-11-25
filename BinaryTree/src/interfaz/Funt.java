/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisj
 */
public class Funt  {
        public Font oswaldRegular,oswaldLight,oswaldBlanca,latoLight,latoRegular;
        float size=20f;

   

    public float setSize(float size) {
        this.size = size;
        return size;
    }
    public Funt() {
        try {
          ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
          InputStream oLight= classLoader.getResourceAsStream("gfa.ttf");
          InputStream oBlanca= classLoader.getResourceAsStream("gfa.ttf");
          InputStream oRegular = classLoader.getResourceAsStream("Oswald-Regular.ttf");
          InputStream lLight = classLoader.getResourceAsStream("Lato-Light.ttf");
          InputStream lRegular = classLoader.getResourceAsStream("Lato-Regular.ttf");
          GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
          
            oswaldRegular = Font.createFont(Font.TRUETYPE_FONT, oRegular).deriveFont(20f);
            oswaldLight = Font.createFont(Font.TRUETYPE_FONT, oLight).deriveFont(size);
            oswaldBlanca = Font.createFont(Font.TRUETYPE_FONT, oBlanca).deriveFont(30f);
            latoLight = Font.createFont(Font.TRUETYPE_FONT, lLight);
            latoRegular = Font.createFont(Font.TRUETYPE_FONT,lRegular);
            ge.registerFont(oswaldRegular);
            ge.registerFont(latoLight);
            ge.registerFont(latoRegular);
        } catch (FileNotFoundException ex) {
            
        } catch (FontFormatException ex) {
            
        } catch (IOException ex) {
            
        }
    }
    
}
