package main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyTests {
//Testing return method CalculateRolls
  @Test
  public void RollsAllStrikes() {
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-XXX");
		assertEquals(12, test.CalculateRolls("X-X-X-X-X-X-X-X-X-XXX"));
  }

  @Test
  public void RollsAllSpares() {
		CalculateScore test = new CalculateScore ("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/0");
		assertEquals(21, test.CalculateRolls("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/0"));
  }

  @Test
  public void RollsAllOpenFrames() {
		CalculateScore test = new CalculateScore ("12-12-12-12-12-12-12-12-12-12");
		assertEquals(20, test.CalculateRolls("12-12-12-12-12-12-12-12-12-12"));
  }

  @Test
  public void RollsXSparesOFs() {
		CalculateScore test = new CalculateScore ("12-X-9/-12-X-9/-23-5/-20-12");
		assertEquals(18, test.CalculateRolls("12-X-9/-12-X-9/-23-5/-20-12"));
  }

  @Test
  public void RollsXSpares() {
		CalculateScore test = new CalculateScore ("X-X-9/-X-X-9/-X-5/-X-XXX");
		assertEquals(15, test.CalculateRolls("X-X-9/-X-X-9/-X-5/-X-XXX"));
  }

  @Test
  public void RollsSparesOFs() {
		CalculateScore test = new CalculateScore ("9/-23-9/-5/-72-22-7/-12-44-50");
		assertEquals(20, test.CalculateRolls("9/-23-9/-5/-72-22-7/-12-44-50"));
  }

  @Test
  public void StrikesOFs() {
		CalculateScore test = new CalculateScore ("X-23-X-X-72-22-X-12-44-50");
		assertEquals(16, test.CalculateRolls("X-23-X-X-72-22-X-12-44-50"));
  }

//Testing overall Calculations
  @Test
  public void PerfectGame() {
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-XXX");
		assertEquals(300, test.GetTotal());
  }

  @Test
  public void AddUpToNine() {
		CalculateScore test = new CalculateScore ("45-54-36-27-09-63-81-18-90-72");
		assertEquals(90, test.GetTotal());
  }

  @Test
  public void SparesOf5() {
		CalculateScore test = new CalculateScore ("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/0");
		assertEquals(145, test.GetTotal());
  }

  @Test
  public void GameOfZero() {
		CalculateScore test = new CalculateScore ("00-00-00-00-00-00-00-00-00-00");
		assertEquals(0, test.GetTotal());
  }

  @Test
  public void TenthFrameOF() {
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-10");
		assertEquals(243, test.GetTotal());
  }

  @Test
  public void TenthFrameSpare() {
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-7/3");
		assertEquals(270, test.GetTotal());
  }

  @Test
  public void TenthFrameStrike() {
		CalculateScore test = new CalculateScore ("X-X-X-X-X-X-X-X-X-X01");
		assertEquals(271, test.GetTotal());
  }

  @Test
  public void RollsSparesAndX() {
		CalculateScore test = new CalculateScore ("X-9/-X-9/-X-9/-X-9/-X-9/1");
		assertEquals(191, test.GetTotal());
  }

  @Test
  public void RollsVarious() {
		CalculateScore test = new CalculateScore ("X-9/-X-11-X-9/-X-11-X-9/1");
		assertEquals(139, test.GetTotal());
  }

  @Test
  public void StrikesAndOFs() {
		CalculateScore test = new CalculateScore ("X-90-X-90-X-90-X-90-X-90");
		assertEquals(140, test.GetTotal());
  }
}