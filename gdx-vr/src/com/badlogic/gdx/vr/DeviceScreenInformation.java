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
public interface DeviceScreenInformation {

	/**
	 * Scaling constant to convert from inches to meters.
	 */
	float METERS_PER_INCH = 0.0254f;

	/**
	 * Returns the screen height in pixels.
	 * 
	 * @return The screen height in pixels.
	 */
	public int getHeight();

	/**
	 * Returns the screen height in meters.
	 * 
	 * @return The screen height in meters.
	 */
	public float getHeightMeters();

	/**
	 * Returns the screen width in pixels.
	 * 
	 * @return The screen width in pixels.
	 */
	public int getWidth();

	/**
	 * Returns the screen width in meters.
	 * 
	 * @return The screen width in meters.
	 */
	public float getWidthMeters();

	/**
	 * Returns the size of the border around the device screen in meters.
	 * 
	 * It's the offset in meters from the bottom side of the inserted device to
	 * the bottom of the screen. Normally a small border of a few millimeters
	 * height when the device is in landscape position.
	 * 
	 * @return The size of the border around the device screen in meters.
	 */
	public float getBorderSizeMeters();

}
