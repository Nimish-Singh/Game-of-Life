package com.pathashala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellStatusTest {
  @Test
  void expectAliveStatusToStayAlive() {
    assertTrue(new CellStatus(true).isAlive());
  }

  @Test
  void expectDeadStatusToStayDead() {
    assertFalse(new CellStatus(false).isAlive());
  }

  @Test
  void expectEqualAliveStatusToBeEqual() {
    assertEquals(new CellStatus(true), new CellStatus(true));
  }

  @Test
  void expectUnequalAliveStatusToBeUnequal() {
    assertNotEquals(new CellStatus(false), new CellStatus(true));
  }

  @Test
  void expectEqualAliveStatusToHaveEqualHashcode() {
    assertEquals(new CellStatus(true).hashCode(), new CellStatus(true).hashCode());
  }

  @Test
  void expectUnequalAliveStatusToHaveUnequalHashcode() {
    assertNotEquals(new CellStatus(true).hashCode(), new CellStatus(false).hashCode());
  }
}