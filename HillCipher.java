class HillCipher {

    int[][] matrix;
    int size;
    static final int N = 3;
  
    public void keyInit(String key, int n) {
  
      this.matrix = new int[n][n];
      this.size = n;
      int index = 0;
      key = key.toUpperCase();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (key.charAt(index) >= 'A' && key.charAt(index) <= 'Z')
            this.matrix[i][j] = (int)(key.charAt(index) - 'A');
          index++;
        }
      }

    }
   
  
  
  
    public void display() {
      for (int i = 0; i < this.size; i++) {
        for (int j = 0; j < this.size; j++) {
          System.out.print(this.matrix[i][j] + " ");
        }
        System.out.println();
      }
 
    }
  
    public String encrypt(String plainText) {
      int ptMatrix[] = new int[plainText.length()];
      plainText = plainText.toUpperCase();
  
      // PlainText Matrix Generation
      for (int i = 0; i < plainText.length(); i++) {
        if (plainText.charAt(i) >= 'A' && plainText.charAt(i) <= 'Z')
          ptMatrix[i] = (int)(plainText.charAt(i) - 'A');
      }
  
      // kEY and PlainText Matrix Multiplication
      int encrypted[] = new int[this.size];
      for (int i = 0; i < this.size; i++) {
        for (int j = 0; j < 1; j++) {
          for (int k = 0; k < this.size; k++) {
            encrypted[i] += (this.matrix[i][k] * ptMatrix[k]);
          }
  
        }
      }
      String encryptedText = "";
      for (int i = 0; i < this.size; i++) {
        encryptedText += (char)(encrypted[i] % 26 + 'A');
      }
  
      return encryptedText;
  
    }
 }
 
  public class Main
  {
      public static void main(String[] args) {
  
  
      HillCipher hc = new HillCipher();
      hc.keyInit("ACTIVATED", 3);
      hc.display();
      String  s = hc.encrypt("PEN");
      System.out.println(s);
  
    }
  }
  
