class RailFence {

    static String encode(String msg, int depth) throws Exception {
        int row = depth;
        int len = msg.length();
        int col = (len / depth) + 1;
        int k = 0;
        char mat[][] = new char[row][col];
        String enc = "";
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (k < len) {
                    mat[j][i] = msg.charAt(k++);
                } else {
                    mat[j][i] = 'X';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                enc += mat[i][j];
            }
        }
        return enc;
    }

    static String decode(String encmsg, int depth) throws Exception {
        int row = depth;
        int len = encmsg.length();
        int col = (len / depth) ;
        int k = 0;
        char mat[][] = new char[row][col];
        String dec = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = encmsg.charAt(k++);
                // System.out.println(mat[i][j]);
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                dec += mat[j][i];
            }
        }
        return dec;
    }

    public static void main(String[] args) throws java.lang.Exception {
        String msg, enc, dec;
        msg = "MeetAtTheSchoolHouse";
        int depth = 2;
        enc = encode(msg, depth);
        dec = decode(enc, depth);
        System.out.println("Simulating Railfence Cipher\n");
        System.out.println("Input Message : " + msg);
        System.out.println("Encrypted Message : " + enc);
        System.out.printf("Decrypted Message : " + dec);
    }
}

