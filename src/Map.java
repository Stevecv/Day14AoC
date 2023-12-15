import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Map {
    public static ArrayList<ArrayList<String>> map = new ArrayList<>();
    public Map(String inputMap) {
        for (String y: inputMap.split("\n")) {
            ArrayList<String> tempX = new ArrayList<>();
            for (char x: y.toCharArray()) {
                tempX.add(Character.toString(x));
            }
            map.add(tempX);
        }
    }

    public String getReadableMap() {
        StringBuilder builder = new StringBuilder();
        for (ArrayList<String> line: map) {
            builder.append(String.join("", line) + "\n");
        }
        return builder.toString();
    }
    public String getCoordinate(int x, int y) {
        return map.get(y).get(x);
    }

    public void tiltNorth() {
        for (int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.get(y).size(); x++) {
                String item = getCoordinate(x,y);
                if (Objects.equals(item, "0")) {

                }
            }
        }
    }

    public int raycastNorth(int x, int y) {
        int moveCount = 0;
        for (int i = y-1; i > -1; i--) {
            System.out.println(" > " + getCoordinate(x, i));
            if (!Objects.equals(getCoordinate(x, i), ".")) {
                return y-moveCount;
            }
            moveCount++;
        }
        return y-moveCount;
    }
}
