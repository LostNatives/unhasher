
package Main;

import java.security.MessageDigest;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Formatter;
import java.util.List;

=======
import java.util.List;


>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
abstract class Algorithms 
{
    private static List<Algorithms> algorithms;
    
<<<<<<< HEAD
    private static int processed_iterations = 0;
    
=======
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
    //  Name of an algorithm
    private String name;
    
    //  Constructor
    public Algorithms(String name)
    {
        if (algorithms == null)
            algorithms = new ArrayList<Algorithms>();
        
        this.name = name;
    
        algorithms.add(this);
    }
    
    //  Abstract method decrypt, 
    //  for each algrithm it is different
    abstract String crypt(String arg);
    
    public static void initialize()
    {
        //  MD5
        Algorithms md5 = new Algorithms("MD5") 
        {
            @Override
            String crypt(String arg) 
            {
                try 
                {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] array = md.digest(arg.getBytes());
                    StringBuffer sb = new StringBuffer();
                    
                    for (int i = 0; i < array.length; ++i) 
                    {
                        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
                    }
                    
<<<<<<< HEAD
                    processed_iterations++;
                    
=======
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
                    return sb.toString();
                } 
                catch (java.security.NoSuchAlgorithmException e) { return "MD5 not supported!"; }
            }
        };
        
<<<<<<< HEAD
        //  SHA1
        Algorithms sha1 = new Algorithms("SHA1")
        {
            @Override
            String crypt(String arg)
            {
                String sha1 = "";
                try
                {
                    MessageDigest crypt = MessageDigest.getInstance("SHA-1");
                    crypt.reset();
                    crypt.update(arg.getBytes("UTF-8"));
                    sha1 = byteToHex(crypt.digest());
                    
                    processed_iterations++;
                }
                catch (Exception ex) { System.out.println("SHA1 algorithm not available."); }
                return sha1;
            }
        };
=======
        
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
    }
    
    public String getName()
    {
        return name;
    }
    
<<<<<<< HEAD
    public static int getProcessedIterations()
    {
        return processed_iterations;
    }
    
=======
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
    public static List<Algorithms> getAlgorithms()
    {
        return algorithms;
    }
<<<<<<< HEAD
    
    
    
    private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
=======
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
}
