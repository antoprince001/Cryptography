import java.util.*;

public class DiffieHellman
{
    public static void main(String[] args) {
        
        long  q ,alpha , xa, xb,ya,yb,ka,kb;
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter prime number  : ");
        q = s.nextLong();
        
        System.out.println("Enter primitive root of q : ");
        alpha = s.nextLong();
        
        // USER A Key Generation
        System.out.println("Enter a number less than primitive root : ");
        xa = s.nextLong();
        
        ya = (long)Math.pow(alpha,xa);
        ya = ya%q;
        
        // USER B Key Generation
        System.out.println("Enter a number less than primitive root : ");
        xb = s.nextLong();
        
        yb = (long)Math.pow(alpha,xb);
        yb = yb%q;
    
        //Secret key Generation
        ka = ((long)Math.pow(yb,xa) )%q;

        kb = ((long)Math.pow(ya,xb))%q;

        System.out.println("Private key of Alice " + xa);
        System.out.println("Public key of Alice " + ya);
        System.out.println("Secret key of Alice " + ka);
        
        System.out.println("Private key of Bob " + xb);
        System.out.println("Public key of Bob " + yb);
        System.out.println("Secret key of Bob " + kb);
        
    }
}
