package com.java.bobomee.java_design_patterns_module.stragety;

/**
 * Created on 16/8/16.下午11:18.
 *
 * @author bobomee.
 * @description:
 */
public class SubCal implements Calculate {
  @Override public int calculate(int km) {
    return 5*km;
  }
}
