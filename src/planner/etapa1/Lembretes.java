package planner.etapa1;

public class Lembretes {
   private int id;
   private String titulo;
   private String descricao;
   private String data; 
   
   public Lembretes(){
       
   }

    public Lembretes(int id, String titulo, String descricao, String data) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
      public static String converterParaSQL(String dataAntiga) {
        // Verifica se a entrada está vazia ou nula
        if (dataAntiga == null || dataAntiga.isEmpty()) {
            return null; // Ou lance uma exceção, dependendo do comportamento desejado
        }

        // Verifica se a entrada já está no formato esperado (YYYY-MM-DD)
        if (dataAntiga.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return dataAntiga; // Retorna a data como está
        }

        // Divide a data antiga por "/" e converte para o formato SQL (YYYY-MM-DD)
        String[] partesData = dataAntiga.split("/");
        if (partesData.length != 3) {
            throw new IllegalArgumentException("Formato de data inválido: " + dataAntiga);
        }
        String dataNova = partesData[2] + "-" + partesData[1] + "-" + partesData[0];
        return dataNova;
    }
    public static String converterParaJava(String DataAntiga){
        String[] partesData = DataAntiga.split("-");
        String dataNova = partesData [2] + "/" + partesData[1] + "/" + partesData[0];
        return dataNova;
    }
}



