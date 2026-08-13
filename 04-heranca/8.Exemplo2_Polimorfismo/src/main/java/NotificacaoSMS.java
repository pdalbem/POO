import java.time.LocalDateTime;

public class NotificacaoSMS extends Notificacao{
    private String telefone;

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando notificação para o telefone "+this.telefone);
        //lógica para enviar notificação por SMS
    }

    public NotificacaoSMS(String mensagem, LocalDateTime data, String telefone) {
        super(mensagem, data);
        this.setTelefone(telefone);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
