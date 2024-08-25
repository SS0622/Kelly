package tool;

import java.util.ArrayList;
import java.util.List;

public class LogHolder {
    private static final List<String> logs = new ArrayList<>();

    public static void addLog(String message) {
        logs.add(message);
    }

    public static List<String> getLogs() {
        return new ArrayList<>(logs); // 変更を避けるためにコピーを返す
    }
}
