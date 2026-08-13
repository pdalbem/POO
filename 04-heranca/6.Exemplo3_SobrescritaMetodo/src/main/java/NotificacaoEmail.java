import java.time.LocalDateTime;

public class NotificacaoEmail extends Notificacao{
    private String email;

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando notificação para o email "+this.email);
        //lógica para enviar notificação por email
    }

    public NotificacaoEmail(String mensagem, LocalDateTime data, String email) {
        super(mensagem, data);
        this.setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
