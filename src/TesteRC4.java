import RC4.RC4;

public class TesteRC4 {
    public static void main(String[] args) {
        try {
            String mensagem = "Testando RCQUATRO";
            String chave = "minhachavesecreta";

            String codificado = RC4.Encryption_Decryption(mensagem, chave);
            System.out.println("TESTE RC4");
            System.out.println("Codificado: " + codificado);
            System.out.println("Decodificado: " + RC4.Encryption_Decryption(codificado, chave));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
