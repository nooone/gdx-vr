/* ######################################
 * Copyright 2014 (c) Pixel Scientists
 * All rights reserved.
 * Unauthorized copying of this file, via
 * any medium is strictly prohibited.
 * Proprietary and confidential.
 * ###################################### */
package com.badlogic.gdx.vr;

/**
 * Defines the physical parameters of a Cardboard-compatible device.
 * 
 * The model assumes the following for any Cardboard device:
 * 
 * <ul>
 * <li>Lenses are parallel to the screen of the inserted device.</li>
 * <li>The center of each lens is at the same height from the bottom of the
 * inserted device.</li>
 * <li>Lenses are symmetrically placed with respect to the center of the
 * inserted device screen.</li>
 * <li>The size of the area visible from the center of each lens is the same.</li>
 * </ul>
 * 
 * These parameters might be different for variations of different devices or
 * lenses. For simplicity, they can be stored in the NFC tag of the Cardboard.
 * 
 * @author Daniel Holderbaum
 */
public interface HeadMountedDisplay {

	/**
	 * Returns the lens distortion model.
	 * 
	 * @return The lens distortion model.
	 */
	Distortion getDistortion();

	/**
	 * Returns the eye to lens distance in meters. The distance is measured to
	 * the center of the lens, not its surface.
	 * 
	 * @return The eye to lens distance in meters.
	 */
	float getEyeToLensDistance();

	/**
	 * Returns the interpupillary distance for the device.
	 * 
	 * @return The interpupillary distance in meters.
	 */
	float getInterpupillaryDistance();

	/**
	 * Returns the lens diameter.
	 * 
	 * @return The lens diameter in meters.
	 */
	float getLensDiameter();

	/**
	 * Returns the device model string.
	 * 
	 * @return A string identifying the current device model.
	 */
	String getModel();

	// /** Returns the NFC tag contents from there these parameters were
	// extracted. */
	// NdefMessage getNfcTagContents();

	/**
	 * Returns the screen to lens distance.
	 * 
	 * @return The screen to lens distance in meters.
	 */
	float getScreenToLensDistance();

	/**
	 * Returns the device vendor string.
	 * 
	 * @return A string identifying the device vendor in reverse domain name
	 *         notation.
	 */
	String getVendor();

	/**
	 * Returns the device version string.
	 * 
	 * @return A string identifying the current device version.
	 */
	String getVersion();

	/**
	 * Returns the vertical distance to the lens center.
	 * 
	 * @return The vertical distance to the lens center from the bottom of the
	 *         inserted device, measured in meters.
	 */
	float getVerticalDistanceToLensCenter();

}
