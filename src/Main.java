import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(PuzzleInput.testInput);
        int cycleCount = 1000000000;
        for (int i = 0; i < cycleCount; i++) {
            System.out.print(String.format("\r%s", progressBar(i, cycleCount)));

            map.tiltNorth();
            map.tiltWest();
            map.tiltSouth();
            map.tiltEast();
            //System.out.println(map.getReadableMap());
        }
        System.out.println(map.getReadableMap()); // Not necessary, just looks cool :)
        System.out.println(calculateTotalLoad(map));
    }

    public static String progressBar(int currentValue, int maxValue) {
        int progressBarLength = 201; //
        if (progressBarLength < 9 || progressBarLength % 2 == 0) {
            throw new ArithmeticException("formattedPercent.length() = 9! + even number of chars (one for each side)");
        }
        int currentProgressBarIndex = (int) Math.ceil(((double) progressBarLength / maxValue) * currentValue);
        String formattedPercent = String.format(" %5.1f %% ", (100 * currentProgressBarIndex) / (double) progressBarLength);
        int percentStartIndex = ((progressBarLength - formattedPercent.length()) / 2);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int progressBarIndex = 0; progressBarIndex < progressBarLength; progressBarIndex++) {
            if (progressBarIndex <= percentStartIndex - 1
                    ||  progressBarIndex >= percentStartIndex + formattedPercent.length()) {
                sb.append(currentProgressBarIndex <= progressBarIndex ? " " : "=");
            } else if (progressBarIndex == percentStartIndex) {
                sb.append(formattedPercent);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static int calculateTotalLoad(Map map) {
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
        return totalLoad;
    }
}