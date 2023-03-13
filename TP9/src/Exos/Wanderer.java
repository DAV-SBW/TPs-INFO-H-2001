package Exos;

public class Wanderer {
    private int posx, posy;

    public Wanderer(int posx, int posy) {
		this.posx = posx;
        this.posy = posy;
    }

    public void move(int posx, int posy) {
		this.posx += posx;
        this.posy += posy;
    }

    public boolean at(int posx, int posy) {
		return this.posx == posx && this.posy == posy;
    }

	public boolean move_allowed(int dx, int dy, int width, int heigth) {
		int newx, newy;
		newx = this.posx + dx;
		newy = this.posy + dy;
		return newx > 0 && newx <= width
			&& newy > 0 && newy <= heigth;
	}

	public int getPosx() {
		return posx;
	}

	public int getPosy() {
		return posy;
	}
}