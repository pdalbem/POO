public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("ABC1234","VW","Amarok", 2020);
        Carro carro2 = new Carro("XYZ5678", "Jeep", "Compass");


        Carro[] arrayCarros = new Carro[3];
        arrayCarros[0]=carro1;
        arrayCarros[1]=carro2;
        arrayCarros[2] = new Carro("IFS1P90", "Renault","Kwid", 2024);

        //declarar e inicializar o array
        Carro[] arrayCarros2 = {carro1,carro2}; //definido automaticamente pela JVM com tamanho 2

        //percorrendo o array usando o for aprimorado
        for (Carro c: arrayCarros) {
            System.out.println(c.getPlaca());
            System.out.println(c.getMarca());
            System.out.println(c.getAnoFabricacao());
        }

    }
}
