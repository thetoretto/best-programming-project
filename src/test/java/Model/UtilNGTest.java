/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import dao.GenericDao;
import java.util.HashSet;
import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author root
 */
public class UtilNGTest {
    
    public UtilNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testSomeMethod() {
        PizzaConfig config = new PizzaConfig();
        config.setName("pizza");
        config.setBaseprice(1000.0);
        config.setDelivery(900.0);
        Set<OptionSet> optionsets = new HashSet<>();
        OptionSet optionset = new OptionSet();
        optionset.setName("Meat");
        optionset.setPizzaConfig(config);
        Set<PizzaOption> pizzas = new HashSet<>();
        PizzaOption p1 = new PizzaOption("Beef",100.0);
        p1.setOptionSet(optionset);
        PizzaOption p2 = new PizzaOption("Chicken",150.0);
        p2.setOptionSet(optionset);
        pizzas.add(p1);
        pizzas.add(p2);
        optionset.setOptions(pizzas);
        optionsets.add(optionset);
        config.setOptionSets(optionsets);
        GenericDao<PizzaConfig> dao = new GenericDao<>();
        dao.create(config);
    }
    
}
