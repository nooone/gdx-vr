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

import com.oculusvr.capi.Hmd;

/**
 * @author Daniel Holderbaum
 */
public class OculusDisplayMetaInformation implements DisplayMetaInformation {

	private Hmd hmd;

	public OculusDisplayMetaInformation(Hmd hmd) {
		this.hmd = hmd;
	}

	@Override
	public String getManufacturer() {
		return null;
	}

	@Override
	public String getModel() {
		return hmd.ProductName.getString(0);
	}

	@Override
	public String getVendor() {
		return String.valueOf(hmd.VendorId);
	}

	@Override
	public String getVersion() {
		return "v" + hmd.FirmwareMajor + "." + hmd.FirmwareMinor;
	}

}
