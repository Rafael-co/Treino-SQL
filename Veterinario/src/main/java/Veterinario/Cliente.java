package Veterinario;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLOutput;

// IDcliente INTEGER PRIMARY KEY AUTO_INCREMENT,
// nomeCliente VARCHAR(50) NOT NULL,
// idade INTEGER NOT NULL,
// email VARCHAR(50) NOT NULL UNIQUE,
// telefone INTEGER NOT NULL
public class Cliente {
    private int IDcliente;

    private String nomeCliente;

    private int idade;

    private String email;

    private int telefone;

    public Cliente(int IDcliente, String nomeCliente, int idade, String email, int telefone) {
        this.IDcliente = IDcliente;
        this.nomeCliente = nomeCliente;
        if (idade<130){
        this.idade = idade;
        }

        if (email.contains("@")){
        this.email = email;
        }
        this.telefone = telefone;
    }

    public int getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(int IDcliente) {
        this.IDcliente = IDcliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade<130){
            this.idade = idade;
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        if (email.contains("@")) {
            this.email = email;
        }else {
            System.out.println("Por favor colocar uma email Válido");
        }
    }

    public int getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        if (this.idade <= 0|| this.email == null ) {
            return "objeto nao criado, favor inserir idade ou (e) um email  valido";
        } else {
            return "Cliente = " +
                    " IDcliente = " + IDcliente +
                    ", nomeCliente = '" + nomeCliente + '\'' +
                    ", idade = " + idade +
                    ", email = '" + email + '\'' +
                    ", telefone = " + telefone ;
        }
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public static void main (String[] args){
        Cliente c1 = new Cliente(1,"Rafael",70,"rafael.camilooutlook.com",11945689);
        System.out.println(c1);
        c1.setIdade(150);
}
}
