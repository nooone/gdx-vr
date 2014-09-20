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

import android.content.Context;

import com.google.vrtoolkit.cardboard.sensors.HeadTracker;

/**
 * @author Daniel Holderbaum
 */
public class CardboardImplementation implements VirtualRealityImplementation {

	private Context context;

	private HeadTracker headTracker;

	public CardboardImplementation(Context context) {
		this.context = context;
	}

	@Override
	public void initialize() {
		headTracker = new HeadTracker(context);
		headTracker.startTracking();
	}

	@Override
	public void shutdown() {
		headTracker.stopTracking();
		headTracker = null;
	}

	@Override
	public boolean supportsAntiDistortion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addDeviceListener(VirtualRealityDeviceListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDeviceListener(VirtualRealityDeviceListener listener) {
		// TODO Auto-generated method stub

	}

}
