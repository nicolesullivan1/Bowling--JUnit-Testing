package main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyTests {
//Testing return method calculateRolls
  @Test
  public void rollsAllStrikes() {
    //Test to calculate total rolls for rolling all Strikes
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-XXX");
		assertEquals(12, test.calculateRolls("X-X-X-X-X-X-X-X-X-XXX"));
  }

  @Test
  public void rollsAllSpares() {
    //Test to calculate total rolls for rolling all Spares
		CalculateScore test = new CalculateScore ("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/0");
		assertEquals(21, test.calculateRolls("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/0"));
  }

  @Test
  public void rollsAllOpenFrames() {
    //Test to calculate total rolls for rolling all Open Frames
		CalculateScore test = new CalculateScore ("12-12-12-12-12-12-12-12-12-12");
		assertEquals(20, test.calculateRolls("12-12-12-12-12-12-12-12-12-12"));
  }

  @Test
  public void rollsXSparesOFs() {
    //Test to calculate total rolls for rolling strikes, spares, and open frames
		CalculateScore test = new CalculateScore ("12-X-9/-12-X-9/-23-5/-20-12");
		assertEquals(18, test.calculateRolls("12-X-9/-12-X-9/-23-5/-20-12"));
  }

  @Test
  public void rollsXSpares() {
    //Test to calculate total rolls for rolling strikes and spares
		CalculateScore test = new CalculateScore ("X-X-9/-X-X-9/-X-5/-X-XXX");
		assertEquals(15, test.calculateRolls("X-X-9/-X-X-9/-X-5/-X-XXX"));
  }

  @Test
  public void rollsSparesOFs() {
    //Test to calculate total rolls for rolling spares and open frames
		CalculateScore test = new CalculateScore ("9/-23-9/-5/-72-22-7/-12-44-50");
		assertEquals(20, test.calculateRolls("9/-23-9/-5/-72-22-7/-12-44-50"));
  }

  @Test
  public void strikesOFs() {
    //Test to calculate total rolls for rolling strikes and open frames
		CalculateScore test = new CalculateScore ("X-23-X-X-72-22-X-12-44-50");
		assertEquals(16, test.calculateRolls("X-23-X-X-72-22-X-12-44-50"));
  }

//Testing overall Calculations
  @Test
  public void perfectGame() {
    //Testing score for perfect game 
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-XXX");
		assertEquals(300, test.getTotal());
  }

  @Test
  public void addUpToNine() {
    //Testing score for frames that add up to 9
		CalculateScore test = new CalculateScore ("45-54-36-27-09-63-81-18-90-72");
		assertEquals(90, test.getTotal());
  }

  @Test
  public void sparesOf5() {
    //Testing score for frames that add up to spares
		CalculateScore test = new CalculateScore ("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/0");
		assertEquals(145, test.getTotal());
  }

  @Test
  public void gameOfZero() {
    //Testing score for game of zero
		CalculateScore test = new CalculateScore ("00-00-00-00-00-00-00-00-00-00");
		assertEquals(0, test.getTotal());
  }

  @Test
  public void tenthFrameOF() {
    //Testing score for all strikes and one OF
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-10");
		assertEquals(243, test.getTotal());
  }

  @Test
  public void tenthFrameSpare() {
    //Testing score for all strikes an one spare
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-7/3");
		assertEquals(270, test.getTotal());
  }

  @Test
  public void tenthFrameStrike() {
    //Testing score for all strikes then one OF
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-X01");
		assertEquals(271, test.getTotal());
  }

  @Test
  public void rollsSparesAndX() {
    //Testing score for all spares and one strike
		CalculateScore test = new CalculateScore ("X-9/-X-9/-X-9/-X-9/-X-9/1");
		assertEquals(191, test.getTotal());
  }

  @Test
  public void rollsVarious() {
    //Testing score for various frames
		CalculateScore test = new CalculateScore ("X-9/-X-11-X-9/-X-11-X-9/1");
		assertEquals(139, test.getTotal());
  }

  @Test
  public void strikesAndOFs() {
    //Testing score for mixture of strikes and OFs
		CalculateScore test = new CalculateScore ("X-90-X-90-X-90-X-90-X-90");
		assertEquals(140, test.getTotal());
  }
}