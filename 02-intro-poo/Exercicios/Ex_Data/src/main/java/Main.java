public class Main {
    public static void main(String[] args) {

        Data data1 = new Data(20,2,2025);
        System.out.println("Data: "+ data1.formatarData());

        Data data2 = new Data(10,10,2020);

        // sem usar o metodo static
       // int result = data1.compararDatas(data2);

        //usando o metodo static
        int result = Data.compararDatas(data1,data2);
        if (result==1)
            System.out.println("Maior data: "+ data1.formatarData());
        else if (result==-1)
            System.out.println("Maior data: "+ data2.formatarData());
        else System.out.println("Datas iguais");

        System.out.println(data1.calcularDiferenca(data2));
        System.out.println(data1.calcularDiferenca(2030));

    }
}