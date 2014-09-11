package com.badlogic.gdx.vr;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
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

	private Vector3 position;

	private Quaternion orientation;

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

	private Viewport leftEye;

	private Viewport rightEye;

	public void resetHeadPose() {

	}

}
