/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Words;

/**
 *
 * @author 729347
 */
public class TestDB {
    public List<Words> getValue() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT [Test] FROM [Test].[dbo].[Kyle] GO";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Words> aWord = new ArrayList<>();
        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                aWord.add(new Words(rs.getString("Test")));
            }
            pool.freeConnection(connection);
            return aWord;
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return aWord;
    }
}
