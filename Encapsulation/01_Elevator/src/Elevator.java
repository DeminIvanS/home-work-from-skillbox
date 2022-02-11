public class Elevator {
    private int minFloor = -3;
    private int maxFloor = 26;
    private int currentFloor = 1;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveComplete(){
        System.out.println("лифт прибыл на " + getCurrentFloor() + " этаж, двери открываются");
    }

    public void move(int floor) {
        if (floor < minFloor) {
            System.out.println("Введен неверный номер этажа");
        } else {
            while (floor < currentFloor) {
                moveDown();
                System.out.println(getCurrentFloor() + 1);
                if (floor == currentFloor) {
                    moveComplete();
                }
            }
            if (floor > maxFloor) {
                System.out.println("Введен неверный номер этажа");

            } else {
                while (floor > currentFloor) {
                    moveUp();
                    System.out.println(getCurrentFloor() - 1);
                    if(floor == currentFloor) {
                        moveComplete();
                    }
                }
            }
        }
    }
}