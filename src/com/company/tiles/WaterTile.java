package com.company.tiles;

import com.company.gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by Ben on 20/11/2016.
 */
public class WaterTile extends Tile {
    public WaterTile( int id) {
        super(Assets.water, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
