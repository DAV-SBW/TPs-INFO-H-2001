package TP3.Exo3;

public class Hero extends GameObject{
    private int gold = 0;
    private int stars = 0;
    private Game game;
    private int direction = 0; 						// O = S; 1 = E, 2 = N, 3 = W

    public Hero(int x, int y, Game game) {
        super(x, y);
        this.game = game;
    }

    public void addGold(int i){
        gold += i;
    }

    public void moveForward(){
        int nextX = getX();
        int nextY = getY();
        if (direction == 0){
            nextY -= 1;
        } else if (direction == 1){
            nextX -= 1;
        } else if (direction == 2){
            nextY += 1;
        } else if (direction == 3){
            nextX += 1;
        }

        GameObject obstacle = game.getObject(nextX,nextY);
        if (!(obstacle instanceof Obstacle)){
            super.setX(nextX);
            super.setY(nextY);
        }
    }

    public void take(){
        GameObject obj = game.getObject(getX(), getY());
        if (!(obj instanceof Collectable)){
            (Collectable)obj).collect(this);
        }
    }

    }
}
