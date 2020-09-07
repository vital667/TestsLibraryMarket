package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

/**
 * Class for storing article object
 */
public class Article {

    /**
     * Variables declaration
     */
    private String name;
    private int productionYear;

    /**
     * Constructor
     * @param name
     * @param productionYear
     */
    public Article(String name, int productionYear) {
        this.name = name;
        this.productionYear = productionYear;
    }

    /**
     * Getters and setters section
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}