package tud.ai2.wise2021.model.chiffre;

public class MyChiffre extends Chiffre  {
	public String decode(String klartext, String key) throws IllegalArgumentException{
		//TODO Aufgabe 1
		int len = key.length();
		char[] key_ele = new char[key.length()];
		String table = "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ,.!?";
		for(int i = 0; i<len; i++) {
			int c = table.indexOf(Character.toString(key.charAt(i)));
			if(c != 0) {
				c = table.length() - c;
			}
			key_ele[i] = table.charAt(c);
		}
		return encode(klartext, key_ele.toString());
		
			}

    public String encode(String klartext, String key) throws IllegalArgumentException {
    	
    	int len = klartext.length();
    	int key_len = key.length();
		char[] key_res = new char[len];
		// Werfen Sie außerdem eine IllegalArgumentException, falls einer der Parameter null ist.
		if(klartext == null || key ==null ) {
			throw new IllegalArgumentException();
			
		}
		else {
			for(int i = 0; i<len; i++) {
				if(i>=key_len) {
					key+=key.charAt(i-key_len);
				}
				key+=key.charAt(i);
			}
			for (int j = 0; j<key_res.length; j++ ) {
				char c = klartext.charAt(j);
				c += key.charAt(j);
				key_res[j]=charAt(c);
				
			}
		}
		return key_res.toString();
    	
    }
	

}
