package com.pathashala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {
  @Test
  void expectAliveStatusToStayAlive() {
    assertTrue(new Status(true).isAlive());
  }

  @Test
  void expectDeadStatusToStayDead() {
    assertFalse(new Status(false).isAlive());
  }

  @Test
  void expectEqualAliveStatusToBeEqual() {
    assertEquals(new Status(true), new Status(true));
  }

  @Test
  void expectUnequalAliveStatusToBeUnequal() {
    assertNotEquals(new Status(false), new Status(true));
  }

  @Test
  void expectEqualAliveStatusToHaveEqualHashcode() {
    assertEquals(new Status(true).hashCode(), new Status(true).hashCode());
  }

  @Test
  void expectUnequalAliveStatusToHaveUnequalHashcode() {
    assertNotEquals(new Status(true).hashCode(), new Status(false).hashCode());
  }
}