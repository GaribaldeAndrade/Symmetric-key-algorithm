package vigenere;

public class Vigenere {
    public static String encriptar(String chave, String textoNaoCriptografado) throws Exception, NullPointerException {
        StringBuilder textoCriptografado = new StringBuilder();

        // Verificação de variaveis nulas
        if (textoNaoCriptografado == null) {
            throw new NullPointerException("O texto criptografado não pode ser vazio");
        }
        if (chave == null) {
            throw new NullPointerException("A chave não pode ser vazia");
        }

        // Garantindo caixa alta na chave e no texto
        StringBuffer newChave = new StringBuffer(chave.toUpperCase());
        String newTextoNaoCriptografado = textoNaoCriptografado.toUpperCase();

        // Removendo espaços do texto aberto
        newTextoNaoCriptografado = newTextoNaoCriptografado.replace(" ", "");

        // Formatação da chave para garantir ter o mesmo tamanho do texto aberto
        while (newChave.length() < newTextoNaoCriptografado.length()) {
            newChave.append(chave.toUpperCase());
        }
        newChave.replace(newTextoNaoCriptografado.length(), newChave.length(), "");

        // Looping de encriptação
        for (int i = 0; i < newTextoNaoCriptografado.length(); i++) {
            if (newChave.charAt(i) > 90 || newChave.charAt(i) < 65) {
                throw new Exception("A chave deve conter apenas letras");
            }

            if (newTextoNaoCriptografado.charAt(i) > 90 || newTextoNaoCriptografado.charAt(i) < 65) {
                throw new Exception("Apenas letras são suportadas pelo programa");
            }

            int letraCifrada = newTextoNaoCriptografado.charAt(i) + (newChave.charAt(i) - 65);

            // Garantindo que o caractere permaneça nas letras maiúsculas
            while (letraCifrada > 90) {
                letraCifrada = letraCifrada - 26;
            }

            textoCriptografado.append((char) letraCifrada);
        }

        return textoCriptografado.toString();
    }

    public static String decodificar(String chave, String textoCriptografado) throws Exception, NullPointerException {
        StringBuilder textoDecodificado = new StringBuilder();

        // Verificação de variaveis nulasI
        if (textoCriptografado == null) {
            throw new NullPointerException("O texto criptografado não pode ser vazio");
        }
        if (chave == null) {
            throw new NullPointerException("A chave não pode ser vazia");
        }

        // Garantindo caixa alta na chave e no texto
        StringBuffer newChave = new StringBuffer(chave.toUpperCase());
        String newTextoCriptografado = textoCriptografado.toUpperCase();
        // Removendo espaços do texto aberto
        newTextoCriptografado = newTextoCriptografado.replace(" ", "");

        // Formatação da chave para garantir ter o mesmo tamanho do texto aberto
        while (newChave.length() < newTextoCriptografado.length()) {
            newChave.append(chave.toUpperCase());
        }
        newChave.replace(newTextoCriptografado.length(), newChave.length(), "");

        // Looping de decodificação
        for (int i = 0; i < newTextoCriptografado.length(); i++) {
            if (newTextoCriptografado.charAt(i) > 90 || newTextoCriptografado.charAt(i) < 65) {
                throw new Exception("Apenas letras são suportadas pelo programa");
            }
            if (newChave.charAt(i) > 90 || newChave.charAt(i) < 65) {
                throw new Exception("A chave deve conter apenas letras");
            }

            int letraCifrada = newTextoCriptografado.charAt(i) - (newChave.charAt(i) - 65);
            // Garantindo que o caractere permaneça nas letras maiúsculas
            while (letraCifrada < 65) {
                letraCifrada = letraCifrada + 26;
            }
            textoDecodificado.append((char) letraCifrada);
        }
        return textoDecodificado.toString();
    }
}
