package com.hfm.http.request.login.daoimpl;

import com.hfm.http.request.login.entity.User;
import com.hfm.http.request.login.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-02 12:31
 * @Description
 * @date 2021/10/2
 */
public class UserDaoImplTest {
    @Test
    public void testLogin(){
        Connection con = JDBCUtils.getConnectionByDruid();

        UserDAOImpl userDAO = new UserDAOImpl();

        User hfm = userDAO.login(con, "hfm", "17111711");
        System.out.println(hfm.toString());
    }
}
