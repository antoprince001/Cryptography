public class Vigenere {
    public static void main(String args[]){

        String input = "WEAREDISCOVEREDSAVEYOURSELF".toUpperCase();
        String result = "";

        String key = "DECEPTIVE".toUpperCase();

        int len = key.length();

        int j = 0,sum=0;
        //Encryption 
        for(int i=0;i<input.length();i++){
            int a = (int)(input.charAt(i)-'A'); 
            int b = (int)(key.charAt(j)-'A'); 
            sum = (a+b)%26;

            result = result + (char)(sum+'A');
            sum = 0;

            if(j == len-1){
                j=0;
            }
            else j++;
        }
        System.out.println("Encrypted : "+result);
        String dec = "";
        for(int i=0;i<result.length();i++){
            int a = (int)(result.charAt(i)-'A'); 
            int b = (int)(key.charAt(j)-'A'); 
            sum = (a-b+26)%26;

            dec = dec + (char)(sum+'A');
            sum = 0;

            if(j == len-1){
                j=0;
            }
            else 
                j++;
        }
        System.out.println("Decrypted : "+dec);

    }
}
