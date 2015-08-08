package observer;

import com.vsprog.anitipick.Hero;

/**
 * @author vsa
 * @date 08.08.2015.
 */
public interface Observer {
    void update (Hero firstEnemy, Hero secondEnemy, Hero thirdEnemy, Hero fourthEnemy, Hero fifthEnemy);
}
