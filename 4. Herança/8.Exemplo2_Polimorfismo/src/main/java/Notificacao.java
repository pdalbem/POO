import java.time.LocalDateTime;

public class Notificacao {
    private String mensagem;
    private LocalDateTime data;

    public void enviarNotificacao(){
        System.out.println("Enviando notificação genérica: "+ mensagem);
    }

    public Notificacao(String mensagem, LocalDateTime data) {
        this.setMensagem(mensagem);
        this.setData(data);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
