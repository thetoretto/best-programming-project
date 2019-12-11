/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 *
 * @author root
 */
@Entity
public class PizzaOption implements Serializable{

        @Id
          @GeneratedValue(strategy = GenerationType.AUTO)
    private Long optionId;
              @Version
    private int version;
        private String name;
        private double price;
        


    @ManyToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name = "optionSetId", nullable =false)
    private OptionSet optionSet;

  
    
        public PizzaOption() {
        }
          public OptionSet getOptionSet() {
        return optionSet;
    }
    public PizzaOption(String name, double price) {

            this.name = name;
            this.price = price;
        }

    public void setOptionSet(OptionSet optionSet) {
        this.optionSet = optionSet;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
   

 
        public PizzaOption(String name) {
            this.name = name;
        }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

//         public void findOPtion(String name){
//        
//    }


}
