import java.util.Scanner;

class RabotnaNedela{

    private int [] casovi;
    private int brNedela;

    public RabotnaNedela(int[] casovi, int brNedela) {
        super();
        this.casovi = casovi;
        this.brNedela = brNedela;
    }

    public int[] getCasovi() {
        return casovi;
    }

    public void setCasovi(int[] casovi) {
        this.casovi = casovi;
    }

    public int getBrNedela() {
        return brNedela;
    }

    public void setBrNedela(int brNedela) {
        this.brNedela = brNedela;
    }

    @Override
    public String toString() {
        return sumCasovi() + " ";
    }

    public int sumCasovi()
    {
        int sum =0;
        for (int i=0; i<5; i++)
        {
            sum += casovi[i];
        }
        return sum;
    }
}

class Rabotnik{

    private String ime;
    private RabotnaNedela [] nedeli;

    public Rabotnik(String ime, RabotnaNedela[] nedeli) {
        super();
        this.ime = ime;
        this.nedeli = nedeli;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public RabotnaNedela[] getNedeli() {
        return nedeli;
    }

    public void setNedeli(RabotnaNedela[] nedeli) {
        this.nedeli = nedeli;
    }

    @Override
    public String toString() {
        String s = new String();
        s = ime + "   ";
        for (int i=0; i<4; i++)
        {
            s += nedeli[i].toString() + "  ";
        }
        s += sumNedela();

        return s;
    }

    public int sumNedela()
    {
        int sum=0;
        for (int i=0; i<4; i++)
        {
            sum += nedeli[i].sumCasovi();
        }
        return sum;
    }
}

public class Main {
    public static int sumNedeli(Rabotnik r)
    {
        return r.sumNedela();
    }
    public static Rabotnik najvreden_rabotnik(Rabotnik [] niza)
    {
        int max =sumNedeli(niza[0]);
        int index=0;
        for(int i=1;i<niza.length;i++)
        {
            if(sumNedeli(niza[i]) > max)
            {
                max = sumNedeli(niza[i]);
                index=i;
            }
        }
        return niza[index];
    }
    public static void table(Rabotnik [] niza)
    {
        System.out.println("Rab   1   2   3   4   Vkupno");
        for(int i=0;i<niza.length;i++)
        {
            System.out.println(niza[i]);
        }

    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Rabotnik [] niza = new Rabotnik[n];
        for(int i=0;i<n;i++)
        {
            RabotnaNedela rn[] = new RabotnaNedela[4];
            String name = input.next();
            for(int k=0;k<4;k++)
            {
                int casovi[] = new int[5];
                for(int j=0;j<5;j++)
                {
                    casovi[j] = input.nextInt();
                }
                rn[k] = new RabotnaNedela(casovi,k+1);
            }

            niza[i] = new Rabotnik(name,rn);
        }

        table(niza);
        System.out.println();
        System.out.println("NAJVREDEN RABOTNIK: " +najvreden_rabotnik(niza).getIme());
    
    }
}
