import lgcns.inspire.game.GuessGame;

public class GuessGameApp {
    
    public static void main(String[] args) {
        int answer = GuessGame.generatorNan();
        System.out.println(answer);
        
        GuessGame game = new GuessGame();
        String result = game.gameStart(answer);
        
        System.out.println(result);


    }
}
