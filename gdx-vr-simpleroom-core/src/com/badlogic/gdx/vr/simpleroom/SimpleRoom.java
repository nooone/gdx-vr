package com.badlogic.gdx.vr.simpleroom;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class SimpleRoom extends ApplicationAdapter {

	private ModelBatch modelBatch;
	private PerspectiveCamera camera;
	private ModelInstance modelInstance;
	private AssetManager assets;
	private CameraInputController cameraController;

	@Override
	public void create() {
		assets = new AssetManager();
		assets.load("BrickHouse.g3db", Model.class);
		assets.finishLoading();
		modelInstance = new ModelInstance(assets.get("BrickHouse.g3db", Model.class));
		modelBatch = new ModelBatch();
		camera = new PerspectiveCamera();
		cameraController = new CameraInputController(camera);
		Gdx.input.setInputProcessor(cameraController);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cameraController.update();
		camera.update(true);

		modelBatch.begin(camera);
		modelBatch.render(modelInstance);
		modelBatch.end();
	}
}
