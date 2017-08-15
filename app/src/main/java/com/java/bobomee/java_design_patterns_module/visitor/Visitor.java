package com.java.bobomee.java_design_patterns_module.visitor;

/**
 * Created on 16/8/27.下午1:13.
 *
 * @author bobomee.
 * @description:
 */
public interface Visitor {

  void visit(Engineer _engineer);

  void visit(Manager _manager);
}
