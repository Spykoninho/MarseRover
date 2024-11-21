enum Direction{
    Top,
    Right,
    Bot,
    Left,
}

public class DirectionClass{
    public DirectionClass() {}

    public Direction stringToDirection(String input){
        switch (input){
            case "Top":
                return Direction.Top;
            case "Bot":
                return Direction.Bot;
            case "Left":
                return Direction.Left;
            case "Right":
                return Direction.Right;
            default:
                return null;
        }
    }
}