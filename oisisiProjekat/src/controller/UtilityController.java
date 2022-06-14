package controller;

public class UtilityController {

	private static UtilityController instance = null;
	
	public static UtilityController getInstance() {
		if (instance == null) {
			instance = new UtilityController();
		}
		return instance;
	}	
	
	
	public boolean isNumber(String st) {
		try {
			Integer.parseInt(st);
			return true;
		}catch(NumberFormatException ex){
			return false;
		}
	}
	
	public boolean validateDate(String st) {
		String[] date = st.split("\\.");
		int day;
		int month;
		
		try {
			day = Integer.parseInt(date[0]);
		}catch(Exception e) {
			return false;
		}
		
		try {
			month = Integer.parseInt(date[1]);
		}catch(Exception e) {
			return false;
		}	
		
		try {
			 Integer.parseInt(date[2]);
		}catch(Exception e) {
			return false;
		}	
			
		if(date[2].length() != 4) {
			return false;
		}else if(date[2] == null) {
			return false;
		}

		
		
		if(month > 12 || month < 1) {
			return false;
		}else if(day < 1) {
			return false;
		}else if(month == 2) {
			if(day > 29) {
				return false;
			}
		}else if(month==1 || month==3 || month==5 || month==7 ||month==8 || month==10 || month==12) {
			if(day>31) {
				return false;
			}
		}else if(month==4 || month==6 || month==9 || month==11) {
			if(day>30) {
				return false;
			}
		}
		return true;
	} 
}
