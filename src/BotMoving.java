import java.util.List;
import java.util.Random;

public class BotMoving implements State{
    Stage stage;

    public BotMoving(Stage stage){
        this.stage = stage;
    }
    
    public void paint(){
      for(Actor player: stage.listOfPlayers) {
        if(player.isBot()) {
          List<Cell> possibleLocs = stage.getClearRadius(player.loc, player.moves);
          int moveBotChooses = (new Random()).nextInt(possibleLocs.size());
          player.setLocation(possibleLocs.get(moveBotChooses));
        }
      }
      stage.setState(stage.choosingActorState);
      for(Actor player: stage.listOfPlayers) {
        player.turns = 1;
      }
    }

    public void mouseClicked(int x, int y){
    }
}
