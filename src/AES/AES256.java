package AES;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AES256 {

    KeyGenerator geradorDeChaves;
    SecretKey chaveSecreta;
    IvParameterSpec parameterSpec;

    public AES256() {
        try {
            gerarChave();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void gerarChave() throws NoSuchAlgorithmException {
        geradorDeChaves = KeyGenerator.getInstance("AES");
        geradorDeChaves.init(256);
        chaveSecreta = geradorDeChaves.generateKey();
        String chaveSecretaString = Base64.getEncoder().encodeToString(chaveSecreta.getEncoded());
        System.out.println("Chave gerada: " + chaveSecretaString);
    }

    public String encriptar(String mensagem) throws InvalidKeyException,
            InvalidAlgorithmParameterException,
            IllegalBlockSizeException,
            BadPaddingException,
            NoSuchAlgorithmException,
            NoSuchPaddingException {

        Cipher encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        parameterSpec = new IvParameterSpec(new byte[16]);

        encryptionCipher.init(Cipher.ENCRYPT_MODE, chaveSecreta, parameterSpec);

        byte[] encryptedMessageBytes = encryptionCipher.doFinal(mensagem.getBytes());

        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);

        System.out.println("Codificada = " + encryptedMessage);

        return encryptedMessage;
    }

    public String decodificar(String mensagemCriptografada)
            throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] encryptedMessageBytes = Base64.getDecoder().decode(mensagemCriptografada);

        decryptionCipher.init(Cipher.DECRYPT_MODE, chaveSecreta, parameterSpec);

        byte[] decryptedMessageBytes = decryptionCipher.doFinal(encryptedMessageBytes);

        String decryptedMessage = new String(decryptedMessageBytes);

        System.out.println("Decodificada = " + decryptedMessage);

        return decryptedMessage;
    }
}
