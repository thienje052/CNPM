package Model;

public class HangHoa {
    private int id;
    private String name;
    private int quantity;
    private String measurement;
    private String description;
    private String catagory;

    public HangHoa(int id, String name, int quantity, String measurement, String description, String catagory) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.measurement = measurement;
        this.description = description;
        this.catagory = catagory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
}