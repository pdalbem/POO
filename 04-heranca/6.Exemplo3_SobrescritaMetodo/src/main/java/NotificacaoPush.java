import java.time.LocalDateTime;

public class NotificacaoPush extends Notificacao{
    private String dispositivo;

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando notificação para o dispositivo "+this.dispositivo);
        //lógica para enviar notificação PUSH
    }

    public NotificacaoPush(String mensagem, LocalDateTime data, String dispositivo) {
        super(mensagem, data);
        this.setDispositivo(dispositivo);
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
}
