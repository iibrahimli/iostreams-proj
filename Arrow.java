import java.awt.*;

public class Arrow extends Shape{

    public Arrow(int x, int y, int width, int height, Color c, int id) {
        super(x, y, width, height, c, id);
    }

    public void draw(Graphics g) {
        double alpha;
        int x_len = 10, y_len = 6;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        g.setColor(col);
        g.drawLine(x, y, x+width, y+height);

        alpha = Math.atan2((height), (width));
        g2.translate(x+width, y+height);
        g2.rotate(alpha);
        g.drawLine(-x_len, -y_len, 0, 0);
        g.drawLine(-x_len, y_len, 0, 0);
        g2.rotate(-alpha);
        g2.translate(-x-width, -y-height);

        g2.setStroke(new BasicStroke(1));

        g.setColor(Color.GRAY);
        if(isMoving) g.drawRect(x, y, width, height);
    }

    @Override
    public boolean containsPoint(int x, int y){

        float k, b; // parameters of the line
        if(width == 0) k = (float)this.height/(this.width+0.01f);
        else {
            k = (float)(this.height) / this.width;
        }
        b = (float) this.y - k*this.x;
        boolean isInside = false;

        if(x*k+b >= y-5 && x*k+b <= y+5)
            isInside=true;

        return isInside;
    }

}