package com.company;

import java.awt.image.BufferedImage;

/**
 * Created by Ben on 20/11/2016.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x,y,width,height);
    }
}
