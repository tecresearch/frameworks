package in.tecresearch;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Application started...");
        new Configuration().configure("/config/hibernate.cfg.xml").buildSessionFactory();
    }
}
