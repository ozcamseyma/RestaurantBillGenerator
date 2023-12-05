

import java.util.ArrayList;
import java.util.List;

//4. olarak yiyecek objeleri icin islemlerin yapıldıgı class
public class DishService {
    //5. yiyecekleri bir listeye koyalim
    private List<Dish> dishList=new ArrayList<>();
    public DishService(){
        fillDishList();
    }

    private void fillDishList(){
        Dish dish1=new Dish(100,"Adana kebabi",250.99);
        Dish dish2=new Dish(101,"Beyti",200);
        Dish dish3=new Dish(102,"Lahmacun",120.50);
        Dish dish4=new Dish(103,"Ali nazik",170.99);
        Dish dish5=new Dish(104,"Musakka",130);
        Dish dish6=new Dish(105,"iskender",150);
        Dish dish7=new Dish(106,"Manti",70);
        Dish dish8=new Dish(200,"Baklava",100);
        Dish dish9=new Dish(201,"Kemalpaşa",60);
        Dish dish10=new Dish(202,"Künefe",120);
        Dish dish11=new Dish(204,"Fırın sütlaç",90);
        Dish dish12=new Dish(300,"Su",10);
        Dish dish13=new Dish(301,"Ayran",15);
        Dish dish14=new Dish(302,"türk kahvesi",20);
        Dish dish15=new Dish(303,"Çay",10);
        this.dishList.add(dish1);
        this.dishList.add(dish2);
        this.dishList.add(dish3);
        this.dishList.add(dish4);
        this.dishList.add(dish5);
        this.dishList.add(dish6);
        this.dishList.add(dish7);
        this.dishList.add(dish8);
        this.dishList.add(dish9);
        this.dishList.add(dish10);
        this.dishList.add(dish11);
        this.dishList.add(dish12);
        this.dishList.add(dish13);
        this.dishList.add(dish14);
        this.dishList.add(dish15);

    }
    //6. yemek menusunu gosterme

    public void showMenu(){
        System.out.println("            ***lezzetlerimiz***             ");
        System.out.printf("%-3s     %-20s    %-6s     \n","kod","adı","fiyat");
        System.out.printf("%-3s     %-20s    %-6s     \n","***","****","***********");
        for (Dish dish:dishList
        ) {
            System.out.printf("%-3s     %-20s    %-6s   lira\n",dish.getCode(),dish.getName(),dish.getPrice());
        }
    }
    //12-kodu verilen yemegi listeden bulalım
    public Dish findDishByCode(int code){//303 --> 303,"Çay",10
        if (code==0) {
            System.out.println("Ana menüye yonlendiriliyosunuz");
        }else {
            for (Dish dish:dishList
            ) {
                if (dish.getCode()==code){
                    return dish;
                }
            }
            System.out.println("ürün bulunamadi");
        }
        return null;
    }
}
