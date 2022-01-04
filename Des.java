import javax.crypto.*;
import java.util.Base64;

public class Des {
    public static void main(String[] argv) {
        try {
            System.out.println("Message Encryption Using DES Algorithm\n-------");
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            
            byte[] text = "Secret  ".getBytes();
            System.out.println("Message [Byte Format] : " + text);
            System.out.println("Message : " + text);
            
            byte[] textEncrypted = desCipher.doFinal(text);
            Base64.Encoder encoder = Base64.getEncoder();
            String encryptedText = encoder.encodeToString(text);
            System.out.println("Encrypted Message: " + encryptedText);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);
            System.out.println("Decrypted Message: " + new String(textDecrypted));
        
        } catch (Exception e) {//U2VjcmV0IEluZm9ybWF0aW9u
            e.printStackTrace();
        } 
           
    }
}
