package eventswithred.com.redrewards;

public class StoreProduct {
    private int imageId;
    private String title;
    private String description;
    private int cost;
    private boolean s;
    private boolean m;
    private boolean l;
    private boolean xl;

    public StoreProduct(int imageId, String title, String description, int cost) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.cost = cost;
    }

    public StoreProduct(int imageId, String title, String description, int cost, boolean Small, boolean Med,
                        boolean Large, boolean xLarge) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.s = Small;
        this.m = Med;
        this.l = Large;
        this.xl = xLarge;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() { return cost; }

    public String getCostString() { return ("Cost: " + cost);}

    public void setCost(int cost) { this.cost = cost; }
}
