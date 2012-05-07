package org.magi.quotes;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public enum PriceType {

    ML("Mètre courant"),
    PC("Pièce"),
    FF("Forfait"),
    H("Heure"),
    M2("Mètre carré");

    private String description;
    
    private PriceType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
