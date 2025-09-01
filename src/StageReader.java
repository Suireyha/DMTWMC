import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StageReader {
  public static Stage readStage(String path) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(path));
    Stage stage = new Stage(lines);
    return stage;
  }
}