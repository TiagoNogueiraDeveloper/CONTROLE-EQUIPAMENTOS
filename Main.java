public class Main {
    public static void main(String[] args) {
        Laboratorio lab1 = new Laboratorio("Lab 1");

        Equipamento computador = new Computador("CP001", "Computador Dell", 2500.00, 2022, StatusManutencao.OPERACIONAL, "Intel i7", 16);
        Equipamento projetor = new Projetor("PR001", "Projetor Epson", 1500.00, 2021, StatusManutencao.OPERACIONAL, "1920x1080", true);

        // Adicionando equipamentos ao laboratório
        lab1.adicionar(computador);
        lab1.adicionar(projetor);

        // Listando equipamentos do laboratório
        System.out.println("Equipamentos no " + lab1.getNome() + ":");
        for (Equipamento e : lab1.listarEquipamentos()) {
            System.out.println(e.getDescricao() + " - Código: " + e.getCodigoPatrimonio());
        }

        // Criando inventário e adicionando laboratórios
        Inventario inventario = new Inventario();
        inventario.adicionarLaboratorio("Lab 1");

        // Tentando adicionar um laboratório com o mesmo nome
        boolean adicionado = inventario.adicionarLaboratorio("Lab 1");
        System.out.println("Laboratório adicionado: " + adicionado); // Deve ser false
    }
}