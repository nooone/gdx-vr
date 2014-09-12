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

/**
 * @author Daniel Holderbaum
 */
public interface Distortion {

	/**
	 * Distorts a radius by its distortion factor from the center of the lenses.
	 * 
	 * @param radius
	 *            Radius from the lens center in meters.
	 * @return The distorted radius.
	 */
	float distort(float radius);

	/**
	 * Calculates the inverse distortion for a radius. Allows to compute the
	 * original undistorted radius from a distorted one.
	 * 
	 * @param radius
	 *            Distorted radius from the lens center in meters.
	 * @return The undistorted radius in meters.
	 */
	float distortInverse(float radius);

	/**
	 * Returns the distortion factor of a point.
	 * 
	 * @param radius
	 *            Radius of the point from the lens center in meters.
	 * @return The distortion factor. Multiply by this factor to distort points.
	 */
	float distortionFactor(float radius);

	/**
	 * Returns the current coefficients for lens distortion correction.
	 * 
	 * @return A floating point array with the current barrel distortion
	 *         coefficients.
	 */
	float[] getCoefficients();

	/**
	 * Sets the coefficients for lens distortion correction. The coefficients Ki
	 * correspond to the barrel distortion equation: p' = p (1 + K1 r^2 + K2 r^4
	 * + ... + Kn r^(2n)) Where r is the distance from the optical center, p the
	 * input point and p' the output point. Default coefficients depend on the
	 * actual Cardboard device configuration being used.
	 * 
	 * @param coefficients
	 *            Barrel distortion coefficients to set.
	 */
	void setCoefficients(float[] coefficients);

}
