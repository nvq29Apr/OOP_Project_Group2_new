package models;

/**
 *
 * @author quyetdaika
 */
public class NFT {
    private String name;
    private String volume, change;
    private String floorPrice, owners, items;
    private String timeSlot; // Giá trị của volume và change sẽ thay đổi tùy thuộc vào timeSlot 1H, 6H, 24H, 1D

    public NFT(String name, String volume, String change, String floorPrice, String owners, String items, String timeSlot) {
        this.name = name;
        this.volume = volume;
        this.change = change;
        this.floorPrice = floorPrice;
        this.owners = owners;
        this.items = items;
        this.timeSlot = timeSlot;
    }

    public String getVolume() {
        return volume;
    }

    public String getChange() {
        return change;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public String getOwners() {
        return owners;
    }

    public String getItems() {
        return items;
    }
    
    public String getName() {
        return name;
    }
    
    public Object[] getNFT(){
        Object[] s = new Object[]{name, volume, change, floorPrice, owners, items};
        return s;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
    
}
