package qf.edu.entity;

public class ShoppingCart {

    int id;
    int pid;
    int num;
    int money;

    public ShoppingCart() {
    }

    public ShoppingCart(int id, int pid, int num, int money) {
        this.id = id;
        this.pid = pid;
        this.num = num;
        this.money = money;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", pid=" + pid +
                ", num=" + num +
                ", money=" + money +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
