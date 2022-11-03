package Veterinario;

public class PET {
    private int idPet;

    private String nomeDoPet;

    private int Idade;

    private String especie;

    private String raca;

    private int IDcliente;

    public PET(int idPet, String nomeDoPet, int idade, String especie, String raca, int IDcliente) {
        this.idPet = idPet;
        this.nomeDoPet = nomeDoPet;
        Idade = idade;
        this.especie = especie;
        this.raca = raca;
        this.IDcliente = IDcliente;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNomeDoPet() {
        return nomeDoPet;
    }

    public void setNomeDoPet(String nomeDoPet) {
        this.nomeDoPet = nomeDoPet;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(int IDcliente) {
        this.IDcliente = IDcliente;
    }

    @Override
    public String toString() {
        return "PET = " +"idPet=" + idPet +
                ", nomeDoPet = '" + nomeDoPet + '\'' +
                ", Idade = " + Idade +
                ", especie = '" + especie + '\'' +
                ", raca = '" + raca + '\'' +
                ", IDcliente = " + IDcliente ;
    }
}
