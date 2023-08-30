public class Toy {
    protected int id;
    protected String name;
    protected int quantity;
    protected double dropFrequency;

    public Toy(int id, String name, int quantity, double dropFrequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dropFrequency = dropFrequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDropFrequency() {
        return dropFrequency;
    }

    public void setDropFrequency(double frequency) {
        dropFrequency = frequency;
    }

    public void setQuantity(int qnt) {
        quantity = qnt;
    }
}
