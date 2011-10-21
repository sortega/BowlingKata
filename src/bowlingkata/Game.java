package bowlingkata;

public class Game {
   private static final int GAME_FRAMES = 10;

   private Frame firstFrame;

   public Game() {
      this.firstFrame = createLinkedFrames(GAME_FRAMES);
   }

   private Frame createLinkedFrames(int number) {
      if (number == 1)
         return new FinalFrame();
      else
         return new NormalFrame(createLinkedFrames(number - 1));
   }

   public void roll(int pins) {
      firstFrame.roll(pins);
   }

   public int score() {
      return firstFrame.score();
   }
}
