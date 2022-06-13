import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Renderer {
    private static GLWindow window = null;

    public static int windowHeight = 360;
    public static int windowWidth = 640;

    //public static float[][] speed = new float[5][2];
    //window opdelen in 10 kolommen
    //if unitsWide is increased: looks like it zooms out
    public static float unitsWide = 10;
    public static float unitsTall = 0;
    public static float leftBound = -10;
    public static float lowerBound = 0;
    public static float rightBound = 10;
    public static float upperBound = 20;
    public static float leftPos = -10;
    public static float lowPos = 0;
    public static float previousUnitsTall = 0;
    public static float currentUnitsTall = 0;
    private static GLProfile profile;
    public static String state = "begin";
    public static Game game;
    public static void init() {

        /*for (int i =0 ; i< 5; i++){
            speed[i] = new float[]{0, 0};
        }*/
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        window = GLWindow.create(capabilities);
        window.setSize(windowWidth, windowHeight);
        window.setResizable(true);
        //als dit wordt gedaan is het onmogelijk het terug af te sluiten
        //window.setFullscreen(true);
        window.setVisible(true);
        window.setTitle("woensel");

        //zorgen dat de muis wordt geregistreerd op window
        window.requestFocus();
        unitsTall = unitsWide/window.getWidth()*window.getHeight();

        //om de windows te kunnen updaten
        previousUnitsTall = Renderer.getUnitsTall();
        currentUnitsTall = Renderer.getUnitsTall();


        FPSAnimator animator = new FPSAnimator(window, 30);
        animator.start();
        window.addGLEventListener(new EventListener());
        window.addKeyListener(new KeyBoard());
        game = new Game();

    }
    public static void drawCurrentLoop(GL2 gl){
        gl.glClearColor(0, 0,0 , 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        game.loop();
    }
    public static int getWindowWidth(){
        return window.getWidth();
    }
    public static int getWindowHeight(){
        return window.getHeight();
    }
    public static float getUnitsTall() {return Renderer.getWindowHeight() / (Renderer.getWindowWidth()/Renderer.unitsWide);}
    public static void main(String[] args){// throws IOException {
        //ImageToMatrix.init();
        init();
    }
    public static GLProfile getProfile() {
        return profile;
    }
}
