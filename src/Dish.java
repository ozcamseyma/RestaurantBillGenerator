
//3. olarak yiyecek objesi
public class Dish {//pojo urun
    //yiyecekler ozellikleri okunabilsin ama degistirelemesin
    private int code;

    private String name;

    private double price;

    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                "code=" + code +
                        ", name='" + name + '\'' +
                        ", price=" + price +
                        '}';
    }
}
