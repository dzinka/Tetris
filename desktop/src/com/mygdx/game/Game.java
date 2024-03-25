package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
    private static boolean endOfGame;
    private SpriteBatch batch;
    private ArrayList<Figure> tetrisFiguresToDraw;
    private static final int SQUARE_SIZE = 40;
    ShapeRenderer shapeRenderer;

    OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        shapeRenderer = new ShapeRenderer();
        tetrisFiguresToDraw = new ArrayList<>();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        handleInput();

        if (! tetrisFiguresToDraw.isEmpty()){
            batch.begin();
            for (Figure figure : tetrisFiguresToDraw) {
                drawTetrisFigure(figure);
            }
            batch.end();
        }
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Figure figure = new Figure();
            tetrisFiguresToDraw.add(figure);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && !tetrisFiguresToDraw.isEmpty()) {
            int lastIndex = tetrisFiguresToDraw.size() - 1;
            tetrisFiguresToDraw.get(lastIndex).rotate();
        }
    }

    private void drawTetrisFigure(Figure figure) {
        int[][] form = figure.getForm().getForm();
        Color color = figure.getForm().getColor();
        Coord start = figure.getStart();

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);

        for (int i = 0; i < form.length; i++) {
            for (int j = 0; j < form[i].length; j++) {
                if (form[i][j] == 1) {
                    float x = start.getX() + j * SQUARE_SIZE;
                    float y = start.getY() + i * SQUARE_SIZE;
                    shapeRenderer.rect(x, y, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }

        shapeRenderer.end();
    }

    private int[][] rotateFigure(Figure figure){
        if (figure.getCurrentRotation() == RotationMode.NORMAL){
            if (figure.getForm() == FigureForm.S_FORM){
                return new int[][]{{1}, {1}, {1}, {1}};
            }
        }
        return figure.getForm().getForm();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}

