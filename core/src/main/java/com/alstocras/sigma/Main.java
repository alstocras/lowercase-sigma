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
        hexRadius = 100;
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        shape = new ShapeRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean scrolled(float amountX, float amountY){
                Vector3 mouseCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                Vector3 unprojectedCoords = camera.unproject(mouseCoords);
                Vector2 vector2UnprojectedCoords = new Vector2(unprojectedCoords.x, unprojectedCoords.y);
                camera.zoom = (float)Math.max(camera.zoom + amountY * 0.2f, 0.2);
                camera.update();
                Vector3 zoomedMouseCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                Vector3 zoomedUnprojectedCoords = camera.unproject(zoomedMouseCoords);
                Vector2 vector2ZoomedUnprojectedCoords = new Vector2(zoomedUnprojectedCoords.x, zoomedUnprojectedCoords.y);
                camera.translate(new Vector2(-vector2ZoomedUnprojectedCoords.x + vector2UnprojectedCoords.x, -vector2ZoomedUnprojectedCoords.y + vector2UnprojectedCoords.y));
                return true;
            }

            @Override
            public boolean touchDragged(int x, int y, int pointer) {
                if(Gdx.input.isButtonPressed(Buttons.MIDDLE)){
                    camera.translate(-Gdx.input.getDeltaX() * 2, Gdx.input.getDeltaY() * 2);
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
