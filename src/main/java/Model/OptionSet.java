/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;


@Entity
public class OptionSet implements Serializable {
        @Version
    private int version;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long optionSetId;
    
     private String name;
     
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "optionSet",cascade=CascadeType.ALL)
    private Set<PizzaOption> options;
    
    
        @ManyToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name = "id", nullable = false)
    private PizzaConfig pizzaConfig;

    public PizzaConfig getPizzaConfig() {
        return pizzaConfig;
    }

    public void setPizzaConfig(PizzaConfig pizzaConfig) {
        this.pizzaConfig = pizzaConfig;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PizzaOption> getOptions() {
        return options;
    }

    public void setOptions(Set<PizzaOption> options) {
        this.options = options;
    }

    public Long getOptionSetId() {
        return optionSetId;
    }

    public void setOptionSetId(Long optionSetId) {
        this.optionSetId = optionSetId;
    }

 

    

//    protected class Option {
//
//        private String name;
//        private double price;
//
//        public Option() {
//        }
//
//        public Option(String name) {
//            this.name = name;
//        }
//
//        protected Option(String name, double price) {
//
//            this.name = name;
//            this.price = price;
//        }
//
//        protected String getName() {
//            return name;
//        }
//
//        protected void setName(String name) {
//            this.name = name;
//        }
//
//        protected double getPrice() {
//            return price;
//        }
//
//        protected void setPrice(double price) {
//            this.price = price;
//        }
//
//         public void findOPtion(String name){
//        
//    }
//    
//   // public void deleteOption(){
//        
//    }
    
//    public void updateOption(){
//        
//    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}