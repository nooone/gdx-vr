/* ######################################
 * Copyright 2014 (c) Pixel Scientists
 * All rights reserved.
 * Unauthorized copying of this file, via
 * any medium is strictly prohibited.
 * Proprietary and confidential.
 * ###################################### */
package com.badlogic.gdx.vr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * @author Daniel Holderbaum
 */
public class VirtualRealityRenderer {

	private Array<VirtualRealityRenderListener> listeners;

	private boolean vrMode, distortionCorrected;

	private FrameBuffer leftFBO, rightFBO;

	/**
	 * TODO: rename to cyclops-mode.
	 * 
	 * Enables or disables VR rendering mode.
	 * 
	 * Controls stereo rendering and distortion correction. Enabled by default.
	 * Changes will be effective from the first frame after this call.
	 * 
	 * If disabled, no interpupillary distance will be applied to the eye
	 * transformations and automatic distortion correction will not take place.
	 * Changes will be applied to the next frames being drawn.
	 * 
	 * See the documentation of the Renderer and StereoRenderer interfaces for
	 * details on how they are affected by VR mode.
	 */
	public void setVRMode(boolean enabled) {
		this.vrMode = enabled;

		// if (vrMode)
	}

	private void disposeFBOs() {
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

	public void render(float deltaTime) {
		for (VirtualRealityRenderListener listener : listeners) {
			listener.frameStarted();
		}

		// if (cyclops) {
		//
		// } else {
		renderEye(VirtualReality.head.getLeftEye());
		renderEye(VirtualReality.head.getRightEye());
		// }

		for (VirtualRealityRenderListener listener : listeners) {
			listener.frameEnded();
		}
	}

	public void resize(int screenWidth, int screenHeight) {
		// TODO: set up the FBOs
		// TODO: what happens in case the FBO size won't be PoT?
		FrameBuffer fbo = new FrameBuffer(Format.RGBA4444, screenWidth, screenHeight, false);
	}

	private void renderEye(Viewport eye) {
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		eye.update(screenWidth, screenHeight);

		for (VirtualRealityRenderListener listener : listeners) {
			listener.render(eye.getCamera());
		}
	}
}
