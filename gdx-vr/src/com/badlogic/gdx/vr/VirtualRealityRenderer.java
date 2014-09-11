/* ######################################
 * Copyright 2014 (c) Pixel Scientists
 * All rights reserved.
 * Unauthorized copying of this file, via
 * any medium is strictly prohibited.
 * Proprietary and confidential.
 * ###################################### */
package com.badlogic.gdx.vr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * @author Daniel Holderbaum
 */
public class VirtualRealityRenderer {

	private Array<VirtualRealityRenderListener> listeners;

	private boolean vrMode, distortionCorrected;

	/**
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

		renderEye(VirtualReality.head.getLeftEye());
		renderEye(VirtualReality.head.getRightEye());

		for (VirtualRealityRenderListener listener : listeners) {
			listener.frameEnded();
		}
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
