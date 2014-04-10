
package Main;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;


abstract class Algorithms 
{
    private static List<Algorithms> algorithms;
    
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
                    
                    return sb.toString();
                } 
                catch (java.security.NoSuchAlgorithmException e) { return "MD5 not supported!"; }
            }
        };
        
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public static List<Algorithms> getAlgorithms()
    {
        return algorithms;
    }
}
