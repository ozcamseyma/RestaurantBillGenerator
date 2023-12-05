

public class Order {

    private static int count=999;
    private int orderCode;

    private Dish dish;//100,"Adana kebabi",250.99

    private int numberOfDish;//3;

    private double orderPrice;//3*250.99

    //8-yemek ve adedini kullanarak order objemizi olusturalim
    public Order(Dish dish,int numberOfDish){
        count++;//1000
        orderCode=count;
        this.dish=dish;
        this.numberOfDish=numberOfDish;
    }
    //9-orderPrice hesaplayalim
    public void setOrderPrice(){
        this.orderPrice=this.numberOfDish*this.dish.getPrice();
    }

    public void setNumberOfDish(int numberOfDish) {
        this.numberOfDish = numberOfDish;
    }

    //getter methodlari
    public int getOrderCode() {
        return orderCode;
    }

    public Dish getDish() {
        return dish;
    }

    public int getNumberOfDish() {
        return numberOfDish;
    }

    public double getOrderPrice() {
        return orderPrice;
    }
}
