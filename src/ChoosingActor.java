import java.util.Optional;

public class ChoosingActor implements State {
    Stage stage;
    
    public ChoosingActor(Stage stage){
        this.stage = stage;
    }
   
    public void paint(){}

    public void mouseClicked(int x, int y){
        stage.playerInAction = Optional.empty();
        for(Actor player: stage.listOfPlayers) {
          if(player.loc.contains(x, y) && !player.isBot()) {
            stage.cellOverlay = stage.grid.getRadius(player.loc, player.moves);
            stage.playerInAction = Optional.of(player);
            stage.currentState = State.selectingNewLocationState;
            }
        }
    }
} 