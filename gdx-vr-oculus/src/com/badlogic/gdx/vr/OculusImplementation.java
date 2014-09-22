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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.LifecycleListener;
import com.oculusvr.capi.Hmd;
import com.oculusvr.capi.OvrLibrary;

/**
 * @author Daniel Holderbaum
 */
public class OculusImplementation implements VirtualRealityImplementation {

	private Hmd hmd;

	public OculusImplementation() {
		VirtualReality.implementation = this;

		VirtualReality.head = new Head();
		VirtualReality.body = new Body();
		VirtualReality.renderer = new VirtualRealityRenderer();

		OvrLibrary.INSTANCE.ovr_Initialize();
		hmd = OvrLibrary.INSTANCE.ovrHmd_CreateDebug(0);
		VirtualReality.headMountedDisplay = new OculusHMD(hmd);

		Gdx.app.addLifecycleListener(new LifecycleListener() {
			@Override
			public void resume() {
			}

			@Override
			public void pause() {
			}

			@Override
			public void dispose() {
				OvrLibrary.INSTANCE.ovr_Shutdown();
			}
		});
	}

	@Override
	public boolean supportsAntiDistortion() {
		return true;
	}

	@Override
	public void addDeviceListener(VirtualRealityDeviceListener listener) {
	}

	@Override
	public void removeDeviceListener(VirtualRealityDeviceListener listener) {
	}

	/**
	 * TODO: move this somewhere else
	 */
	@Override
	public void update(float deltaTime) {
		// TODO: can each eye have a different orientation here?
		TypeTransformer.transform(hmd.getEyePose(0).Orientation, VirtualReality.head.getOrientation());
		TypeTransformer.transform(hmd.getEyePose(1).Orientation, VirtualReality.head.getOrientation());
		TypeTransformer.transform(hmd.getEyePose(0).Position, VirtualReality.head.getPosition());
		TypeTransformer.transform(hmd.getEyePose(1).Position, VirtualReality.head.getPosition());
	}

}
