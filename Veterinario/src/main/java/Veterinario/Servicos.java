package Veterinario;

import org.w3c.dom.ls.LSOutput;

public class Servicos {
      private int idServico;

      private String servico;

      private double preco;

      public Servicos(int idServico, String servico, double preco) {
            this.idServico = idServico;
            this.servico = servico;
            if(preco  > 0 ) {
                  this.preco = preco;
            }
      }

      public int getIdServico() {
            return idServico;
      }

      public void setIdServico(int idServico) {
            this.idServico = idServico;
      }

      public String getServico() {
            return servico;
      }

      public void setServico(String servico) {
            this.servico = servico;
      }

      public double getPreco() {
            return preco;
      }

      public void setPreco(double preco) {
            if(preco  > 0 ){
                  this.preco = preco;
            }else {
                  System.out.println("Por favor entrar com um valor válido"); ;
            }
      }

      @Override
      public String toString() {
            if(preco  > 0 ){
               return " servicos = " +
                          " idServico = " + idServico +
                          ", servico = '" + servico + '\'' +
                          ", preco = " + preco ;
            }else {
                  return "Por favor entrar com um valor válido";
            }

      }
      public static void main (String[] args) {
            Servicos s1 = new Servicos(1, "Lavagem", 0.00);
            System.out.println(s1);
      }
}
