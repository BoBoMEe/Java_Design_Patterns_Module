package com.java.bobomee.java_design_patterns_module.bridge;

/**
 * Created on 16/9/4.下午10:34.
 *
 * @author bobomee.
 * @description:
 */
public class Sugar extends CoffeeAdditives {
  @Override public String addSomething() {
    return "加糖";
  }
}
