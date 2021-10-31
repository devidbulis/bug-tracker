package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "stringHasher")
@RequestScoped
public class StringHasher
{

    public String hashString(String str)
    {
        try
        {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(str.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(hash);
        }
        catch (NoSuchAlgorithmException e)
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "String could not be hashed", e);
            return "";
        }
    }
}
