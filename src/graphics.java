import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class graphics {

    static float red = 0;
    static float green = 0;
    static float blue = 1;
    static float alpha = 1;
    static float rotation = 0;
    //x is links, y is boven, enzv.
    public static void fillRect(float x, float y, float width, float height) {
        GL2 gl = EventListener.gl;
        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);
        //volgorde van vertices maakt uit!, met klok mee of tegen klok in
        //maar niet door elkaar
        gl.glVertex2f(x, y); //linksboven
        gl.glVertex2f(x+width, y); //linksonder
        gl.glVertex2f(x+width, y+height); //rechtsonder
        gl.glVertex2f(x, y+height); //rechtsboven
        gl.glEnd();
    }


    //x en y zijn het midden van de image

    public static void setRotation(float newRot){
        rotation = newRot;
    }

    public static void fillTriangle(float topY, float baseX, float baseY, float baseLength){
        GL2 gl = EventListener.gl;
        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex2f(baseX, baseY); //linksonder
        gl.glVertex2f(baseX+baseLength, baseY); //rechtsonder
        gl.glVertex2f(baseX+baseLength/2, topY); //rechtsboven
        gl.glEnd();
    }

    public static void setColor(float r, float g, float b, float a){
        red = r;
        green = g;
        blue = b;
        alpha = a;
    }
}
