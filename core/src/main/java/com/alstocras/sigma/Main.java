package com.alstocras.sigma;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.*;

import java.util.*;

/** {@link ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private ShapeRenderer shape;
    public static OrthographicCamera camera;
    public static float hexRadius;
    public static HashMap<AxialCoordinate, InterstellarObject> gridHashMap;
    private InfoPanel propertiesPanel;

    @Override
    public void create() {
        hexRadius = 100;
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        shape = new ShapeRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gridHashMap = new HashMap<>();
        GTypeStar starterStar = new GTypeStar(PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE, 6.96e8, new AxialCoordinate(0, 0));
        propertiesPanel = new InfoPanel(new ScreenViewport());
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(InfoPanel.stage);
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean scrolled(float amountX, float amountY){ //zooming function
                Vector3 mouseCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0); // gets mouse coords
                Vector3 unprojectedCoords = camera.unproject(mouseCoords); // unprojects them into world space
                Vector2 vector2UnprojectedCoords = new Vector2(unprojectedCoords.x, unprojectedCoords.y);
                camera.zoom = (float)Math.max(camera.zoom + amountY * 0.2f, 0.2); // zoom in
                camera.update();
                Vector3 zoomedMouseCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0); // gets new mouse coords
                Vector3 zoomedUnprojectedCoords = camera.unproject(zoomedMouseCoords); // unprojects
                Vector2 vector2ZoomedUnprojectedCoords = new Vector2(zoomedUnprojectedCoords.x, zoomedUnprojectedCoords.y);
                camera.translate(new Vector2(-vector2ZoomedUnprojectedCoords.x + vector2UnprojectedCoords.x, -vector2ZoomedUnprojectedCoords.y + vector2UnprojectedCoords.y)); // gets difference to move cam
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
        Gdx.input.setInputProcessor(multiplexer);

    }

    @Override
    public void render(){
        camera.update();
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        HexGridGenerator.makeHexGrid(100, 100, hexRadius, camera);
        for(InterstellarObject obj : gridHashMap.values()){
            obj.draw(hexRadius, shape);
        }
        propertiesPanel.draw();
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
        propertiesPanel.stage.getViewport().update(width, height, true);
        HexGridGenerator.resize(width, height);
    }


}
