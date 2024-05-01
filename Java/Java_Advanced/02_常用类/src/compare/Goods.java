package compare;

/**
 * @author: zhanghao
 * @date: 2021/10/1-17:22
 */

/**
 * @Description
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    @Override
    public int compareTo(Object o) {
        //首先判断是不是Goods对象
        if (o instanceof Goods) {
            //强转为Goods对象
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else{
                return this.name.compareTo(goods.name);
            }
        }
        //程序执行到这里证明o不是Goods对象
        throw new RuntimeException("o不是Goods对象");
    }

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
