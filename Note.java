/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 729347
 */
public class Note implements Serializable {

    private int noteID;
    private Date dateCreated;
    private String title;
    private String contents;
    private String owner;

    public Note() {
    }
    
    public Note(String owner) {
        this.owner = owner;
    }

    public Note(int noteID, Date dateCreated, String title, String contents, String owner) {
        this.noteID = noteID;
        this.dateCreated = dateCreated;
        this.title = title;
        this.contents = contents;
        this.owner = owner;
    }
    public Note(Date dateCreated, String title, String contents, String owner) {
        this.dateCreated = dateCreated;
        this.title = title;
        this.contents = contents;
        this.owner = owner;
    }

//    public Note(String title) {
//        this.title = title;
//    }

    public Note(int noteID) {
        this.noteID = noteID;
    }

    public Note(String owner, int a) {
        this.owner = owner;
    }

    public Note(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Note(int noteID, String title, String contents) {
        this.noteID = noteID;
        this.title = title;
        this.contents = contents;

    }

    public int getNoteID() {
        return noteID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getOwner() {
        return owner;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
