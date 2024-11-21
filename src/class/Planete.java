import java.util.ArrayList;
import java.util.Scanner;

public class Planete {
    Taille taille;
    ArrayList<Obstacle> obstacle = new ArrayList<>();
    Rover rover;

    public Planete(int maxL) {
        generateMap(maxL);
        generateObstacles(maxL);
        displayMap();
        land();
    }

    public void displayMap(){
        for (int y = 0; y < this.taille.y; y++) {
            for (int x = 0; x < this.taille.x; x++) {
                if(isObstacle(x, y)){
                    Obstacle obstacle = getObstacle(x, y);
                    if (obstacle.type == 0) {
                        System.out.print("🌳");
                    } else if (obstacle.type == 1) {
                        System.out.print("🪨");
                    } else if(obstacle.type == 3){
                        while (true){
                            System.out.print("🔥");
                        }
                    }else{
                        System.out.print("🌳");
                    }
                }else System.out.print("🟩");
            }
            System.out.println();
        }
    }

    public void displayPlanete(){
        for (int y = 0; y < this.taille.y; y++) {
            for (int x = 0; x < this.taille.x; x++) {
                if(isObstacle(x, y)){
                    Obstacle obstacle = getObstacle(x, y);
                    if (obstacle.type == 0) {
                        System.out.print("🌳");
                    } else if (obstacle.type == 1) {
                        System.out.print("🪨");
                    } else if(obstacle.type == 3){
                        while (true){
                            System.out.print("🔥");
                        }
                    }else{
                        System.out.print("🌳");
                    }
                }else if ((isRover(x, y))) {
                    switch (rover.direction){
                        case Bot:
                            System.out.print("⬇️");
                            break;
                        case Top:
                            System.out.print("⬆️");
                            break;
                        case Left:
                            System.out.print("⬅️");
                            break;
                        case Right:
                            System.out.print("➡️");
                    }
                }else System.out.print("🟩");
            }
            System.out.println();
        }
    }

    public boolean isObstacle(int x, int y){
        for (Obstacle value : this.obstacle) {
            if (value.position.x == x && value.position.y == y) return true;
        }
        return false;
    }

    public Obstacle getObstacle(int x, int y){
        for (Obstacle value : this.obstacle) {
            if (value.position.x == x && value.position.y == y) return value;
        }
        return null;
    }

    public boolean isRover(int x, int y){
        return rover.position.x == x && rover.position.y == y;
    }

    public void land(){
        System.out.println("Où voulez vous atterir ?");
        System.out.println("Largeur : ");
        int xLanded = new Scanner(System.in).nextInt();
        System.out.println("Hauteur : ");
        int yLanded = new Scanner(System.in).nextInt();
        this.rover = new Rover(new Position(xLanded, yLanded), 1);
        if(isObstacle(xLanded, yLanded)){
            getObstacle(rover.position.x, rover.position.y).type=3;
            displayMap();
            System.out.println("CRASH");
            System.exit(1);
        }if(xLanded<0 || xLanded>this.taille.x || yLanded<0 || yLanded>this.taille.y){
            System.out.println("Atterissage raté");
            System.exit(1);
        }else{
            this.rover.position.x = xLanded;
            this.rover.position.y = yLanded;
        }
    }

    public void generateMap(int maxSize){
        int heightMap = (int)(Math.random()*maxSize)+5;
        int widthMap = (int)(Math.random()*maxSize)+5;
        this.taille = new Taille(heightMap, widthMap);
        generateObstacles(maxSize);
    }

    public void generateObstacles(int maxSize){
        int nObstacle = (int)(Math.random()*(maxSize+5));
        for (int i = 0; i < nObstacle; i++) {
            int xRand = (int)(Math.random()*taille.x);
            int yRand = (int)(Math.random()*taille.y);
            int type = (int)(Math.random()*2);
            this.obstacle.add(new Obstacle(new Position(xRand, yRand), type));
        }
    }

    public void moveRover(String input){
        rover.move(input);
        if(rover.position.x < 0 || rover.position.y < 0 || rover.position.x > taille.x - 1 || rover.position.y>taille.y -1) crossPlanet();
        if(isObstacle(rover.position.x, rover.position.y)){
            getObstacle(rover.position.x, rover.position.y).type=3;
            System.out.println("CRASH");
            displayMap();
            System.exit(1);
        }
    }

    public void crossPlanet(){
        if(rover.position.x < 0){
            rover.position.x = taille.x-1;
            return;
        }
        if(rover.position.y < 0){
            rover.position.y = taille.y-1;
            return;
        }

        if(rover.position.x > taille.x - 1){
            rover.position.x = 0;
            return;
        }
        if(rover.position.y > taille.y - 1){
            rover.position.y = 0;
        }
    }
}
