import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Laboratorio {
    private String nome;
    Map<String, Equipamento> equipamentos = new TreeMap<>();


    public Laboratorio(String nome) {
        this.nome = nome;
    }


    public boolean adicionar(Equipamento e){
        if (equipamentos.containsKey(e.getCodigoPatrimonio())) {
            return false;  
        } else {
            equipamentos.put(e.getCodigoPatrimonio(), e);
            return true;
        }
    }

    public Equipamento remover(String codigo){
        if (!equipamentos.containsKey(codigo)) {
            return null;  
        } else {  
            return equipamentos.remove(codigo); 
        }   
    }

    public Equipamento buscar(String codigo){
        if (!equipamentos.containsKey(codigo)) {
            return null;  
        } else {  
            return equipamentos.get(codigo);
        }   
    }

    public List<Equipamento> listarEquipamentos(){
        return List.copyOf(equipamentos.values());        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
