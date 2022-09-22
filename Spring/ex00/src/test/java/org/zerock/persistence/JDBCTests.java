package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j
public class JDBCTests {

    @Test
    public void testConnection() throws ClassNotFoundException, SQLException {

        Class clz = Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "book_ex",
                "book_ex");

        log.info(con);

        con.close(); //bad code

        log.info(clz);


    }

}
