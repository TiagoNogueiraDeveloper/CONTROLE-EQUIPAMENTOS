// package PROJETOINOO;

public class Computador extends Equipamento {
    private String processador;
    private int capacidadeMemoria; 
    private double DepreciacaoAnual = 0.20; // Depreciação anual de 20%

    public Computador(String codigoPatrimonio, String descricao, double valor, int anoAquisicao, StatusManutencao statusManutencao, String processador, int capacidadeMemoria) {
        super(codigoPatrimonio, descricao, valor, anoAquisicao, statusManutencao);
        this.processador = processador;
        this.capacidadeMemoria = capacidadeMemoria;
    }

    public String getProcessador() {
        return processador;
    }
    public int getCapacidadeMemoria() {
        return capacidadeMemoria;
    }
    public double getDepreciacaoAnual() {
        return DepreciacaoAnual;
    }
    public double calcularDepreciacaoAnual(){
        return getValor() * DepreciacaoAnual;
    }
    public String getCategoria(){
        return "Computador";
    }
}
