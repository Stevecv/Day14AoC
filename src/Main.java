import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(PuzzleInput.testInput);
        System.out.println(map.getReadableMap());
        System.out.println("2, " + map.raycastNorth(2,6));
    }


}