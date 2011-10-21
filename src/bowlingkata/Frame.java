package bowlingkata;

import java.util.*;

public abstract class Frame {
   private List<Integer> rolls;
   private int pins;

   public Frame() {
      this.rolls = new ArrayList<Integer>();
      this.pins = 0;
   }

   public int getPins() {
      return pins;
   }

   protected void addRoll(int p) {
      rolls.add(p);
      pins += p;
   }

   protected int numRolls() {
      return rolls.size();
   }

   protected int sumNextRolls(int numRolls) {
      int bonus = 0;
      for (int i=0; i<rolls.size() && i<numRolls; i++)
         bonus += rolls.get(i);
      return bonus;
   }

   public abstract void roll(int pins);

   public abstract boolean isComplete();

   public abstract int score();

   public abstract Frame getNextFrame();
}
