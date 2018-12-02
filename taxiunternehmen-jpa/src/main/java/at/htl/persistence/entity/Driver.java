package at.htl.persistence.entity;

public class Driver extends Person {
    private Car car;
    private Boss boss;

    //region Constructor
    public Driver(String name, Double salary, Car car, Boss boss) {
        super(name, salary);
        this.car = car;
        this.boss = boss;
    }
    //endregion

    //region Getter and Setter
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
    //endregion
}
