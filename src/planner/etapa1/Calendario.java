package planner.etapa1;

import java.util.ArrayList;
import java.util.List;


public class Calendario {
    private String data;
    private String lembrete;
    private String importancia;

    public Calendario(String data, String lembrete, String importancia) {
        this.data = data;
        this.lembrete = lembrete;
        this.importancia = importancia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLembrete() {
        return lembrete;
    }

    public void setLembrete(String lembrete) {
        this.lembrete = lembrete;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }
       
}
