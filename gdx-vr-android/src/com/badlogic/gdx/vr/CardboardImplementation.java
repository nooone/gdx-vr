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

import android.app.Activity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.math.Matrix4;
import com.google.vrtoolkit.cardboard.HeadMountedDisplay;
import com.google.vrtoolkit.cardboard.sensors.HeadTracker;

/**
 * @author Daniel Holderbaum
 */
public class CardboardImplementation implements VirtualRealityImplementation {

	private HeadTracker headTracker;

	public CardboardImplementation(Activity activity) {
		VirtualReality.implementation = this;

		VirtualReality.head = new Head();
		VirtualReality.body = new Body();
		VirtualReality.renderer = new VirtualRealityRenderer();

		headTracker = new HeadTracker(activity);
		headTracker.startTracking();

		VirtualReality.headMountedDisplay = new CardboardHMD(new HeadMountedDisplay(activity.getWindowManager().getDefaultDisplay()));

		Gdx.app.addLifecycleListener(new LifecycleListener() {
			@Override
			public void resume() {
			}

			@Override
			public void pause() {
			}

			@Override
			public void dispose() {
				headTracker.stopTracking();
			}
		});
	}

	@Override
	public boolean supportsAntiDistortion() {
		return true;
	}

	@Override
	public void addDeviceListener(VirtualRealityDeviceListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDeviceListener(VirtualRealityDeviceListener listener) {
		// TODO Auto-generated method stub

	}

	private static final Matrix4 HEAD_ROTATION = new Matrix4();

	@Override
	public void update(float deltaTime) {
		int writeOffset = 0;
		// we need to supply a 4x4, column major matrix
		headTracker.getLastHeadView(HEAD_ROTATION.getValues(), writeOffset);
		HEAD_ROTATION.getRotation(VirtualReality.head.getOrientation(), true);
	}
}
