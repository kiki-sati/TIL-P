package com.chang.web;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class DBConnectionTest {
    
    @Inject
    private DataSource ds;
 
    @Test
    public void testConnection(){
    	
        try (Connection con = ds.getConnection()) {
 
            System.out.println("\nDB���� ���� !!\n");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}