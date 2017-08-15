package com.java.bobomee.java_design_patterns_module.bridge;

/**
 * Created on 16/9/4.下午10:36.
 *
 * @author bobomee.
 * @description:
 */
public class Ordinary extends CoffeeAdditives {
  @Override public String addSomething() {
    return "原味";
  }
}
