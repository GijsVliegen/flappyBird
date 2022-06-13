

public class Square extends Drawing{
    private float[] square;
    private boolean collided = false;


    public Square(float x, float y, float width, float height){
        square = new float[]{x, y, width, height};
        super.color = new float[]{0, 0, 1, 1};
    }
    public void setY(float newY){
        square[1] = newY;
    }
    public void setX(float newX){
        square[0] = newX;
    }
    public float getX(){
        return square[0];
    }
    public float getY(){
        return square[1];
    }
    public float getWidth(){
        return square[2];
    }
    public float getHeight(){
        return square[3];
    }
    public void setColor(float r, float g, float b, float a){
        color = new float[]{r, g, b, a};
    }

    @Override
    public void drawToScreen() {
        graphics.setColor(color[0], color[1], color[2], color[3]);
        graphics.fillRect(square[0], square[1], square[2], square[3]); }

    @Override
    public boolean checkCollision(float x, float y, float width, float height){
        // collision x-axis?
        boolean collisionX = (x + width > getX() && x + width < getX() + getWidth())
                || (x > getX() && x < getX() + getWidth())
                || (x <= getX() && x + width >= getX() + getWidth());

        // collision y-axis?
        boolean collisionY = (y + height > getY() && y + height < getY() + getHeight())
                || (y > getY() && y < getY() + getHeight())
                || (y <= getY() && y + height >= getY() + getHeight());
        // collision only if on both axes
        return collisionX && collisionY;
    }

    @Override
    public float[] resolveCol(float x, float y, float w, float h, float sX, float sY) {
        return new float[0];
    }
}
