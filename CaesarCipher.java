import java.util.Scanner;
class CaesarCipher{
    
    static String encode(String pt,int key){
        pt = pt.toUpperCase();
        char[] charsArr = pt.toCharArray();
        String enc = "";
        System.out.println(pt.length());
        for(char i : charsArr){
            if(i>='A' && i<='Z')
                enc += (char)((i+key-'A')%26 + 'A')+"";
            else if(i>='a' && i<='z')
                enc += (char)((i+key-'a')%26 + 'a')+"";
            else
                enc += i;
        }

        return enc;
    }
    static String decode(String pt,int key){
        return encode(pt,26-key);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String pt = sc.nextLine();
        String enc = encode(pt,3);
        System.out.println(enc);
        System.out.println(decode(enc,3));

    }
}
