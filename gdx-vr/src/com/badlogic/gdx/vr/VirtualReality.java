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

/**
 * This class is similar to {@link Gdx}.
 * 
 * @author Daniel Holderbaum
 */
public class VirtualReality {

	public static HeadMountedDisplay headMountedDisplay;

	public static Head head;

	public static Body body;

	public static VirtualRealityRenderer renderer;

	static VirtualRealityImplementation implementation;

	// TODO: remove from here and javadoc
	public static void update(float deltaTime) {
		implementation.update(deltaTime);
	}

}
