package models;

/**
 *
 * @author quyetdaika
 */
public class Hashtag {
    private String name;
    private int qty;

    public Hashtag(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }
    
    public Object[] getHashtag(){
        Object[] s = new Object[]{name, qty};
        return s;
    }
}
