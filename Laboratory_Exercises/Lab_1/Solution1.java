import java.util.Scanner;

interface IMarathon
{
    Athlete bestTime();
    int AthletesFrom(String s);
}

class Athlete
{
    private String name;
    private String gender;
    private int age;
    private double timeScore;
    private String place;

    public Athlete(){}

    public Athlete(String name, String gender, int age, double timeScore, String place)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.timeScore = timeScore;
        this.place = place;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getTimeScore() {
        return timeScore;
    }
    public void setTimeScore(double timeScore) {
        this.timeScore = timeScore;
    }
    public String getCountry() {
        return place;
    }
    public void setCountry(String country) {
        this.place = country;
    }

    public String toString()
    {
        return name + "\n" + age + "\n" + place + "\n" + timeScore + "\n";
    }
}

class Marathon implements IMarathon
{
    private String country;
    private int year;
    private Athlete []athletes;

    public Marathon(){}

    public Marathon(String country, int year, Athlete[] athletes) {
        this.country = country;
        this.year = year;
        this.athletes = athletes;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Athlete[] getAthletes() {
        return athletes;
    }
    public void setAthletes(Athlete[] athletes) {
        this.athletes = athletes;
    }

    public String toString()
    {
        String s = country + "\n" + year + "\n";
        for (int i=0; i<athletes.length; i++)
        {
            s += athletes[i].toString();
        }
        return s;
    }

    public Athlete bestTime()
    {
        double min = athletes[0].getTimeScore();
        int index=0;
        for(int i=0; i<athletes.length; i++)
        {
            if (athletes[i].getTimeScore() < min)
            {
                index = i;
                min = athletes[i].getTimeScore();
            }
        }
        return athletes[index];
    }

    public int AthletesFrom(String s)
    {
        int counter=0;
        for (int i=0; i<athletes.length; i++)
        {
            if (athletes[i].getCountry().compareTo(s)==0)
            {
                counter++;
            }
        }
        return counter;
    }
}

public class Main
{
    public static void main(String []args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Athlete []athletes = new Athlete[n];

        String name, place, gender;
        int age;
        double time;

        input.nextLine();

        for (int i=0; i<athletes.length; i++)
        {
            name = input.nextLine();
            gender = input.next();
            age = input.nextInt();
            time = input.nextDouble();
            input.nextLine();
            place = input.nextLine();

            athletes[i] = new Athlete(name, gender, age, time, place);
        }

        String country;
        int year;

        country = input.nextLine();
        year = input.nextInt();

        input.nextLine();

        Marathon m1 = new Marathon(country, year, athletes);
        System.out.println(m1.toString());

        String theCountry;
        theCountry = input.nextLine();

        System.out.println("Prvo mesto: " + m1.bestTime().toString());
        System.out.println("Ima vkupno " + m1.AthletesFrom(theCountry) + "atleticar/i od " + theCountry);
    }
}
