public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("José", 2500);
        Funcionario f2 = new Funcionario("José",2500);
        Funcionario f3 = f1;

        if (f1==f2)  //retorna false
            System.out.println("Referências iguais na memória");
        else
            System.out.println("Referências diferentes na memória");

        if (f1==f3)  // agora retorna true, pois apontam para mesmo endereço de memória
            System.out.println("Referências iguais na memória");
        else
            System.out.println("Referências diferentes na memória");

        if (f1.equals(f2)) // retorna true
            System.out.println("Objetos com mesmos valores nos atributos");
        else
            System.out.println("Objetos com valores diferentes nos atributos");

        Gerente g = new Gerente("Maria", 5000,3);
        Vendedor v = new Vendedor("Joaquim", 3000, 20000);

        System.out.println(f1);
        System.out.println(g);
        System.out.println(v);

        System.out.println("\nBônus do funcionário "+f1.getNome()+": "+f1.calcularBonus());
        System.out.println("Bônus do gerente "+g.getNome()+": "+g.calcularBonus());
        System.out.println("Bônus do vendedor "+v.getNome()+": "+v.calcularBonus());
    }
}
