package com.badlogic.gdx.vr.simpleroom.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.vr.OculusImplementation;
import com.badlogic.gdx.vr.simpleroom.SimpleRoom;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "GDX-VR";
		new LwjglApplication(new SimpleRoom(), config);
		new OculusImplementation();
	}
}
