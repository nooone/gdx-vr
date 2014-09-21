/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.vr;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * @author Daniel Holderbaum
 */
public class Stage3D extends Stage {

	private final Plane plane;

	// private final Vector2 offsetOnPlane;

	public Stage3D() {
		super();
		this.plane = new Plane(new Vector3(0, 0, 1), Vector3.Zero);
	}

	public Stage3D(Viewport viewport) {
		super(viewport);
		this.plane = new Plane(new Vector3(0, 0, 1), Vector3.Zero);
	}

	public Stage3D(Viewport viewport, SpriteBatch batch) {
		super(viewport, batch);
		this.plane = new Plane(new Vector3(0, 0, 1), Vector3.Zero);
	}

	public Stage3D(Plane plane, Viewport viewport, SpriteBatch batch) {
		super(viewport, batch);
		this.plane = plane;
	}

	private static final Vector3 tmp = new Vector3();

	@Override
	public Vector2 screenToStageCoordinates(Vector2 screenCoords) {
		Ray pickRay = getViewport().getPickRay(screenCoords.x, screenCoords.y);
		Vector3 intersection = tmp;
		if (Intersector.intersectRayPlane(pickRay, plane, intersection)) {
			screenCoords.x = intersection.x;
			screenCoords.y = intersection.y;
		} else {
			screenCoords.x = Float.MAX_VALUE;
			screenCoords.y = Float.MAX_VALUE;
		}
		return screenCoords;
	}

	@Override
	public void calculateScissors(Rectangle localRect, Rectangle scissorRect) {
		super.calculateScissors(localRect, scissorRect);
		scissorRect.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
	}

	private static final Matrix4 transform = new Matrix4();

	@Override
	public void draw() {
		transform.idt();
		transform.setToLookAt(plane.normal, Vector3.Z);
		// TODO: no cpy()
		transform.translate(plane.normal.cpy().nor().scl(plane.d));

		getBatch().setTransformMatrix(transform);

		super.draw();
	}

}
