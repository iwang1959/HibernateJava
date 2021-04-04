package com.control;

import com.to.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.Player;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateMain {

    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration().configure("META-INF/hibernate.cfg.xml");
            configuration.addAnnotatedClass(Player.class);
            configuration.addAnnotatedClass(com.to.Team.class);
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory factory = configuration.buildSessionFactory(builder.build());

            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            //Player p1 = new Player(10, "Amit", "India", 30);
            //Player p2 = new Player(20, "Ivan", "China", 18);
            //session.save(p1);
            //session.save(p2);

            //Player p = session.get(Player.class, 20);
            //System.out.println("The Details: " + p);
            //p.setAge(40);
            //p.setPlayerName("David");
            //session.delete(p);
            //Player p1 = new Player("Nmae", "India", 30);
            //Player p2 = new Player("Name", "India", 20);
            //session.save(p1);
            //session.save(p2);

            //Query query = session.createQuery("from Player where age between :age1 and :age2 order by playerName desc");
            //query.setParameter("age1", 1);
            //query.setParameter("age2", 4);
            //List<Player> playerList = query.list();
            //System.out.println("Player Details");
            //for(Player p:playerList){
             //   System.out.println(p);
            //}

            Team t1 = new Team("India");
            Team t2 = new Team("Delhi");
            Team t3 = new Team("Japan");

            Player p = new Player();
            p.setAge(28);
            p.setPlayerName("Virat Kolhi");
            p.getTeamList().add(t1);
            p.getTeamList().add(t2);
            p.getTeamList().add(t3);

            session.save(t1);
            session.save(t2);
            session.save(t3);
            session.save(p);


            transaction.commit();
            session.close();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

}
