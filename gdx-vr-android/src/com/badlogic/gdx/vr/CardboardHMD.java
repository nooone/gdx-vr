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

import com.google.vrtoolkit.cardboard.CardboardDeviceParams;

/**
 * @author Daniel Holderbaum
 */
public class CardboardHMD implements HeadMountedDisplay {

	private CardboardDeviceParams cardboardDeviceParams;

	private DeviceMetaInformation deviceMetaInformation;

	private DeviceOpticsInformation deviceOpticsInformation;

	private DeviceScreenInformation deviceScreenInformation;

	public CardboardHMD(CardboardDeviceParams cardboardDeviceParams) {
		this.cardboardDeviceParams = cardboardDeviceParams;
		this.deviceMetaInformation = new CardboardMetaInformation(cardboardDeviceParams);
		this.deviceOpticsInformation = new CardboardOpticsInformation(cardboardDeviceParams);
		this.deviceScreenInformation = new CardboardScreenInformation();
	}

	@Override
	public Distortion getDistortion() {
		return new CardboardDistortion(cardboardDeviceParams.getDistortion());
	}

	@Override
	public DeviceMetaInformation getDisplayMetaInformation() {
		return deviceMetaInformation;
	}

	@Override
	public DeviceOpticsInformation getDisplayOpticsInformation() {
		return deviceOpticsInformation;
	}

	@Override
	public DeviceScreenInformation getDeviceScreenInformation() {
		return deviceScreenInformation;
	}

}
