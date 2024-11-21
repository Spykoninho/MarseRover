public class Rover {
    Position position;

    Direction direction;
    int vitesse;

    public Rover(Position position, int vitesse) {
        this.position = position;
        this.vitesse = vitesse;
        direction = Direction.Right;
    }

    public void move(String input){
        switch (input){
            case "Right":
                turnRight();
                break;
            case "Left":
                turnLeft();
                break;
            case "Go":
                moveForward();
                break;
        }
    }

    public void moveForward(){
        switch (direction){
            case Right:
                position.x++;
                break;
            case Left:
                position.x--;
                break;
            case Top:
                position.y--;
                break;
            case Bot:
                position.y++;
        }
    }

    public void turnRight(){
        switch (direction){
            case Right:
                direction = Direction.Bot;
                break;
            case Left:
                direction = Direction.Top;
                break;
            case Top:
                direction = Direction.Right;
                break;
            case Bot:
                direction = Direction.Left;
        }
    }

    public void turnLeft(){
        switch (direction){
            case Right:
                direction = Direction.Top;
                break;
            case Left:
                direction = Direction.Bot;
                break;
            case Top:
                direction = Direction.Left;
                break;
            case Bot:
                direction = Direction.Right;
        }
    }
}
