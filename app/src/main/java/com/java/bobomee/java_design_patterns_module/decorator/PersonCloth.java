package com.java.bobomee.java_design_patterns_module.decorator;

/**
 * Created on 16/8/28.下午6:06.
 *
 * @author bobomee.
 * @description:
 */
public class PersonCloth extends Person {
  protected Person mPerson;

  public PersonCloth(Person _person) {
    mPerson = _person;
  }

  @Override public void dressed() {
    mPerson.dressed();
  }
}
