import java.util.Scanner;

abstract class Trip
{
    private String agency;
    protected int price;

    public Trip(String agency, int price)
    {
        this.agency = agency;
        this.price = price;
    }

    public Trip(){}

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    //public abstract int getPrice(); //the price getter will be abstract because it will change in the subclass

    int getPrice()
    {
        return  price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract int vratiVremeVoDenovi();

    public static int minPrice(Trip []array, int n, Trip compare)
    {
        int rez = 0;
        for (int i=0; i<n; i++)
        {
            if (array[i].vratiVremeVoDenovi() > compare.vratiVremeVoDenovi())
            {
                if (array[i].getPrice() < rez)
                {
                    rez = array[i].getPrice();
                }
                if (rez == 0)
                {
                    rez = array[i].getPrice();
                }
            }
        }
        return rez;
    }

}

class Vacation extends Trip
{
    private int duration; //total days in vacation

    public Vacation(String agency, int price, int duration)
    {
        super(agency, price);
        this.duration = duration;
    }

    public Vacation() {super();}

    public Vacation(int duration)
    {
        super();
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice()
    {
        return price-1000; //the price is 1000den cheaper in Vacation subclass
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int vratiVremeVoDenovi()
    {
        return this.duration; //returns the total days
    }
}

class FestiveTrip extends Trip
{
    private int startDay, startMonth, endDay, endMonth;

    public FestiveTrip(String agency, int price, int startDay, int startMonth, int endDay, int endMonth)
    {
        super(agency, price);
        try
        {
            if (startMonth > endMonth)
            {
                throw new Exception();
            }
            else if (startMonth == endMonth)
            {
                if (startDay > endDay)
                {
                    throw new Exception();
                }
            }
            this.startDay = startDay;
            this.startMonth = startMonth;
            this.endDay = endDay;
            this.endMonth = endMonth;
        }
        catch(Exception e)
        {
            this.startDay = startDay;
            this.startMonth = startMonth;
            this.endDay = endDay;
            this.endMonth = endMonth;

            System.out.println("Iskluchok");
        }
    }

    public FestiveTrip(int startDay, int startMonth, int endDay, int endMonth) {
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.endDay = endDay;
        this.endMonth = endMonth;
    }

    public FestiveTrip(){super();}

    //calculates the time in days
    public int vratiVremeVoDenovi()
    {
        int result;
        if (startMonth == endMonth)
        {
            result = endDay - startDay;
        }
        else
        {
            result = (endMonth - startMonth - 1) * 30 + 30 - startDay + endDay;
        }
        return result;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }
}

public class Main
{
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        Trip []arrayTrip = new Trip[n];

        for (int i=0; i<n; i++)
        {
            int tip = in.nextInt();
            if (tip == 0)
            {
                String name = in.next();
                int price = in.nextInt();
                int days = in.nextInt();

                arrayTrip[i] = new Vacation(name, price, days);
            }
            else
            {
                String name = in.next();
                int price = in.nextInt();
                int sDay = in.nextInt();
                int sMonth = in.nextInt();
                int eDay = in.nextInt();
                int eMonth = in.nextInt();

                arrayTrip[i] = new FestiveTrip(name, price, sDay, sMonth, eDay, eMonth);
            }
        }

        //Requirement 1
        String total = new String();
        for (int i=0; i<n; i++)
        {
            FestiveTrip fp = new FestiveTrip();
            if (arrayTrip[i] instanceof FestiveTrip)
            {
                fp = (FestiveTrip) arrayTrip[i];
                if (fp.getStartMonth()==6 && !total.contains(fp.getAgency()))
                {
                    total = total + fp.getAgency()+" ";
                }
            }
        }
        System.out.println(total);

        //Requirement 2
        double avg=0.0;
        for (int i=0; i<n; i++)
        {
            avg += arrayTrip[i].vratiVremeVoDenovi(); //calculates the average duration
        }
        System.out.printf("%.1f\n", avg/n); //rounds it to 1 decimal place

        //Requirement 3
        String name = in.next();
        int price = in.nextInt();
        int time = in.nextInt();
        Vacation vacay = new Vacation(name, price, time);

        //Requirement 4
        System.out.println(Trip.minPrice(arrayTrip, n, vacay));


    }
}
