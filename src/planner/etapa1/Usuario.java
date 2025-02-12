package planner.etapa1;

public class Usuario {    
    private String login;
    private String senha;
    private String nivel;

    public Usuario(){
       
    }           
    
    public Usuario(String login, String senha, String nivel) {       
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }   

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
}
