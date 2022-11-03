package Veterinario;


import java.time.LocalDate;


public class Rel_clientes_servicos {
        private int idrel_clientes_serviços;

        private  LocalDate dataHoje = LocalDate.now();
        private int idservicos;

        private int idPet;

        private LocalDate dataDoServico = LocalDate.now();

    public Rel_clientes_servicos(int idrel_clientes_serviços, int idservicos, int idPet, int dia, int mes, int ano) {

        this.idrel_clientes_serviços = idrel_clientes_serviços;
        this.idservicos = idservicos;
        this.idPet = idPet;
        this.dataDoServico = LocalDate.of(ano,mes,dia);

    }

    public int getIdrel_clientes_serviços() {
        return idrel_clientes_serviços;
    }

    public void setIdrel_clientes_serviços(int idrel_clientes_serviços) {
        this.idrel_clientes_serviços = idrel_clientes_serviços;
    }

    public int getIdservicos() {
        return idservicos;
    }

    public void setIdservicos(int idservicos) {
        this.idservicos = idservicos;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    @Override
    public String toString() {
        if(dataDoServico.isBefore(dataHoje) ) {
          return "Não foi possivel criar a ordem de Serviço ,Por favor colocar uma data que seja no minimo após da data atual";
        }else{
            return "Rel_clientes_servicos = " +
                    " idrel_clientes_serviços = " + idrel_clientes_serviços +
                    ", idservicos = " + idservicos +
                    ", idPet = " + idPet +
                    ", dataDoServico = " + dataDoServico
                    ;
        }
    }

    public LocalDate getDataDoServico() {
        return dataDoServico;
    }

    public void setDataDoServico(int ano,int mes,int dia) {

        if(LocalDate.of(ano,mes,dia).isBefore(dataHoje) ){
            System.out.println("Por favor colocar uma data que seja no minimo após da data atual");
        }else {
            this.dataDoServico = LocalDate.of(ano,mes,dia);
        }
    }
    public static void main (String[] args){
        Rel_clientes_servicos ordem1 = new Rel_clientes_servicos(1,1,2,10,11,2022);
        System.out.println(ordem1);
    }
}
