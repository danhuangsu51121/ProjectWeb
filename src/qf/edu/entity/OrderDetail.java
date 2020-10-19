package qf.edu.entity;

public class OrderDetail {

    private int id;
    private int pid;
    private int oid;
    private int num;
    private int money;

    public OrderDetail() {
    }

    public OrderDetail(int id, int pid, int oid, int num, int money) {
        this.id = id;
        this.pid = pid;
        this.oid = oid;
        this.num = num;
        this.money = money;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", pid=" + pid +
                ", oid=" + oid +
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

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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
