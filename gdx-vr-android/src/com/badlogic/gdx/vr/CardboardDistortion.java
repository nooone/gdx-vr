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

import com.badlogic.gdx.graphics.Mesh;

/**
 * @author Daniel Holderbaum
 */
public class CardboardDistortion implements Distortion {

	private com.google.vrtoolkit.cardboard.Distortion distortion;

	public CardboardDistortion(com.google.vrtoolkit.cardboard.Distortion distortion) {
		this.distortion = distortion;
	}

	@Override
	public float distort(float radius) {
		return distortion.distort(radius);
	}

	@Override
	public float distortInverse(float radius) {
		return distortion.distortInverse(radius);
	}

	@Override
	public float distortionFactor(float radius) {
		return distortion.distortionFactor(radius);
	}

	@Override
	public float[] getCoefficients() {
		return distortion.getCoefficients();
	}

	@Override
	public void setCoefficients(float[] coefficients) {
		distortion.setCoefficients(coefficients);
	}

	@Override
	public Mesh getAntiDistortionMesh() {
		// TODO Auto-generated method stub
		return null;
	}

}
