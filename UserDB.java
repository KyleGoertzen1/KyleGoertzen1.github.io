package dataaccess;

import dataaccess.ConnectionPool;
import domainmodel.Note;
import domainmodel.Post;
import domainmodel.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class UserDB {
    
    public List<Post> getStory() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Story;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Post> posts = new ArrayList<>();

        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                posts.add(new Post(rs.getString("story")));
            }
            pool.freeConnection(connection);
            return posts;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return posts;
    }

    public User getEmail(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT email FROM User WHERE email = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("email"));
            }
            pool.freeConnection(connection);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user;
    }

    public String getUserByEmail(String email, String arg) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE email = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("username"));
            }
            pool.freeConnection(connection);
            return "";
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return "";
    }

    public String getPassByEmail(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE email = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("password"));
            }
            pool.freeConnection(connection);
            return "";
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return "";
    }

    public int getCompanyByUsername(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE username = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getInt("company"), rs.getString("username"));
            }
            pool.freeConnection(connection);
            return user.getCompany();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user.getCompany();
    }

    public List<User> getAdmin() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getBoolean("active"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("role"), rs.getInt("company")));
            }
            pool.freeConnection(connection);
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return users;
    }

    public User getUser(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE username = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("username"));
            }
            pool.freeConnection(connection);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user;
    }

    public String getOwnerByID(int noteID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Note WHERE noteID = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Note note = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, noteID);
            rs = ps.executeQuery();

            while (rs.next()) {
                note = new Note(rs.getString("owner"));
            }
            pool.freeConnection(connection);
            return note.getOwner();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return note.getOwner();
    }

    public int insert(Note note) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedQuery = "INSERT INTO Note (dateCreated, title, contents, owner) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setDate(1, (java.sql.Date) note.getDateCreated());
            System.out.println(note.getTitle());
            ps.setString(2, note.getTitle());
            ps.setString(3, note.getContents());
            User user = new User();
            System.out.println(user.getUsername());

            ps.setString(4, note.getOwner());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + note.toString(), ex);
            //throw new NotesDBException("Error inserting user");
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }

    public int update(Note note) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedSQL = "UPDATE Note SET "
                + "title = ?, contents = ? WHERE noteId=" + note.getNoteID() + ";";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContents());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot delete " + note.toString(), ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }

    public String stop(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedSQL = "UPDATE User SET active = ? WHERE username = ?;";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setBoolean(1, user.getActive());
            ps.setString(2, user.getUsername());
            int rows = ps.executeUpdate();
            return "";
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot delete " + user.toString(), ex);
        } finally {
            pool.freeConnection(connection);
        }
        return "";
    }

    //newUsername, newPass, newEmail, makeActive, newFirstname, newLastname, newRole
    public String update(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedSQL = "UPDATE User SET "
                + "password = ?, email = ?, active = ?, firstname = ?, lastname = ?, role = ?, company = ?"
                + " WHERE username ='" + user.getUsername() + "';";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setBoolean(3, user.getActive());
            ps.setString(4, user.getFirstname());
            ps.setString(5, user.getLastname());
            ps.setInt(6, user.getRole());
            ps.setInt(7, user.getCompany());
            //ps.setString(8, user.getUsername());
            int rows = ps.executeUpdate();
            return user.getUsername();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot delete " + user.toString(), ex);
        } finally {
            pool.freeConnection(connection);
        }
        return user.getUsername();
    }

//    public int update(Note note) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//
//        try {
//            String preparedSQL = "UPDATE Note SET "
//                    + "contents = ? WHERE noteID=" + note.getNoteID() + ";";
//
//            PreparedStatement ps = connection.prepareStatement(preparedSQL);
//
//            //ps.setInt(1, note.getNoteId());
//            ps.setString(1, note.getContents());
//
//            int rows = ps.executeUpdate();
//            return rows;
//        } catch (SQLException ex) {
//            Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, "Cannot update " + note.toString(), ex);
//        } finally {
//            pool.freeConnection(connection);
//        }
//        return 0;
//    }
    public String delete(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedQuery = "DELETE FROM User WHERE username = ?;";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, user.getUsername());
            int rows = ps.executeUpdate();
            return user.getUsername();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot delete " + user.toString(), ex);
        } finally {
            pool.freeConnection(connection);
        }
        return user.getUsername();
    }

    public int delete(Note note) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedQuery = "DELETE FROM Note WHERE noteId = ?;";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(preparedQuery);
            ps.setInt(1, note.getNoteID());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot delete " + note.toString(), ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }

    public Note getNoteID(int noteID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Note WHERE noteID = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Note note = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, noteID);
            rs = ps.executeQuery();

            while (rs.next()) {
                note = new Note(rs.getInt("noteID"));
            }
            pool.freeConnection(connection);
            return note;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return note;
    }

    public Note getTitle(String title) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Note WHERE title = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Note note = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, title);
            rs = ps.executeQuery();

            while (rs.next()) {
                note = new Note(rs.getString("title"));
            }
            pool.freeConnection(connection);
            return note;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return note;
    }

    public boolean getActive(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Note WHERE username = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getInt("active"));
            }
            pool.freeConnection(connection);
            return user.getActive();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user.getActive();
    }

    public List<User> getAllUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getBoolean("active"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("role"), rs.getInt("company")));
            }
            pool.freeConnection(connection);
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return users;
    }

    public List<Note> getAllNotes() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Note;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Note> notes = new ArrayList<>();

        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                notes.add(new Note(rs.getInt("noteID"), rs.getDate("dateCreated"), rs.getString("title"), rs.getString("contents"), rs.getString("owner")));
            }
            pool.freeConnection(connection);
            return notes;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return notes;
    }

    public String getPassword(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE username = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("password"));
            }
            pool.freeConnection(connection);
            return user.getPassword();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user.getPassword();
    }

    public String getUsernameDB(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE username = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("username"));
            }
            pool.freeConnection(connection);
            return user.getUsername();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user.getUsername();
    }

    public User getUsername(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE username = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getBoolean("active"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("role"), rs.getInt("company"));
            }
            pool.freeConnection(connection);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user;
    }

    public User getRole(String username) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT role FROM User WHERE username = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getInt("role"));
            }
            pool.freeConnection(connection);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user;
    }

    public User getCompany(int company) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE company = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, company);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getInt("company"));
            }
            pool.freeConnection(connection);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user;
    }

    public Note getOwner(String owner) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Note WHERE owner = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Note note = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, owner);
            rs = ps.executeQuery();

            while (rs.next()) {
                note = new Note(rs.getString("owner"));
            }
            pool.freeConnection(connection);
            return note;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return note;
    }

    public Note getByNoteId(int noteId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Note WHERE noteId = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Note note = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, noteId);
            rs = ps.executeQuery();

            while (rs.next()) {
                note = new Note(rs.getString("title"), rs.getString("contents"));
            }
            pool.freeConnection(connection);
            return note;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return note;
    }

    public User insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedQuery = "INSERT INTO User (username, password, email, active, firstname, lastname, role, company) VALUES  (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setBoolean(4, user.getActive());
            ps.setString(5, user.getFirstname());
            ps.setString(6, user.getLastname());
            ps.setInt(7, user.getRole());
            ps.setInt(8, user.getCompany());
            ps.executeUpdate();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), ex);
            //throw new NotesDBException("Error inserting user");
        } finally {
            pool.freeConnection(connection);
        }
        return user;
    }

    public Note deleteByNoteID(int noteID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM Note WHERE noteID = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Note note = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, noteID);
            rs = ps.executeQuery();

            while (rs.next()) {
                note = new Note(rs.getInt("noteID"));
            }
            pool.freeConnection(connection);
            return note;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return note;
    }

}
