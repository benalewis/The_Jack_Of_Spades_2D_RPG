package com.company.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Ben on 20/11/2016.
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage player, water, grass;

    //Load
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        player = sheet.crop(width*2,0, width, height);
        water = sheet.crop(width,0, width, height);
        grass = sheet.crop(0,0, width, height);
    }
}
