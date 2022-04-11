package vernam;

public class Vernam {
    StringGenerator stringGenerator = new StringGenerator();

    static String chave;

    public static String encriptar(String textoNaoCriptografado) throws Exception, NullPointerException {
        if (textoNaoCriptografado == null) {
            throw new NullPointerException("A mensagem não pode ser vazia");
        }

        chave = StringGenerator.getRandomString(textoNaoCriptografado.length());

        StringBuilder textoCriptografado = new StringBuilder();

        String newTextoNaoCriptografado = textoNaoCriptografado.toUpperCase();
        // Removendo espaços do texto aberto
        newTextoNaoCriptografado = newTextoNaoCriptografado.replace(" ", "");

        for (int i = 0; i < newTextoNaoCriptografado.length(); i++) {
            if (newTextoNaoCriptografado.charAt(i) > 90 || newTextoNaoCriptografado.charAt(i) < 65) {
                throw new Exception("Apenas letras são suportadas pelo programa");
            }

            int letraCifrada = newTextoNaoCriptografado.charAt(i) ^ chave.charAt(i);

            textoCriptografado.append((char) letraCifrada);
        }

        return textoCriptografado.toString();
    }

    public static String decodificar(String textoCriptografado) throws Exception, NullPointerException {
        StringBuilder textoDecodificado = new StringBuilder();
        if (textoCriptografado == null) {
            throw new NullPointerException("O texto criptografado não pode ser vazio");
        }

        String newTextoCriptografado = textoCriptografado.toUpperCase();

        // Removendo espaços do texto aberto
        newTextoCriptografado = newTextoCriptografado.replace(" ", "");

        for (int i = 0; i < newTextoCriptografado.length(); i++) {
            int letraCifrada = newTextoCriptografado.charAt(i) ^ chave.charAt(i);

            textoDecodificado.append((char) letraCifrada);
        }

        return textoDecodificado.toString();
    }
}
