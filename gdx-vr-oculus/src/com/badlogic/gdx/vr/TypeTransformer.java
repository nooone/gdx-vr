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

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.oculusvr.capi.OvrMatrix4f;
import com.oculusvr.capi.OvrQuaternionf;
import com.oculusvr.capi.OvrRecti;
import com.oculusvr.capi.OvrSizei;
import com.oculusvr.capi.OvrVector2f;
import com.oculusvr.capi.OvrVector2i;
import com.oculusvr.capi.OvrVector3f;

/**
 * @author Daniel Holderbaum
 */
public abstract class TypeTransformer {

	public static Quaternion transform(OvrQuaternionf sourceQuaternion) {
		float x = sourceQuaternion.x;
		float y = sourceQuaternion.y;
		float z = sourceQuaternion.z;
		float w = sourceQuaternion.w;

		return new Quaternion(x, y, z, w);
	}

	public static void transform(OvrQuaternionf sourceQuaternion, Quaternion quaternion) {
		float x = sourceQuaternion.x;
		float y = sourceQuaternion.y;
		float z = sourceQuaternion.z;
		float w = sourceQuaternion.w;

		quaternion.set(x, y, z, w);
	}

	public static Vector3 transform(OvrVector3f sourceVector) {
		float x = sourceVector.x;
		float y = sourceVector.y;
		float z = sourceVector.z;

		return new Vector3(x, y, z);
	}

	public static void transform(OvrVector3f sourceVector, Vector3 vector) {
		float x = sourceVector.x;
		float y = sourceVector.y;
		float z = sourceVector.z;

		vector.set(x, y, z);
	}

	public static Vector2 transform(OvrVector2i sourceVector) {
		int x = sourceVector.x;
		int y = sourceVector.y;

		return new Vector2(x, y);
	}

	public static Vector2 transform(OvrVector2f sourceVector) {
		float x = sourceVector.x;
		float y = sourceVector.y;

		return new Vector2(x, y);
	}

	public static Matrix4 transform(OvrMatrix4f sourceMatrix) {
		float[] values = sourceMatrix.M;

		return new Matrix4(values);
	}

	/**
	 * TODO: maybe make this a Vector2 instead?
	 */
	public static Rectangle transform(OvrSizei sourceSize) {
		float w = sourceSize.w;
		float h = sourceSize.h;

		return new Rectangle(0, 0, w, h);
	}

	public static Rectangle transform(OvrRecti sourceRectangle) {
		float x = sourceRectangle.Pos.x;
		float y = sourceRectangle.Pos.y;
		float w = sourceRectangle.Size.w;
		float h = sourceRectangle.Size.h;

		return new Rectangle(x, y, w, h);
	}
}
