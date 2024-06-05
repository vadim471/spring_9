package org.example.model;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column( columnDefinition = "serial")
    @Column(name = "description")
    private String description;
    @Column(name = "purchased")
    private boolean purchased;

    public Product(){
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPurchased(boolean purchased){
        this.purchased = purchased;
    }

    public void setId(Long id){
        this.id = id;
    }
    public boolean getPurchased() {
        return purchased;
    }
    public Long getId(){
        return id;
    }
    public Product(String description, boolean purchased) {
        this.description = description;
        this.purchased = purchased;
    }

}
