package bowlingkata;

public class FinalFrame extends Frame {

   @Override
   public boolean isComplete() {
      return false;
   }

   @Override
   public int score() {
      return getPins();
   }

   @Override
   public Frame getNextFrame() {
      return null;
   }

   @Override
   public void roll(int pins) {
      addRoll(pins);
   }

}
