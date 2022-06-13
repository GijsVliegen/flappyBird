import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyBoard implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        //149 is pijl naar links
        //150 is pijl naar boven
        //151 is pijl naar rechts
        //152 is pijl naar onder
        if (e.getKeyCode() == 150) {
            Game.jump();
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

}
