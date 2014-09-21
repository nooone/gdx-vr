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

/**
 * 
 * @author Daniel Holderbaum
 */
public class Head {

	private float interpupillaryDistance = 0.064f;
	private float eyeHeight = 1.61f;

	private Vector3 position = new Vector3();
	private Quaternion orientation = new Quaternion();

	private Vector3 positionOrigin = new Vector3();
	private Quaternion orientationOrigin = new Quaternion();

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
	 * Controls stereo rendering and distortion correction. Disabled by default.
	 * 
	 * If disabled, no interpupillary distance will be applied to the eye
	 * transformations and automatic distortion correction will not take place.
	 */
	public void setCyclops(boolean cyclops) {
		this.cyclops = cyclops;
	}

	/**
	 * Gets the interpupillary distance (in meters). By default it is 64mm (
	 * {@code 0.064f}).
	 * 
	 * @return The interpupillary distance in meters.
	 */
	public float getInterpupillaryDistance() {
		return interpupillaryDistance;
	}

	/**
	 * Sets the interpupillary distance to use (in meters). Each eye's position
	 * is offset by half of this value.
	 * 
	 * In reality it can range from 54mm to 72mm with 64mm being the average
	 * (thus the default value).
	 * 
	 * The provided distance will be used to compute the matrix returned by
	 * EyeTransform.getEyeView(). Changes will be effective from the first frame
	 * after this call.
	 * 
	 * @param interpupillaryDistance
	 *            The interpupillary distance (in meters).
	 */
	public void setInterpupillaryDistance(float interpupillaryDistance) {
		this.interpupillaryDistance = interpupillaryDistance;
	}

	/**
	 * Gets the eye height in meters. By default it is {@code 1.61f}. The head
	 * is offset by half of this value from the {@link Body#position}.
	 * 
	 * @return The eye height in meters.
	 */
	public float getEyeHeight() {
		return eyeHeight;
	}

	/**
	 * Sets the eye height in meters. The head is offset by half of this value
	 * from the {@link Body#position}.
	 * 
	 * The average eye-height of a human being is about 1.61m (thus the default
	 * value). If one wants to model a realistic environment and uses real-world
	 * scales, this has to be adjusted to fit the player. Otherwise he will feel
	 * smaller or bigger in-game, compared to real life.
	 * 
	 * @param eyeHeight
	 *            The eye height to be used (in meters).
	 */
	public void setEyeHeight(float eyeHeight) {
		this.eyeHeight = eyeHeight;
	}

	/**
	 * Returns the position of the head. It is the offset of the position from
	 * the last time {@link #resetHeadPose()} has been called. It should not be
	 * changed, because it is automatically set via head tracking of the head
	 * mounted display.
	 * 
	 * @return The position of the head.
	 */
	public Vector3 getPosition() {
		return position;
	}

	public Quaternion getOrientation() {
		return orientation;
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

	/**
	 * The current position and orientation will be used
	 */
	public void resetHeadPose() {
		positionOrigin.set(position);
		orientationOrigin.set(orientation);
	}

}
