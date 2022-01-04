import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

public class DSS {
   public static void main(String args[]) throws Exception {

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter some text");
      String msg = sc.nextLine();
      
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      keyPairGen.initialize(1024);

      KeyPair pair = keyPairGen.generateKeyPair();
      
      PrivateKey privKey = pair.getPrivate();
      
      Signature sign = Signature.getInstance("MD5withRSA");
      sign.initSign(privKey);
      byte[] bytes = "msg".getBytes("UTF8");
      
      sign.update(bytes);
      
      byte[] signature = sign.sign();
      
      System.out.println("Digital signature for given text: "+new String(signature, "UTF8"));
      
      sign.initVerify(pair.getPublic());
      sign.update(bytes);
      System.out.println(sign.verify(signature));
   }
}
