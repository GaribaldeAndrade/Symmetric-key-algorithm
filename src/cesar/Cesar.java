package cesar;

public class Cesar {

    public static String encriptar(int chave, String textoNaoCriptografado) throws Exception, NullPointerException {
        StringBuilder textoCriptografado = new StringBuilder();

        if (textoNaoCriptografado == null) {
            throw new NullPointerException("O texto não pode ser vazio");
        }

        textoNaoCriptografado = textoNaoCriptografado.toUpperCase();
        textoNaoCriptografado = textoNaoCriptografado.replace(" ", "");

        // Looping de encriptação
        for (int i = 0; i < textoNaoCriptografado.length(); i++) {

            if (textoNaoCriptografado.charAt(i) > 90 || textoNaoCriptografado.charAt(i) < 65) {
                throw new Exception("Apenas letras são suportadas pelo programa");
            }

            int letraCifrada = (textoNaoCriptografado.charAt(i) + chave);

            // verificação das letra maiúsculas
            while (letraCifrada > 90) {
                letraCifrada = letraCifrada - 26;
            }

            // criando a String criptografada modificando o valor criptografado para
            // caractere
            textoCriptografado.append((char) letraCifrada);
        }

        return textoCriptografado.toString();
    }

    public static String decodificar(int chave, String textoCriptografado) throws Exception, NullPointerException {
        StringBuilder textoDecodificado = new StringBuilder();

        if (textoCriptografado == null) {
            throw new NullPointerException("O texto criptografado não pode ser vazio");
        }

        textoCriptografado = textoCriptografado.toUpperCase();
        textoCriptografado = textoCriptografado.replace(" ", "");

        for (int i = 0; i < textoCriptografado.length(); i++) {

            if (textoCriptografado.charAt(i) > 90 || textoCriptografado.charAt(i) < 65) {
                throw new Exception("Apenas letras são suportadas pelo programa");
            }

            int letraCifrada = (textoCriptografado.charAt(i) - chave);

            // verificação das letra maiúsculas
            while (letraCifrada < 65) {
                letraCifrada = letraCifrada + 26;
            }

            // criando a String criptografada modificando o valor criptografado para
            // caractere
            textoDecodificado.append((char) letraCifrada);
        }

        return textoDecodificado.toString();
    }
}
