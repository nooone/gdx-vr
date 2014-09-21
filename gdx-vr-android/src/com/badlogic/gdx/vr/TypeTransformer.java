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

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.vrtoolkit.cardboard.EyeParams;

/**
 * @author Daniel Holderbaum
 */
public abstract class TypeTransformer {

	public static EyeParams transform(Viewport viewport) {
		int eye = viewport == VirtualReality.head.getLeftEye() ? 0 : 1;
		EyeParams eyeParams = new EyeParams(eye);

		eyeParams.getViewport().setViewport(viewport.getScreenX(), viewport.getScreenY(), MathUtils.nextPowerOfTwo(viewport.getScreenWidth()),
				MathUtils.nextPowerOfTwo(viewport.getScreenHeight()));

		float fov = ((PerspectiveCamera) viewport.getCamera()).fieldOfView;
		eyeParams.getFov().setLeft(fov);
		eyeParams.getFov().setRight(fov);
		eyeParams.getFov().setTop(fov);
		eyeParams.getFov().setBottom(fov);

		for (int i = 0; i < 16; i++) {
			eyeParams.getTransform().getEyeView()[i] = viewport.getCamera().view.val[i];
		}

		for (int i = 0; i < 16; i++) {
			eyeParams.getTransform().getPerspective()[i] = viewport.getCamera().projection.val[i];
		}

		return eyeParams;
	}

}
