package models;

/**
 *
 * @author trung
 */
public class Blog {
    private String title;
    private String info;
    private String img;
    private String link;


    public Blog(String title, String info, String img,  String link) {
        this.title = title;
        this.info = info;
        this.img = img;
        this.link = link;
    }
}
