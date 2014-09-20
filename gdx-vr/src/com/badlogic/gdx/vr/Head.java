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

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Head {

	/**
	 * In meters. In reality it can range from 54mm to 72mm with 64mm being the
	 * average (thus the default value).
	 * 
	 * Sets the interpupillary distance to use.
	 * 
	 * The provided distance will be used to compute the matrix returned by
	 * EyeTransform.getEyeView(). Changes will be effective from the first frame
	 * after this call.
	 */
	private float interpupillaryDistance = 0.064f;

	/**
	 * In meters. The average eye-height of a human being is about 1.61m (thus
	 * the default value). If one wants to model a realistic environment and
	 * uses real-world scales, this has to be adjusted to fit the player.
	 * Otherwise he will feel smaller or bigger in-game, compared to real life.
	 */
	private float eyeHeight = 1.61f;

	private Vector3 position = new Vector3();

	private Quaternion orientation = new Quaternion();

	private Viewport leftEye = new ScreenViewport(new PerspectiveCamera());

	private Viewport rightEye = new ScreenViewport(new PerspectiveCamera());

	private Viewport cyclopsEye = new ScreenViewport(new PerspectiveCamera());

	private boolean cyclops;

	public Viewport getCyclopsEye() {
		return cyclopsEye;
	}

	public void setCyclopsEye(Viewport cyclopsEye) {
		this.cyclopsEye = cyclopsEye;
	}

	public boolean isCyclops() {
		return cyclops;
	}

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
	public void setCyclops(boolean cyclops) {
		this.cyclops = cyclops;
	}

	public float getInterpupillaryDistance() {
		return interpupillaryDistance;
	}

	public void setInterpupillaryDistance(float interpupillaryDistance) {
		this.interpupillaryDistance = interpupillaryDistance;
	}

	public float getEyeHeight() {
		return eyeHeight;
	}

	public void setEyeHeight(float eyeHeight) {
		this.eyeHeight = eyeHeight;
	}

	public Vector3 getPosition() {
		return position;
	}

	public void setPosition(Vector3 position) {
		this.position = position;
	}

	public Quaternion getOrientation() {
		return orientation;
	}

	public void setOrientation(Quaternion orientation) {
		this.orientation = orientation;
	}

	public Viewport getLeftEye() {
		return leftEye;
	}

	public void setLeftEye(Viewport leftEye) {
		this.leftEye = leftEye;
	}

	public Viewport getRightEye() {
		return rightEye;
	}

	public void setRightEye(Viewport rightEye) {
		this.rightEye = rightEye;
	}

	public void resetHeadPose() {

	}

}
