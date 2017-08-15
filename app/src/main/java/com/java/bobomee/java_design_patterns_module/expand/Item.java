/*
 * Copyright (C) 2016.  BoBoMEe(wbwjx115@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.java.bobomee.java_design_patterns_module.expand;

import com.bobomee.android.recyclerviewhelper.expandable.interfaces.LayoutItemType;
import com.java.bobomee.java_design_patterns_module.R;

/**
 * Created on 2016/12/19.上午9:48.
 *
 * @author bobomee.
 */

public class Item implements LayoutItemType {
  @Override public int getLayoutId() {
    return R.layout.child_layout;
  }

  private String name;

  private Class<?> mClass;

  public Item(String name, Class<?> aClass) {
    this.name = name;
    mClass = aClass;
  }

  public String getName() {
    return name;
  }

   public Class<?> getMClass() {
    return mClass;
  }
}
