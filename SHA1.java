import java.security.*;
public class SHA1
{
  public static void main (String[]a)
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance ("SHA1");
      String input = "sJce";
      md.update (input.getBytes());
      byte[] output = md.digest();
      System.out.println ("SHA1(\"" + input + "\") = " + bytesToHex (output));
    }
    catch (Exception e)
    {
      System.out.println ("Exception: " + e);
    }
  }
  public static String bytesToHex (byte[]b)
  {
    char hexDigit[] =
      { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
      'E', 'F'
    };
    StringBuffer buf = new StringBuffer ();
    for (int j = 0; j < b.length; j++)
      {
       buf.append (hexDigit[(b[j] >> 4) & 0x0f]);
       buf.append (hexDigit[b[j] & 0x0f]);
      }
    return buf.toString ();
  }
}
