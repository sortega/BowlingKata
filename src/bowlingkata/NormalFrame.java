package bowlingkata;

public class NormalFrame extends Frame {
   private final Frame nextFrame;

   public NormalFrame(Frame nextFrame) {
      this.nextFrame = nextFrame;
   }

   @Override
   public Frame getNextFrame() {
      return this.nextFrame;
   }

   private boolean isStrike() {
      return getPins() == 10 && numRolls() == 1;
   }

   private boolean isSpare() {
      return getPins() == 10 && numRolls() == 2;
   }

   @Override
   public int sumNextRolls(int nextRolls) {
      int bonus = super.sumNextRolls(nextRolls);
      if (this.numRolls() < nextRolls)
         bonus += nextFrame.sumNextRolls(nextRolls - this.numRolls());
      return bonus;
   }

   private int bonus() {
      if (this.isStrike())
         return nextFrame.sumNextRolls(2);
      else if (this.isSpare())
         return nextFrame.sumNextRolls(1);
      else
         return 0;
   }

   @Override
   public int score() {
      System.out.println(getPins() + bonus());
      return getPins() + bonus() + nextFrame.score();
   }

   @Override
   public boolean isComplete() {
      return this.isStrike() || numRolls() >= 2;
   }

   @Override
   public void roll(int pins) {
      if (this.isComplete())
         nextFrame.roll(pins);
      else
         addRoll(pins);
   }

}
