import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class AES {

    // Function to create a secret key
    public static SecretKey createAESKey()
            throws Exception {
        SecureRandom securerandom = new SecureRandom();
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");

        keygenerator.init(256, securerandom);
        SecretKey key = keygenerator.generateKey();

        return key;
    }

    // Function to initialize a vector with an arbitrary value
    public static byte[] createInitializationVector() {

        // Used with encryption
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    // This function takes plaintext ,the key with an initialization vector to convert plainText into CipherText.
    public static byte[] do_AESEncryption(
            String plainText,
            SecretKey secretKey,
            byte[] initializationVector)
            throws Exception {
        // We are using a Block cipher(CBC mode)
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        IvParameterSpec ivParameterSpec = new IvParameterSpec(
                initializationVector);

        cipher.init(Cipher.ENCRYPT_MODE,
                secretKey,
                ivParameterSpec);

        return cipher.doFinal(
                plainText.getBytes());
    }

    // This function performs the reverse operation of the do_AESEncryption function.It converts ciphertext to the plaintext using the key.
    public static String do_AESDecryption(
            byte[] cipherText,
            SecretKey secretKey,
            byte[] initializationVector)
            throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        cipher.init(
                Cipher.DECRYPT_MODE,
                secretKey,
                ivParameterSpec);

        byte[] result = cipher.doFinal(cipherText);

        return new String(result);
    }

    public static void main(String args[]) throws Exception{

        String plainText = "HelloWorld";
        SecretKey secretKey = createAESKey();
        byte[] initializationVector = createInitializationVector();
        byte[] cipherText = do_AESEncryption(plainText, secretKey, initializationVector);
        System.out.println("Encrypted[Bytes] : "+cipherText);
        System.out.println("Decrypted : "+do_AESDecryption(cipherText, secretKey, initializationVector));
    }
}
