import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import AES.AES256;

public class TesteAES {
    public static void main(String[] args) {
        AES256 aes256 = new AES256();

        String mensagem;

        try {
            System.out.println("TESTE AES");

            mensagem = aes256.encriptar("Testando codigo");

            aes256.decodificar(mensagem);

        } catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException
                | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}
