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

    public ArrayList<String> getLine(int y) {
        return map.get(y);
    }
    public ArrayList<ArrayList<String>> getMap() {
        return map;
    }

    public String getReadableMap() {
        StringBuilder builder = new StringBuilder();
        for (ArrayList<String> line: map) {
            builder.append(String.join("", line)).append("\n");
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
                if (Objects.equals(item, "O")) {
                    int moveX = x;
                    int moveY = raycastNorth(x, y);

                    setCoordinate(x, y, ".");
                    setCoordinate(moveX, moveY, "O");
                }
            }
        }
    }

    public void tiltSouth() {
        for (int y = map.size()-1; y > -1; y--) {
            for (int x = 0; x < map.get(y).size(); x++) {
                String item = getCoordinate(x,y);
                if (Objects.equals(item, "O")) {
                    int moveX = x;
                    int moveY = rayCastSouth(x, y);

                    setCoordinate(x, y, ".");
                    setCoordinate(moveX, moveY, "O");
                }
            }
        }
    }

    public void tiltEast() {
        for (int y = 0; y < map.size(); y++) {
            for (int x = map.get(y).size()-1; x > -1; x--) {
                String item = getCoordinate(x,y);
                if (Objects.equals(item, "O")) {
                    int moveX = raycastEast(x, y);
                    int moveY = y;

                    setCoordinate(x, y, ".");
                    setCoordinate(moveX, moveY, "O");
                }
            }
        }
    }

    public void tiltWest() {
        for (int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.get(y).size(); x++) {
                String item = getCoordinate(x,y);
                if (Objects.equals(item, "O")) {
                    int moveX = raycastWest(x, y);
                    int moveY = y;

                    setCoordinate(x, y, ".");
                    setCoordinate(moveX, moveY, "O");
                }
            }
        }
    }

    public void setCoordinate(int x, int y, String item) {
        ArrayList<String> tempLine = map.get(y);
        tempLine.set(x, item);
        map.set(y, map.get(y));
    }

    public int raycastNorth(int x, int y) {
        int moveCount = 0;
        for (int i = y-1; i > -1; i--) {
            if (!Objects.equals(getCoordinate(x, i), ".")) {
                return y-moveCount;
            }
            moveCount++;
        }
        return y-moveCount;
    }
    public int rayCastSouth(int x, int y) {
        int moveCount = 0;
        for (int i = y+1; i < map.size(); i++) {
            if (!Objects.equals(getCoordinate(x, i), ".")) {
                return y+moveCount;
            }
            moveCount++;
        }
        return y+moveCount;
    }

    public int raycastWest(int x, int y) {
        int moveCount = 0;
        for (int i = x-1; i > -1; i--) {
            if (!Objects.equals(getCoordinate(i, y), ".")) {
                return x-moveCount;
            }
            moveCount++;
        }
        return x-moveCount;
    }

    public int raycastEast(int x, int y) {
        int moveCount = 0;
        for (int i = x+1; i < map.get(y).size(); i++) {
            if (!Objects.equals(getCoordinate(i, y), ".")) {
                return x+moveCount;
            }
            moveCount++;
        }
        return x+moveCount;
    }
}
