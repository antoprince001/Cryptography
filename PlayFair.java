class PlayFair {
    static char[][] mat = new char[5][5];

    static void generateMatrix(String key) {
        int alphabets[] = new int[26];
        int i = 0, j = 0;

        key = key.toUpperCase();
        key = key.replaceAll("J","I");
        // Add characters in key to matrix
        for (int idx = 0; idx < key.length(); idx++) {

            char ch = key.charAt(idx);
            // if (ch == 'J') {
            //     ch = 'I';
            // }

            if(ch>='A' && ch<='Z'){
            alphabets[ch - 'A']++;

            if (alphabets[ch - 'A'] == 1) {
                mat[i][j] = ch;
                j++;
                if (j == 5) {
                    i++;
                    j = 0;
                }
                if (i == 5) {
                    i = -1;
                    break;
                }
            }
          }
        }

        // Fill the remaining characters in matrix
        if (i != -1) {
            for (int idx = 0; idx < 26; idx++) {

                if (alphabets[idx] == 0 && idx != 9) {
                    mat[i][j] = (char) (idx + 'A');
                    j++;
                    if (j == 5) {
                        i++;
                        j = 0;
                    }
                    if (i == 5) {
                        break;
                    }
                }

            }
        }
    }


    static int[] findIndices(char a){
        if(Character.isAlphabetic(a) == true){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(Character.toUpperCase(a) == mat[i][j]){
                   int []arr = new int[2];
                   arr[0] = i;
                   arr[1] = j;
                   return arr;
                }
            }
        }
            return null;
        }
        else{
            return null;
        }
    }

    static String digramEncoding(char a, char b){
        int arr1[] = findIndices(a);
        int arr2[] = findIndices(b);
        if(arr1 == null || arr2 == null){
            return a+""+b;
        }
        if(arr1[0] == arr2[0]){ //Same row
            int row = arr1[0];
            return mat[row][(arr1[1]+1)%5] +  "" + mat[row][(arr2[1]+1)%5] ;
        }
        else if(arr1[1] == arr2[1]){ // Same column
            int col = arr1[1];
            return mat[(arr1[0]+1)%5][col] + "" + mat[(arr2[0]+1)%5][col];
        }
        else{ // diff row and diff column
            return mat[arr1[0]][arr2[1]] +  "" + mat[arr2[0]][arr1[1]] ;

        }
    }

    static String encrypt(String plainText){
        
        String encryptedText = "";
        int i=0;
        plainText = plainText.toUpperCase();
        plainText = plainText.replaceAll(" ","X");
        plainText = plainText.replaceAll("J","I");
       
        while(i<=(plainText.length()-1)){
    
            char ch1 = plainText.charAt(i);
            char ch2 = 'X';
            
            if(  i!= plainText.length()-1 ){
                ch2 = plainText.charAt(i+1);
            }
            if(ch1 == ch2){ // digram same
                encryptedText = encryptedText + digramEncoding(ch1,'X');

                i+=1;
            }
                     
            else{
                if(i == plainText.length()-1){ // single character left
                    encryptedText += digramEncoding(ch1,'X');
                    i +=1;

                }
                else{ 
                encryptedText = encryptedText + digramEncoding(ch1,ch2);
                i+=2;

                }
            }
        }
        
        return encryptedText;
    }

    public static void main(String args[]){
        generateMatrix("MONARCHY");
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print((char)(mat[i][j])+" ");
            }
            System.out.println();
        }
        String pt = "Balloon";
        String ct = encrypt(pt);
        System.out.println(ct);
        //System.out.println(decrypt(ct));


    }
}
