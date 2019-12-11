/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDrive;

import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.OptionSet;
import Model.PizzaConfig;
import Model.PizzaOption;
import dao.GenericDao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author root
 */
public class TestDrive {

  StringBuilder build = new StringBuilder();
   
    public static void main(String[] args) {

         //calling menue method
        new TestDrive().menue();

    }
    
  PizzaConfig pizzaConfig = new PizzaConfig();
    Set<OptionSet> optionSets = new HashSet<>();
    //List<PizzaOption> pizzaOptions =new ArrayList<>();
    PizzaOption pizzaOption =new PizzaOption();
    OptionSet optionSet=new OptionSet();
    GenericDao<OptionSet> gdOs=new GenericDao<>();
    GenericDao<PizzaConfig>gdpizzaCon=new GenericDao<>();
    GenericDao<PizzaOption> gdpizzaOpt=new GenericDao<>();
 
    public void menue() {
        System.out.println("WElCome To MoreIsh Pizza Restaurent\n");
        double totalPrice =0.0;
        int count = 0;
                Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Pizza Name You want here:");
        
        String selected = scanner.nextLine();
        pizzaConfig.setName(selected );
        System.out.println("Thanks for selecting: " + pizzaConfig.getName());
        System.out.println("What  size of " + pizzaConfig.getName() + " Would you like? \n");
        System.out.println("Press 1: for Large =4500Rwf\n");
        System.out.println("Press 2: for Medium =3000Rwf\n");
        System.out.println("Press 3: for Small =1000Rwf\n");
        double price=0.0;
        int size = scanner.nextInt();

        switch (size) {
            case 1:
                pizzaConfig.setPizzaSize("Large");
                pizzaConfig.setBaseprice(4500);
                price=4500;
                break;

            case 2:
                pizzaConfig.setPizzaSize("Medium");
                pizzaConfig.setBaseprice(3000);
                price=3000;
                break;

            case 3:
                pizzaConfig.setPizzaSize("Small");
                pizzaConfig.setBaseprice(1000);
                price=1000;
  
        }


        //Delivery or east-in checking
        boolean terminate = false;
        while(!terminate){
        System.out.println("Do you want it to be Delivered? \n Enter YES or NO"+ " :"+"There is Charges for Derivering: 1000rwf" );
        String delivery = scanner.next();

        if (delivery.toUpperCase().equals("YES")) {
              
            totalPrice = price+1000;
            double amount =1000;
            pizzaConfig.setDelivery(amount);
           System.out.println("Total Price is: "+totalPrice);
           terminate =true;
        }

        else if (delivery.toUpperCase().equals("NO")) {
         
            totalPrice = price;
            double amount =0.0;
            System.out.println("TotalPrice is : "+totalPrice);
            pizzaConfig.setDelivery(amount);
            terminate =true;
        }else{
            System.err.println("No match.");
            terminate = false;
        }
        }
        
        //Calling optionSet
        meatOrVegetableOptionSet(pizzaConfig,totalPrice);
    }

    public void meatOrVegetableOptionSet(PizzaConfig config,double totalPrice) {

        boolean terminated = false;
        Scanner scan = new Scanner(System.in);

        String category = "";

        while (!terminated) {

            System.out.println("Press 1 For Meat.  Press 2 For Vegetable");

            switch (scan.nextInt()) {

                case 1:
                    //String[] meatChoosen = meat();
                    Set<PizzaOption> pizzaOptions = meat(optionSet);
                    category = "meat";
                    terminated = true;
                   //pizzaOption.setName(category);
                  //pizzaOptions.add(pizzaOption);
                    optionSet.setName(category);
                  optionSet.setOptions(pizzaOptions);
                  optionSet.setPizzaConfig(config);
                  //optionSets.add(pizzaOptions);
                   
                    pizzaConfig.setOptionSets(optionSets);
                    gdpizzaCon.create(pizzaConfig);
                    gdOs.create(optionSet);
                    break;
                    //oset[iset]=config.getDelivery();
                case 2:
                    Set<PizzaOption> pizzaOptionVeg = vegetable();
                    category = "vegetable";
                    terminated = true;
                    //pizzaOption.setName(category);
                    //pizzaOptionVeg.add(pizzaOption);
                    optionSet.setName(category);
                    optionSet.setOptions(pizzaOptionVeg);
                    pizzaConfig.setOptionSets(optionSets);
                    gdpizzaCon.create(pizzaConfig);
                    gdOs.create(optionSet);
                    
                    //gdpizzaOpt.create(pizzaOption);
                    break;
                    
                    //config.setOptionsets(category,vegetableChoosen, totalPrice);
                    
                    //Here we call requestedOrdering method to dispay pizza requested by customer 
               
            }
            requestedOrdering();

        }
    }

    // Method for MeatOptions
    public Set<PizzaOption> meat(OptionSet optionSet) {
        PizzaOption meOption = new PizzaOption();
       Set<PizzaOption> sets = new HashSet<>();
        boolean terminated = false;

        Scanner scan = new Scanner(System.in);

        while (!terminated) {
            System.out.println("Press 1 For Beef. 2 For Peperoni. 3 For Anchovy. Press 4 For Ham . Press 5 -> go To Terminate");
            switch (scan.nextInt()) {
                case 1:
                    PizzaOption meOptionBeef = new PizzaOption();
                    meOptionBeef.setName("Beef");
                    meOptionBeef.setOptionSet(optionSet);
                    sets.add(meOptionBeef);
                    build.append("Beef").append(" ");
                    break;
                case 2:
                    PizzaOption meOptionPeperoni = new PizzaOption();
                    meOptionPeperoni.setName("Peperoni");
                    meOptionPeperoni.setOptionSet(optionSet);
                    sets.add(meOptionPeperoni);
                    build.append("Peperoni").append(" ");
                    break;
                case 3:
                    PizzaOption meOptionAnchovy = new PizzaOption();
                    meOptionAnchovy.setName("Anchovy");
                    meOptionAnchovy.setOptionSet(optionSet);
                    sets.add(meOptionAnchovy);
                    build.append("Anchovy").append(" ");
                    break;
                case 4:
                    PizzaOption meOptionHam = new PizzaOption();
                    meOptionHam.setName("Ham");
                    meOptionHam.setOptionSet(optionSet);
                    sets.add(meOptionHam);
                    build.append("Ham").append(" ");
                    break;
                case 5:
                    //vegetable();
                    terminated = true;
                    break;
            }

        }
        return sets;

    }
    // Method for VegetableOptions


    public Set<PizzaOption> vegetable() {
        int size=1;
        PizzaOption veOption = new PizzaOption();
        Set<PizzaOption> sets = new HashSet<>();
        boolean terminated = false;

        Scanner scan = new Scanner(System.in);
        while (!terminated) {
            System.out.println("Press 1 For Mushroom. 2 For Union. 3 For Pineaple. 4 for Tomatoes. 5 back to meat. 6 For Finish ");
            switch (scan.nextInt()) {
                case 1:
                    veOption.setName("Mushroom");
                    sets.add(veOption);
                    build.append("Mushroom").append(" ");
                    break;
                case 2:
                    veOption.setName("Union");
                    sets.add(veOption);
                    build.append("Union").append(" ");
                    break;
                case 3:
                    veOption.setName("Pineaple");
                    sets.add(veOption);
                    build.append("Pineaple").append(" ");
                    
                    break;
                case 4:
                    veOption.setName("Tomatoes");
                    sets.add(veOption);
                 build.append("Tomatoes").append(" ");
                    break;

                    
                case 5:
                    meat(optionSet);
                    break;

                case 6:

                    terminated = true;
                    break;
            }
        }
        return sets;
    }

    //Complete Customer Order Here:
    
    public void requestedOrdering()
    {
        System.out.println("---------------------------------------------------------");
        System.out.println("THANK YOU FOR ORDERING MOREISH PIZZA");
        System.out.println("----------------------------------------------------------");
        System.out.println("This is your Requested Pizza Order:");
        System.out.println("----------------------------------------------------------");
        System.out.println("Pizza Name: "+pizzaConfig.getName());
        System.out.println("Pizza Size: "+pizzaConfig.getPizzaSize());
        System.out.println("Pizza Price: "+pizzaConfig.getBaseprice());
        double basePrice = pizzaConfig.getBaseprice();
        System.out.println("Pizza Derrivering Charge:"+pizzaConfig.getDelivery());
        Double deriver = pizzaConfig.getDelivery();
        System.out.println("This "+pizzaConfig.getName() +" Will Be Made Of: \n"+build);
        double totalAmount = basePrice + deriver;
        System.out.println("Total Amount To Pay :"+totalAmount);
        System.out.println("----------------------------------------------------------");
        System.out.println("Thanks!, Be Patient a Second while we are preparing it for you!!");
        
    
    }

    
}
