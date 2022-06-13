import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Square player;
    static float speedY;
    static float gravity = -.02f;
    static float pipeSpeed = -.12f;
    List<Square> pipes;
    static long counter = 0;
    Random rand;
    static int score = -2;
    static boolean quit;
    public Game(){
        player = new Square(-8, 2, .6f, 0.6f);
        player.setColor(0,1,0,1);
        pipes = new ArrayList<>();
        rand = new Random();
        speedY = 0.3f;
    }
    public static void jump(){
        speedY = .2f;
    }
    public static void quit(){
        quit = true;
    }
    public void restart() {
        System.out.println("score was " + Math.max(score, 0));
        score = -2;
        player = new Square(-8, 2, .6f, 0.6f);
        player.setColor(0,1,0,1);
        pipes = new ArrayList<>();
        rand = new Random();
        speedY = 0.3f;
    }
    public void loop(){
        if (Math.floorMod(counter, 45) == 15){
            score++;
            System.out.println(score);
        }
        if (!quit) {
            counter++;
            updatePlayerPosition();
            updatePipePosition();
            player.drawToScreen();
            for (Square pipe : pipes) {
                pipe.drawToScreen();
            }
            for (Square pipe : pipes) {
                if (player.checkCollision(pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight())) {
                    restart();
                }
            }
        }
    }
    public void updatePlayerPosition(){
        if (player.getY() > 10 || player.getY() < -2){
            restart();
        }
        player.setY(player.getY()+speedY);
        speedY += gravity;
    }
    public void updatePipePosition(){
        if (Math.floorMod(counter, 45) == 15){
            float height = (float)rand.nextInt(10)/(float)5+1;
            pipes.add(new Square(5, 0, 1, height));
            pipes.add(new Square(5, height + 2.2f, 1, 5));
        }

        if (pipes.size() > 1 && pipes.get(0).getX() < -20){
            pipes.remove(1);
            pipes.remove(0);
        }
        for(Square pipe: pipes){
            pipe.setX(pipe.getX()+pipeSpeed);
        }
    }
}
