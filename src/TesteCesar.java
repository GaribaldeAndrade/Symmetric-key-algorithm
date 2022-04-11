import cesar.Cesar;

public class TesteCesar {
    public static void main(String[] args) {
        try {
            int chave = 5;
            String codificado = Cesar.encriptar(chave, "abcd efg");
            System.out.println("TESTE CESAR");

            System.out.println("Texto codificado: " + codificado);
            System.out.println("Texto Decodificado: " + Cesar.decodificar(chave, codificado));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
