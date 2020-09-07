package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

import java.util.List;

/**
 * Class for storing Writer object
 */
public class Writer {

    /**
     * Variables declaration
     */
    private String name;
    private List<Article> articles;

    /**
     * Constructor
     * @param name
     * @param articles
     */
    public Writer(String name, List<Article> articles) {
        this.name = name;
        this.articles = articles;
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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
