/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.sd.servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hugo
 */
public class Persistence {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Agenda?user=root&password=mysql");
            return conn;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Agenda findByName(String name) {
        Connection c = getConnection();
        Statement stm;
        Agenda agenda = null;
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name, phone FROM agenda where name = '" + name + "';");
            agenda = new Agenda();
            if (rs.next()) {
                agenda.setName(rs.getString("name"));
                agenda.setPhone(rs.getString("phone"));
            } else {

            }
        } catch (SQLException ex) {
            Logger.getLogger(Persistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agenda;
    }

    public Integer saveAgenda(Agenda agenda) {
        Connection c = getConnection();
        Statement stm;
        try {
            stm = c.createStatement();
            return stm.executeUpdate("INSERT INTO agenda values('" + agenda.getName() + "','" + agenda.getPhone() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(Persistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer deleteAgenda(String name) {
        Connection c = getConnection();
        Statement stm;
        try {
            stm = c.createStatement();
            return stm.executeUpdate("delete from agenda where name = '" + name + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Persistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer updateAgenda(Agenda agenda) {
        Connection c = getConnection();
        Statement stm;
        try {
            stm = c.createStatement();
            return stm.executeUpdate("update agenda set phone = '" + agenda.getPhone() + "' where name ='" + agenda.getName() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Persistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
