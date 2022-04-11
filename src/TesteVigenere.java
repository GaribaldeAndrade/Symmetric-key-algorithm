import vigenere.Vigenere;

public class TesteVigenere {
    public static void main(String[] args) {
        try {
            String codificado = Vigenere.encriptar("bicicleta", "atacaremos");
            System.out.println("TESTE VIGENERE");

            System.out.println("Criptografado: " + codificado);
            System.out.println("Decodificado: " + Vigenere.decodificar("bicicleta",
                    codificado));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
