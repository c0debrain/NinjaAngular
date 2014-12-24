package testClient;

import com.google.inject.Inject;
import com.iffcoder.models.User;
import com.iffcoder.services.UserServiceImpl;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by guoliangwang on 12/23/14.
 */
public class RegisterUser {


    private static UserServiceImpl userService = new UserServiceImpl();

    public static void main(String[] args) {

        User user = new User();
        user.setEmail("ivytony@gmail.com");
        user.setPassword("ivytony");
        user.setRegisterDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        user.setUserProfile(null);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();

        session.close();

//        userService.addUser(user);

    }
}
