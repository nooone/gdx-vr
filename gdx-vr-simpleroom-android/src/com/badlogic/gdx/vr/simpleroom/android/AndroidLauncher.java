package com.badlogic.gdx.vr.simpleroom.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.vr.CardboardImplementation;
import com.badlogic.gdx.vr.simpleroom.SimpleRoom;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		new CardboardImplementation(this);
		initialize(new SimpleRoom(), config);
	}
}
