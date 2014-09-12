/* ######################################
 * Copyright 2014 (c) Pixel Scientists
 * All rights reserved.
 * Unauthorized copying of this file, via
 * any medium is strictly prohibited.
 * Proprietary and confidential.
 * ###################################### */
package com.badlogic.gdx.vr;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

/**
 * @author Daniel Holderbaum
 */
public class Body {

	public Vector3 position;

	public Quaternion rotation;

	public final Vector3 headOffset = new Vector3(0f, 1.61f / 2f, 0f);

}
