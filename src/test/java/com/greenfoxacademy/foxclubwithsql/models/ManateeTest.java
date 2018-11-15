package com.greenfoxacademy.foxclubwithsql.models;

import com.greenfoxacademy.foxclubwithsql.models.enums.Gender;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManateeTest {

    Manatee manatee = new Manatee("Lenke", Gender.FEMALE);

    @Test
    public void getName() {
      String expected = "Lenke";
      String result = manatee.getName();

      assertEquals(expected, result);
    }

    @Test
    public void getGender() {
      Gender expected = Gender.FEMALE;
      Gender result = manatee.getGender();

      assertEquals(expected, result);
    }
  }
