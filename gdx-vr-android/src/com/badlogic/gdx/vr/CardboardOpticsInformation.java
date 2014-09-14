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
public class CardboardOpticsInformation implements DeviceOpticsInformation {

	private CardboardDeviceParams cardboardDeviceParams;

	public CardboardOpticsInformation(CardboardDeviceParams cardboardDeviceParams) {
		this.cardboardDeviceParams = cardboardDeviceParams;
	}

	@Override
	public float getEyeToLensDistance() {
		return cardboardDeviceParams.getEyeToLensDistance();
	}

	@Override
	public float getInterpupillaryDistance() {
		return cardboardDeviceParams.getInterpupillaryDistance();
	}

	@Override
	public float getLensDiameter() {
		return cardboardDeviceParams.getLensDiameter();
	}

	@Override
	public float getScreenToLensDistance() {
		return cardboardDeviceParams.getScreenToLensDistance();
	}

	@Override
	public float getVerticalDistanceToLensCenter() {
		return cardboardDeviceParams.getVerticalDistanceToLensCenter();
	}

}
