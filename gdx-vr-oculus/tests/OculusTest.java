import com.oculusvr.capi.OvrLibrary;
import com.oculusvr.capi.OvrLibrary.ovrHmdType;

/* ######################################
 * Copyright 2014 (c) Pixel Scientists
 * All rights reserved.
 * Unauthorized copying of this file, via
 * any medium is strictly prohibited.
 * Proprietary and confidential.
 * ###################################### */

/**
 * @author Daniel Holderbaum
 */
public class OculusTest {

	public static void main(String[] args) {
		OvrLibrary lib = OvrLibrary.INSTANCE;
		lib.ovr_Initialize();

		System.out.println(lib.ovrHmd_CreateDebug(ovrHmdType.ovrHmd_DK2));

		lib.ovr_Shutdown();
	}

}
