import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(PuzzleInput.puzzleInput);
        map.tiltNorth();
        System.out.println(map.getReadableMap()); // Not necessary, just looks cool :)

        int totalLoad = 0;
        for (int y = 0; y < map.getMap().size(); y++) {
            int rockCount = 0;
            int rockWeight = map.getMap().size()-y;
            for (String item: map.getLine(y)) {
                if (item == "O") {
                    rockCount++;
                }
            }

            int lineWeight = rockWeight*rockCount;
            totalLoad += lineWeight;
        }
        System.out.println(totalLoad);
    }
}