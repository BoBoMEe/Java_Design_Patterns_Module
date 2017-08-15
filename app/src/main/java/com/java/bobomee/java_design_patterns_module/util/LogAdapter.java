package com.java.bobomee.java_design_patterns_module.util;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.java.bobomee.java_design_patterns_module.R;
import java.util.List;

public class LogAdapter
      extends ArrayAdapter<String> {

    public LogAdapter(Context context, List<String> logs) {
        super(context, R.layout.item_log, R.id.item_log, logs);
    }
}
