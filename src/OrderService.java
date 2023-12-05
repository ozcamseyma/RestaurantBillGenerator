
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//10- orderla ilgili işlemler
public class OrderService {
    Scanner scan=new Scanner(System.in);
    public List<Order>orderList=new ArrayList<>();

    //11-siparis olusturma
    public void createOrder(DishService dishService){
        int dishCode;
        do {
            System.out.println("lutfen ürün kodunu giriniz(CIKIŞ icin 0 'i tuslayiniz)");
            dishCode= scan.nextInt();
            Dish dish=dishService.findDishByCode(dishCode);
            if (dish!=null){
                System.out.println("lutfen adet sayisi giriniz : ");
                int number= scan.nextInt();
                //bu yemek daha once siparis edildi mi
                Order order=findOrderByCode(dish);

                if (order==null){
                    //yeni siparis olusturalim
                    order=new Order(dish,number);
                    order.setOrderPrice();
                    this.orderList.add(order);
                } else if (order!=null) {
                    //siparis ekleme
                    System.out.println("bu siparis daha once "+order.getNumberOfDish()+" kere olusturulmus");
                    order.setNumberOfDish(order.getNumberOfDish()+number);
                    order.setOrderPrice();
                }
            }
            //13-siparis olusturma listesi goruntulensin
            listOrders();


        }while (dishCode!=0);

    }

    public void listOrders() {
        this.orderList.forEach(order ->
                System.out.printf("Siparis kodu:%-5s Lezzet kodu:%-4s Lezzet Adi:%-20s Adet:%-2s tutar:%-5s\n",
                        order.getOrderCode(),order.getDish().getCode(),order.getDish().getName(),order.getNumberOfDish(),order.getOrderPrice()));

    }

    private Order findOrderByCode(Dish dish) {
        for (Order order:orderList
        ) {
            if (order.getDish().equals(dish)){
                return order;
            }
        }
        return null;
    }
    public void deleteOrder(){
        System.out.println("iptal etmek istediginiz siparisin kodunu giriniz : ");
        int code= scan.nextInt();//1000 1001 1002 1003
        boolean isFound=false;
        for (Order order:orderList
        ) {
            if (order.getOrderCode()==code){//kaç tane iptal etmek istiyor
                System.out.println("iptal etmek istediginiz miktari giriniz");
                int number=scan.nextInt();//3-5-9
                if (number>0&&number<order.getNumberOfDish()){
                    order.setNumberOfDish(order.getNumberOfDish()-number);
                    order.setOrderPrice();
                    System.out.println("siparişiniz "+number+" adedi iptal edildi : "+order.getDish().getName());
                } else if (number==order.getNumberOfDish()) {
                    this.orderList.remove(order);
                    System.out.println("siparisiniz iptal edildi : "+order.getDish().getName());
                }else {
                    System.out.println("hatali giris!");
                }
                isFound=true;
                break;

            }

        }
        if (!isFound){
            System.out.println("İptal işlemi başarısız, sipariş kodu gecersiz!");
        }
        System.out.println("    mevcut siparisleriniz    ");
        listOrders();
    }
    public void printBill(){
        double total=0;
        System.out.println("       Java Restaurant Lezzet Fişi         ");
        listOrders();
        for (Order order:orderList)
        {
            total+=order.getOrderPrice();
        }
        System.out.println("Toplam Tutar : "+total);
        System.out.println("Afiyet Olsun ... yine bekleriz");
        //adisyon kapatildi yeni siparise gecilebilir
        orderList.clear();
    }


}
