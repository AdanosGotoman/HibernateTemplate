package Utils;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class SessionFactory
{
    public SessionFactory Configure()
    {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return (SessionFactory) new Configuration().configure().buildSessionFactory();
    }
}
