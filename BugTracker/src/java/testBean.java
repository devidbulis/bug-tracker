/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Devid
 */
@Named(value = "testBean")
@RequestScoped
public class testBean {

    /**
     * Creates a new instance of testBean
     */
    public testBean() {
    }
    
}
