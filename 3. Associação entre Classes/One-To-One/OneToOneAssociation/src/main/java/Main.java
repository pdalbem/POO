public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Maria", "11122233344");
        Conta conta = new Conta("1010", 1000.00);

        //associação entre pessoa e conta
        pessoa.setConta(conta);
        conta.setProprietario(pessoa);
        
        //Mostra o saldo da conta de Maria
        System.out.println(pessoa.getConta().getSaldo());

        //Mostra quem é o proprietario da conta num 1010
        System.out.println(conta.getProprietario().getNome());
    }
}
