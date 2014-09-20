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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * @author Daniel Holderbaum
 */
public class VirtualRealityRenderer {

	public Array<VirtualRealityRenderListener> listeners = new Array<VirtualRealityRenderListener>();

	private boolean distortionCorrected;

	private FrameBuffer leftFBO, rightFBO;

	public void dispose() {
		if (leftFBO != null) {
			leftFBO.dispose();
			leftFBO = null;
		}

		if (rightFBO != null) {
			rightFBO.dispose();
			rightFBO = null;
		}
	}

	/**
	 * Sets whether distortion correction is enabled.
	 * 
	 * Enabled by default. Changes will be effective from the first frame after
	 * this call.
	 */
	public void setDistortionCorrection(boolean enabled) {
		this.distortionCorrected = enabled;
	}

	public void render() {
		for (VirtualRealityRenderListener listener : listeners) {
			listener.frameStarted();
		}

		if (VirtualReality.head.isCyclops()) {
			renderEye(VirtualReality.head.getCyclopsEye(), new Vector3());
		} else {
			renderEye(VirtualReality.head.getLeftEye(), new Vector3());
			renderEye(VirtualReality.head.getRightEye(), new Vector3());
		}

		for (VirtualRealityRenderListener listener : listeners) {
			listener.frameEnded();
		}
	}

	public void resize(int screenWidth, int screenHeight) {
		// TODO: set up the FBOs
		// TODO: what happens in case the FBO size won't be PoT?
		FrameBuffer fbo = new FrameBuffer(Format.RGBA4444, screenWidth, screenHeight, false);
	}

	private void renderEye(Viewport eye, Vector3 eyeOffset) {
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		eye.update(screenWidth, screenHeight);

		Camera camera = eye.getCamera();

		Vector3 eyePosition = camera.position;
		eyePosition.set(VirtualReality.body.position);
		eyePosition.add(VirtualReality.body.headOffset);

		Quaternion eyeOrientation = new Quaternion();
		eyeOrientation.set(VirtualReality.head.getOrientation());
		eyeOrientation.mul(VirtualReality.body.rotation);

		eyeOffset.mul(eyeOrientation);
		eyePosition.add(eyeOffset);

		Vector3 eyeDirection = new Vector3(0, 0, -1);
		eyeDirection.mul(eyeOrientation);
		Vector3 eyeUp = new Vector3(0, 1, 0);
		eyeUp.mul(eyeOrientation);

		camera.position.set(eyePosition);
		camera.direction.set(eyeDirection);
		camera.up.set(eyeUp);

		camera.update(true);

		for (VirtualRealityRenderListener listener : listeners) {
			listener.render(camera);
		}
	}
}
