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
	 * TODO: move to DeviceOpticsInformation? Returns the lens distortion model.
	 * 
	 * @return The lens distortion model.
	 */
	Distortion getDistortion();

	DeviceMetaInformation getDeviceMetaInformation();

	DeviceOpticsInformation getDeviceOpticsInformation();

	DeviceScreenInformation getDeviceScreenInformation();

	// /** Returns the NFC tag contents from there these parameters were
	// extracted. */
	// NdefMessage getNfcTagContents();

}
