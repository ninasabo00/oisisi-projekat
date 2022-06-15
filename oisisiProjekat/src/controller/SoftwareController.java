package controller;

import model.Software;
import model.SoftwareLogic;

public class SoftwareController {
	private static SoftwareController instance = null;
	
	public static SoftwareController getInstance() {
		if (instance == null) {
			instance = new SoftwareController();
		}
		return instance;
	}
	
	public Software findSoftware(String softwareName) {
		return SoftwareLogic.getInstance().findSoftware(softwareName);
	}
}
