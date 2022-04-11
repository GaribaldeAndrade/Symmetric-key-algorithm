import vernam.Vernam;

public class TesteVernam {
    public static void main(String[] args) {
        try {
            String mensagem = "obrigado";

            String codificado = Vernam.encriptar(mensagem);
            System.out.println("TESTE VERNAM");

            System.out.println("Codificado: " + codificado);
            System.out.println("Decodificado: " + Vernam.decodificar(codificado));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
