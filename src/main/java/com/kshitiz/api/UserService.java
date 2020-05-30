package com.kshitiz.api;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class UserService {

    private static Logger LOG = Logger.getLogger(UserService.class.getName());

    @Inject
    UserDao userDao;

    public void batchJob(int startId, int endId) {
        List<User> users = userDao.getByIdRange(startId, endId);
        users.forEach(user -> {
            user.setEmail("changed@gmail.com");
            userDao.edit(user);
        });
    }

    public void insertUsers() {
        LOG.info("Mediator will save");
        Date startDate = new Date();
        for (int i = 1; i < 10000; i++) {
            User u = new User();
            u.setName("kshitiz gupta" + i);
            u.setEmail("kshgupta.19.05.88@gmail.com");
            userDao.save(u);
        }

        Date endDate = new Date();
        LOG.info("Saved in" + (endDate.getTime() - startDate.getTime()));
    }

}
