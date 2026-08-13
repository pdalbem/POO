import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Notificacao notificacao = new Notificacao("Teste de notificação genérica", LocalDateTime.now());
        NotificacaoEmail notificacaoEmail = new NotificacaoEmail("Teste por e-mail", LocalDateTime.now(), "email@email.com");
        NotificacaoSMS notificacaoSMS = new NotificacaoSMS("Teste por SMS", LocalDateTime.now(), "99999-9999");
        NotificacaoPush notificacaoPush = new NotificacaoPush("Teste por PUSH", LocalDateTime.now(), "smartphone");

        notificacao.enviarNotificacao();
        notificacaoEmail.enviarNotificacao();
        notificacaoSMS.enviarNotificacao();
        notificacaoPush.enviarNotificacao();
    }
}
