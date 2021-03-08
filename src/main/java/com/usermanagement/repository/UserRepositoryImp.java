package com.usermanagement.repository;

import com.usermanagement.exception.*;
import com.usermanagement.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NonUniqueResultException;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null)
            session.delete(user);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userslist = session.createQuery("from User").list();
        return userslist;

    }

    @Override
    public User getUser(String username, String password) {
        //User user = new User();
        String hblQuery = "FROM User user where user.username=:user_name and user.password=:password";
        //String hblQuery = "select U from User U where U.username = ? and U.password=?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hblQuery);
        query.setParameter("user_name", username);
        query.setParameter("password", password);

        List<User> results = query.getResultList();
        if (results.isEmpty())
            return null;
        else if (results.size() == 1)
            return results.get(0);
       throw new NonUniqueResultException("No unique result");

    }

    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User U where U.username =:user_name")
                .setParameter("user_name", username);
        List<User> results = query.getResultList();
        if (results.isEmpty())
            return null;
        else if (results.size() == 1)
            return results.get(0);
        throw new NonUniqueResultException("no user found");

    }

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User U where U.email=:email")
                .setParameter("email",email);
        List<User> results = query.getResultList();
        if (results.isEmpty())
            return null;
        else if (results.size() == 1)
            return results.get(0);

        throw new UserNotFoundException("no user found");

    }

    @Override
    public User findByToken(String resetPasswordToken) throws TokenNotFoundException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User U where U.resetPasswordToken=:reset_password_token")
                .setParameter("reset_password_token",resetPasswordToken);
        List<User> results = query.getResultList();
        if (results.isEmpty())
            return null;
        else if (results.size() == 1)
            return results.get(0);
        throw new TokenNotFoundException("Token not found");


    }

}
