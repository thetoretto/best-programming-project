/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDrive;

import Model.Util;

/**
 *
 * @author root
 */
public class TestClass {
  
    public static void main(String[] args) {
        System.out.print("starts");
         Util.sessionFactory.openSession();
    }

}
