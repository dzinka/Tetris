package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
    private static boolean endOfGame;
    private SpriteBatch batch;
    private ArrayList<Figure> tetrisFiguresToDraw = new ArrayList<>();

    OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Figure figure = new Figure(new Coord(100, 100));
            tetrisFiguresToDraw.add(figure);
        }
    }

    private void drawTetrisFigure(Figure figure) {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}

