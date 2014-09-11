/* ######################################
 * Copyright 2014 (c) Pixel Scientists
 * All rights reserved.
 * Unauthorized copying of this file, via
 * any medium is strictly prohibited.
 * Proprietary and confidential.
 * ###################################### */
package com.badlogic.gdx.vr;

/**
 * @author Daniel Holderbaum
 */
public class VirtualRealityRenderer {

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

	}

	/**
	 * Sets whether distortion correction is enabled.
	 * 
	 * Enabled by default. Changes will be effective from the first frame after
	 * this call.
	 */
	public void setDistortionCorrectionEnabled(boolean enabled) {

	}
	
}
