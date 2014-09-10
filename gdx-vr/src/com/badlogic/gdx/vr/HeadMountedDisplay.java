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
public interface HeadMountedDisplay {

	/** Returns the lens distortion model. */
	Distortion getDistortion();

	/** Returns the eye to lens distance in meters. */
	float getEyeToLensDistance();

	/** Returns the interpupillary distance for the device. */
	float getInterpupillaryDistance();

	/** Returns the lens diameter. */
	float getLensDiameter();

	/** Returns the device model string. */
	String getModel();

	// /** Returns the NFC tag contents from there these parameters were
	// extracted. */
	// NdefMessage getNfcTagContents();

	/** Returns the screen to lens distance. */
	float getScreenToLensDistance();

	/** Returns the device vendor string. */
	String getVendor();

	/** Returns the device version string. */
	String getVersion();

	/** Returns the vertical distance to the lens center. */
	float getVerticalDistanceToLensCenter();

}
