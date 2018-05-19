/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Words;
import dataaccess.TestDB;

/**
 *
 * @author 729347
 */
public class TestService {
    TestDB t = new TestDB();
    
    public List<Words> getValue() {
        return t.getValue();
    }
}
