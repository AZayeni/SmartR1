package Business.Cypher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import android.util.Base64;
import javax.crypto.Cipher;

/**
 * Created by AZayeni on 21/02/2018.
 */

public class BasicAES {
    public BasicAES() {

    }



    static byte[] encrypt(String IV, String Key, String message) throws Exception{
        return  encrypt(IV.getBytes(),Key.getBytes(),message.getBytes("UTF-8"));
    }

    static byte[] encrypt(byte[] ivBytes, byte[] keyBytes, byte[] bytes) throws Exception{
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
        return cipher.doFinal(bytes);
    }

    static byte[] decrypt(String IV, String Key, String message)  throws Exception{
        return  decrypt(IV.getBytes(),Key.getBytes(),message.getBytes("UTF-8"));
    }
    static byte[] decrypt(byte[] ivBytes, byte[] keyBytes, byte[] bytes)  throws Exception{
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
        return cipher.doFinal(bytes);
    }
    public static String encryptStrAndToBase64(String ivStr, String keyStr, String enStr) throws Exception{
        byte[] bytes = encrypt(keyStr, keyStr, enStr);
        return new String(Base64.encode(bytes ,Base64.DEFAULT), "UTF-8");
    }

    public static String decryptStrAndFromBase64(String ivStr, String keyStr, String deStr) throws Exception{
        byte[] bytes = decrypt(keyStr, keyStr,deStr);
        return new String(bytes, "UTF-8");
    }
}
