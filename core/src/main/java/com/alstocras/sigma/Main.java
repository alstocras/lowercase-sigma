package com.alstocras.sigma;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    Star testStar;

    @Override
    public void create() {
        batch = new SpriteBatch();
        testStar = new Star(1000, 400, Color.ORANGE, batch, 75, 10); // to see if it works
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        testStar.draw(400, 400);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
