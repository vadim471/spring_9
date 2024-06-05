package org.example.repository.DTO;

public class ProductDTO {
    private String description;
    private boolean purchased;
    ProductDTO(){
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public String getDescription() {
        return description;
    }
}
