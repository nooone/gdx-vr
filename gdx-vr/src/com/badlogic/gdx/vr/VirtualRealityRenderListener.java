/* ######################################
 * Copyright 2014 (c) Pixel Scientists
 * All rights reserved.
 * Unauthorized copying of this file, via
 * any medium is strictly prohibited.
 * Proprietary and confidential.
 * ###################################### */
package com.badlogic.gdx.vr;

import com.badlogic.gdx.graphics.Camera;

/**
 * @author Daniel Holderbaum
 */
public interface VirtualRealityRenderListener {

	/**
	 * Should be implemented to clear the screen for example.
	 */
	void frameStarted();

	void frameEnded();

	/** Called once or twice, depending on the settings of the renderer. */
	void render(Camera camera);

}
