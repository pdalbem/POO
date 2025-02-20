public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
    }

    public int calcularDiferenca(Data d){
        return Math.abs(this.ano - d.ano);
        // OU return this.calcularDiferenca(d.ano);
    }

    public int calcularDiferenca(int ano){
        return Math.abs(this.ano - ano);
    }

    public static int compararDatas(Data d1, Data d2){
        // pode-se invocar o metodo compararDatas
        return d1.compararDatas(d2);
        // ou repetir código
        /* if (d1.ano>d2.ano)
                return 1;
                else if (d1.ano<d2.ano)
                    return  -1;
                else if (d1.mes>d2.mes)
                    return 1;
                else if (d1.mes<d2.mes)
                    return -1;
                else if (d1.dia>d2.dia)
                    return 1;
                else if (d1.dia< d2.dia)
                    return -1;
                else return 0;*/


    }

    public int compararDatas(Data d){
        if (this.ano>d.ano)
            return 1;
        else if (this.ano<d.ano)
            return -1;
        else if (this.mes>d.mes)
            return 1;
        else if (this.mes<d.mes)
            return -1;
        else if (this.dia>d.dia)
            return 1;
        else if (this.dia<d.dia)
            return -1;
        else return 0;

    }



    public String formatarData(){
        return this.dia +"/" + this.mes + "/"+ this.ano;
        // ou assim:
        // return  dia + "/" + mes + "/" + ano;
        // ou assim:
        //return  getDia() +"/" + getMes() +"/"+ getAno()

    }


    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
