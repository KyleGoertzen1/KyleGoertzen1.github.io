/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import dataaccess.UserDB;
import domainmodel.Note;
import domainmodel.Post;
import domainmodel.User;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 729347
 */
public class TutorialService {

    UserDB userDB = new UserDB();
    
    public List<Post> getStory() {
        return userDB.getStory();
    }

    public String getUserByEmail(String email, String arg) {
        return userDB.getUserByEmail(email, "work");
    }

    public String getPassByEmail(String email) {
        return userDB.getPassByEmail(email);
    }

    public int getCompany(String username) {
        return userDB.getCompanyByUsername(username);
    }

    public String getOwnerByID(int noteID) {
        return userDB.getOwnerByID(noteID);
    }

    public String changeInfo(String username, String password, String email, boolean active, String firstname, String lastname, int role, int company) throws SQLException {
        User user = userDB.getUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(active);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRole(role);
        user.setCompany(company);
        return userDB.update(user);
    }

    public String stopAccount(String username, int deactive) {
        User user = userDB.getUsername(username);
        user.setActive(false);
        return userDB.stop(user);
    }

    public int update(int noteID, String title, String contents) {
        Note note = new Note(noteID, title, contents);
        return userDB.update(note);
    }

    public String update(String username, String password, String email, boolean active, String firstname, String lastname, int role, int company) {
        User user = userDB.getUser(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(true);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRole(role);
        return userDB.update(user);
    }

    public int delete(int noteID) throws Exception {
        Note note = new Note();
        note.setNoteID(noteID);
        return userDB.delete(note);
    }

    public String delete(String username) throws Exception {
        User user = new User();
        user.setUsername(username);
        return userDB.delete(user);
    }

    public List<Note> getNotes() throws Exception {
        return userDB.getAllNotes();
    }

    public List<User> getUsers() throws Exception {
        return userDB.getAllUsers();
    }

    public List<User> getAdmin() throws Exception {
        return userDB.getAdmin();
    }

    public Note getTitle(String title) throws Exception {
        return userDB.getTitle(title);
    }

    public Note getNoteID(int noteId) throws Exception {
        return userDB.getByNoteId(noteId);
    }

    public Note deleteByNoteID(int noteId) throws Exception {
        return userDB.deleteByNoteID(noteId);
    }

    public User getUsername(String username) {
        return userDB.getUsername(username);
    }

    public String getPassword(String username) {
        return userDB.getPassword(username);
    }

    public String getUsernameDB(String username) {
        return userDB.getUsernameDB(username);
    }

    public Note getOwner(String owner) throws SQLException {
        return userDB.getOwner(owner);
    }

    public User getUsersRole(String username) throws SQLException {
        return userDB.getRole(username);
    }

    public User insert(String username, String password, String email, boolean active, String firstname, String lastname, int role, int company) {
        User user = new User(username, password, email, active, firstname, lastname, role, company);

        return userDB.insert(user);
    }

    public int insert(Date date, String title, String contents, String owner) throws SQLException {
        Note note = new Note(0, date, title, contents, owner);

        return userDB.insert(note);
    }

}
