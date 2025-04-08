import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Notificacao notificacaoGenerica = new Notificacao("Teste de notificação genérica", LocalDateTime.now());
        Notificacao notificacaoEmail = new NotificacaoEmail("Teste por e-mail", LocalDateTime.now(), "email@email.com");
        Notificacao notificacaoSMS = new NotificacaoSMS("Teste por SMS", LocalDateTime.now(), "99999-9999");
        Notificacao notificacaoPush = new NotificacaoPush("Teste por PUSH", LocalDateTime.now(), "smartphone");

        notificar(notificacaoGenerica);
        notificar(notificacaoEmail);
        notificar(notificacaoSMS);
        notificar(notificacaoPush);
    }

    public static void notificar(Notificacao notificacao){
        notificacao.enviarNotificacao();
    }
}
