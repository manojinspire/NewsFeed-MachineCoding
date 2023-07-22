package Services;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Security {

	
	protected static String encode(String msg) {
		Encoder encoder = Base64.getEncoder() ; 
		return encoder.encodeToString(msg.getBytes()) ; 
	}
	
	protected static String decode(String encryptedmsg) {
		Decoder decoder = Base64.getDecoder() ;
		byte[] bytes = decoder.decode(encryptedmsg) ;  
		return new String(bytes) ; 
	}
}
