import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

       int diaSemana = 3;
  ;
        switch (diaSemana) {
            case 1: {
                System.out.println("Segunda-feira");
                break;
            }
            case 2:
                System.out.println("Terça-feira");
                break;
            case 3:
                System.out.println("Quarta-feira");
                break;
            case 4:
                System.out.println("Quinta-feira");
                break;
            case 5:
                System.out.println("Sexta-feira");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Dia inválido");
                break;
        }

        //Outro exemplo
        int mes = 2;
        switch (mes){
            case 1: {
                System.out.println("Janeiro");
                break;
            }
            case 2: {
                System.out.println("Fevereiro");
                break;
            }
            case 3: {
                System.out.println("Março");
                break;
            }
            case 4: {
                System.out.println("Abril");
                break;
            }
            case 5: {
                System.out.println("Maio");
                break;
            }
            case 6: {
                System.out.println("Junho");
                break;
            }
            case 7: {
                System.out.println("Julho");
                break;
            }
            case 8: {
                System.out.println("Agosto");
                break;
            }
            case 9: {
                System.out.println("Setembro");
                break;
            }
            case 10: {
                System.out.println("Outubro");
                break;
            }
            case 11: {
                System.out.println("Novembro");
                break;
            }
            case 12: {
                System.out.println("Dezembro");
                break;
            }
            default: {
                System.out.println("Inválido");
            }
        }


        //Exemplos do SWITCH para o Java 21

        LocalDate date = LocalDate.now();

        switch (date.getDayOfWeek()) {
            case MONDAY -> System.out.println("It is Monday");
            case TUESDAY -> System.out.println("It is Tuesday");
            case WEDNESDAY -> System.out.println("It is Wednesday");
            case THURSDAY -> System.out.println("It is Thursday");
            case FRIDAY -> System.out.println("It is Friday");
            case SATURDAY -> System.out.println("It is Saturday");
            case SUNDAY -> System.out.println("It is Sunday");
        }

        final String dayAsString = switch (date.getDayOfWeek()) {
            case MONDAY -> "It is Monday";
            case TUESDAY -> "It is Tuesday";
            case WEDNESDAY -> "It is Wednesday";
            case THURSDAY -> "It is Thursday";
            case FRIDAY -> "It is Friday";
            case SATURDAY -> "It is Saturday";
            case SUNDAY -> "It is Sunday";
        };
        System.out.println(dayAsString);

        int numLetters = 0;
        switch (date.getDayOfWeek()) {
            case MONDAY: case FRIDAY: case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
        }
        System.out.println(numLetters);

        System.out.println(switch (date.getDayOfWeek()) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY -> 8;
            case WEDNESDAY -> 9;
            default -> 0;
        });



    }
}