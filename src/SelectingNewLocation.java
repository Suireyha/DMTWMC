import java.util.ArrayList;
import java.util.Optional;

public class SelectingNewLocation implements State {

    Stage stage;

    public SelectingNewLocation(Stage stage) {
        this.stage = stage;
    }

    public void paint(){}

    public void mouseClicked(int x, int y) {
        Optional<Cell> clicked = Optional.empty();
        for(Cell c: stage.cellOverlay) {
          if(c.contains(x, y)) {
            clicked = Optional.of(c);
          }
        }
        stage.cellOverlay = new ArrayList<Cell>();
        if(clicked.isPresent() && stage.playerInAction.isPresent()) {
          stage.playerInAction.get().setLocation(clicked.get());
          stage.playerInAction.get().turns--;
          int humansWithMovesLeft = 0;
          for(Actor player: stage.listOfPlayers) {
            if(!player.isBot() && player.turns > 0) {
              humansWithMovesLeft++;
            }
          }
          if(humansWithMovesLeft > 0) {
            stage.currentState = stage.choosingActorState;
          } else {
            stage.currentState = stage.botMovingState;
          }
        }
}

}