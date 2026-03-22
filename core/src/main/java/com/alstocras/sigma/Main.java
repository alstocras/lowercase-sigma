package com.alstocras.sigma;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;
import java.util.*;

/** {@link ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private ShapeRenderer shape;
    public static OrthographicCamera camera;
    private GTypeStar starterStar;
    private float hexRadius;

    @Override
    public void create() {
        hexRadius = 40;
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        shape = new ShapeRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean scrolled(float amountX, float amountY){
                camera.zoom = (float)Math.max(camera.zoom + amountY * 0.2f, 0.2);
                return true;
            }

            @Override
            public boolean touchDragged(int x, int y, int pointer) {
                if(Gdx.input.isButtonPressed(Buttons.MIDDLE)){
                    camera.translate(-Gdx.input.getDeltaX() * 2, Gdx.input.getDeltaY() * 5);
                }
                return true;
            }
        });
        starterStar = new GTypeStar(1e8, 1e8);
    }

    @Override
    public void render() {
        camera.update();
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        HexGridGenerator.makeHexGrid(100, 100, hexRadius, camera);
        starterStar.create(0, 0, shape, hexRadius);
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        shape.dispose();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }


}
