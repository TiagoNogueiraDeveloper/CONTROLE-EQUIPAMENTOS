import java.util.List;
import java.util.ArrayList;
public class Inventario {
    public static final int MAX_LABORATORIOS = 5;
    List<Laboratorio> laboratorios = new ArrayList<>();

    // vvvvvv LABORATORIO vvvvvv
    public boolean adicionarLaboratorio(String nome) {
        for (Laboratorio laboratorio : laboratorios) {
            if (laboratorio.getNome().trim() // .trim ignora espaços para realizar a comparação
                    .equals(nome.trim())) { // .equals compara os valores
                return false;
            }
        }

        laboratorios.add(new Laboratorio(nome)); // declara novo lab com o nome do parametro
        return true;
    }

    public List<Laboratorio> listarLaboratorio(){ 
        return laboratorios;        
    }

    public Laboratorio buscarLaboratorio(String nome){
        for (Laboratorio laboratorio : laboratorios) {
            if (laboratorio.getNome().trim() // .trim ignora espaços para realizar a comparação
                    .equals(nome.trim())) { // .equals compara os valores
                return laboratorio;
            }
        }
        return null;
    }
    // ^^^^^^ LABORATORIO ^^^^^^
    

    // vvvvvv EQUIPAMENTO vvvvvv
    public boolean adicionarEquipamento(String nomeLab, Equipamento e) {
    // Valida os dados antes de procurar o laboratório
    if (nomeLab == null || e == null || // Valida existencia do lab ou e do equipamento
        e.getCodigoPatrimonio() == null ||
        e.getCodigoPatrimonio().isBlank() || // Valida codigo patrimonio do equipamento
        e.getDescricao() == null ||
        e.getDescricao().isBlank() || // Valida descrição do equipamento
        e.getValor() < 0) { // Valida valor real
        return false;
    }

    for (Laboratorio laboratorio : laboratorios) {
        if (laboratorio.getNome().trim().equals(nomeLab.trim())) {

            // Impede código de patrimônio repetido neste laboratório
            if (laboratorio.equipamentos.containsKey(e.getCodigoPatrimonio())) {
                return false;
            }

            // Adiciona o equipamento ao laboratório encontrado
            laboratorio.equipamentos.put(e.getCodigoPatrimonio(), e);
            return true;
        }
    }

    return false; // Nenhum laboratório com esse nome foi encontrado
    }



    public boolean removerEquipamentos(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return false;
        }

        for (Laboratorio laboratorio : laboratorios) {
            if (laboratorio.equipamentos.remove(codigo.trim()) != null) { // Tratamento com trim para limpar o input
                return true; // Encontrou e removeu o equipamento
            }
        }

        return false; // Código não encontrado em nenhum laboratório
    }



    public Equipamento buscarEquipamento(String nomeLab, String codigo) {
        for (Laboratorio laboratorio : laboratorios) {
            if (laboratorio.getNome().trim().equals(nomeLab.trim())) {
                return laboratorio.buscar(codigo);
            }
        }
        return null;
    }

    public List<Equipamento> listarEquipamentos() {
        List<Equipamento> todosEquipamentos = new ArrayList<>();
        for (Laboratorio laboratorio : laboratorios) {
            todosEquipamentos.addAll(laboratorio.listarEquipamentos());
        }
        return todosEquipamentos;
    }

    public List<Equipamento> filtrarPorStatus(StatusManutencao status) {
        List<Equipamento> equipamentosFiltrados = new ArrayList<>(); // Declara lista dos que passarão pelo filtro

        for (Laboratorio laboratorio : laboratorios) { // for que passa or cada laboratorio
            for (Equipamento equipamento : laboratorio.listarEquipamentos()) { // for que passa por cada equipamento dentro do laboratorio atual
                if (equipamento.getStatusManutencao() == status) { // se for igual o parametro
                    equipamentosFiltrados.add(equipamento); // add na arraylist
                }
            }
        }
        return equipamentosFiltrados; // retorno da arraylist ao final.
    }


public List<Equipamento> filtrarPorCategoria(String categoria) {
    List<Equipamento> encontrados = new ArrayList<>(); // Declara lista dos que passarão pelo filtro

    if (categoria == null || categoria.isBlank()) { // Sem categoria
        return encontrados;
    }

    for (Laboratorio laboratorio : laboratorios) { // Percorre o laboratório
        for (Equipamento equipamento : laboratorio.equipamentos.values()) { // Percorre o equipamento
            if (equipamento.getCategoria() != null && // Categoria não é nula
                equipamento.getCategoria().trim()
                    .equalsIgnoreCase(categoria.trim())) { // Categorias iguais, trim para limpar inpu

                encontrados.add(equipamento); // Adiciona equipamento que atende ao filtro no array
            }
        }
    }

    return encontrados; // Retorna array com os equipamentos da categoria
}
    // ^^^^^^ EQUIPAMENTO ^^^^^^
}


