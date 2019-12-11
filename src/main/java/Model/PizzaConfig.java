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
import javax.persistence.OneToMany;
import javax.persistence.Version;


@Entity
public class PizzaConfig implements Serializable{

        
    
    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        
    private Long pizzaConfigid;
          @Version
    private int version;
        
    private double baseprice;   
    private String pizzaSize;
    
    private double delivery;
    private String name;
    
   @OneToMany(fetch = FetchType.EAGER, mappedBy = "pizzaConfig",cascade=CascadeType.ALL)
    private Set<OptionSet> optionSets;

    public PizzaConfig(Long id, double baseprice, String pizzaSize, double delivery, String name) {
        this.pizzaConfigid = id;
        this.baseprice = baseprice;
        this.pizzaSize = pizzaSize;
        this.delivery = delivery;
        this.name = name;
    }

    public Long getId() {
        return pizzaConfigid;
    }

    public void setId(Long id) {
        this.pizzaConfigid = id;
    }

    public Set<OptionSet> getOptionSets() {
        return optionSets;
    }

    public void setOptionSets(Set<OptionSet> optionSets) {
        this.optionSets = optionSets;
    }
    
    
    public PizzaConfig(){
        
    }
    
    public double getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(double baseprice) {
        this.baseprice = baseprice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String size) {
        this.pizzaSize = size;
    }

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
//    public void find(String name ){
//        
//    }
//    
//    public void delete(){
//        
//    }
//    
//    public void update(){
//        
//    }

    @Override
    public String toString() {
        return super.toString();
    }
 
}