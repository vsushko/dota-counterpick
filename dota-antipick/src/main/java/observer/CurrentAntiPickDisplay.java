package observer;

import com.vsprog.anitipick.Hero;
import com.vsprog.anitipick.Pick;

/**
 * @author vsa
 * @date 08.08.2015.
 */
public class CurrentAntiPickDisplay implements Observer {
    private Pick pick;
    private int currentCount = 0;

    private Hero firstEnemy, secondEnemy, thirdEnemy, fourthEnemy, fifthEnemy;

    public CurrentAntiPickDisplay(Pick pick) {
        this.pick = pick;
        firstEnemy = new Hero();
        secondEnemy = new Hero();
        thirdEnemy = new Hero();
        fourthEnemy = new Hero();
        fifthEnemy = new Hero();

        pick.registerObserver(this);
    }

    @Override
    public void update(Hero firstEnemy, Hero secondEnemy, Hero thirdEnemy, Hero fourthEnemy, Hero fifthEnemy) {
        this.firstEnemy = firstEnemy != null ? firstEnemy : new Hero();
        this.secondEnemy = secondEnemy != null ?secondEnemy : new Hero();
        this.thirdEnemy = thirdEnemy != null ?thirdEnemy : new Hero();
        this.fourthEnemy = fourthEnemy != null ? fourthEnemy: new Hero();
        this.fifthEnemy = fifthEnemy != null ? fifthEnemy: new Hero();

        display();
    }

    public void display() {
        System.out.println("Первый герой: " + firstEnemy.getName());
        System.out.println("Второй герой: " + secondEnemy.getName());
        System.out.println("Третий герой: " + thirdEnemy.getName());
        System.out.println("Четвертый герой: " + fourthEnemy.getName());
        System.out.println("Пятый герой: " + fifthEnemy.getName());
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void incrementCurrentCount() {
        currentCount++;
    }
}