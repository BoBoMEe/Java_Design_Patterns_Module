package com.java.bobomee.java_design_patterns_module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bobomee.android.recyclerviewhelper.expandable.TreeNode;
import com.bobomee.android.recyclerviewhelper.expandable.TreeViewAdapter;
import com.bobomee.android.recyclerviewhelper.expandable.interfaces.LayoutItemType;
import com.bobomee.android.recyclerviewhelper.expandable.interfaces.OnTreeNodeClickListener;
import com.java.bobomee.java_design_patterns_module.abstactfactory.AbstractFactoryActivity;
import com.java.bobomee.java_design_patterns_module.adapter.AdapterActivity;
import com.java.bobomee.java_design_patterns_module.bridge.BridgeActivity;
import com.java.bobomee.java_design_patterns_module.builder.BuilderActivity;
import com.java.bobomee.java_design_patterns_module.chain.ChainActivity;
import com.java.bobomee.java_design_patterns_module.command.CommandActivity;
import com.java.bobomee.java_design_patterns_module.composite.CompositeActivity;
import com.java.bobomee.java_design_patterns_module.decorator.DecoratorActivity;
import com.java.bobomee.java_design_patterns_module.expand.Folder;
import com.java.bobomee.java_design_patterns_module.expand.FolderBinder;
import com.java.bobomee.java_design_patterns_module.expand.Item;
import com.java.bobomee.java_design_patterns_module.expand.ItemBinder;
import com.java.bobomee.java_design_patterns_module.facade.FacadeActivity;
import com.java.bobomee.java_design_patterns_module.factorymethod.FactoryMethodActivity;
import com.java.bobomee.java_design_patterns_module.flyweight.FlyweightActivity;
import com.java.bobomee.java_design_patterns_module.interpreter.InterpreterActivity;
import com.java.bobomee.java_design_patterns_module.iterator.IteratorActivity;
import com.java.bobomee.java_design_patterns_module.mediator.MediatorActivity;
import com.java.bobomee.java_design_patterns_module.memento.NoteActivity;
import com.java.bobomee.java_design_patterns_module.observer.ObservableActivity;
import com.java.bobomee.java_design_patterns_module.prototype.CloneActivity;
import com.java.bobomee.java_design_patterns_module.proxy.ProxyActivity;
import com.java.bobomee.java_design_patterns_module.singleton.SingletonActivity;
import com.java.bobomee.java_design_patterns_module.state.StateActivity;
import com.java.bobomee.java_design_patterns_module.stragety.TranficCal;
import com.java.bobomee.java_design_patterns_module.template.TemplateActivity;
import com.java.bobomee.java_design_patterns_module.visitor.VisitorAcitivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {

  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
  private List<TreeNode> mTreeNodes = new ArrayList<>();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    initDatas();
    initViews();
  }

  private void initViews() {

    mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

    TreeViewAdapter treeViewAdapter =
        new TreeViewAdapter(mTreeNodes, Arrays.asList(new FolderBinder(), new ItemBinder()));
    mRecyclerView.setAdapter(treeViewAdapter);

    treeViewAdapter.addOnTreeNodeClickListener(new OnTreeNodeClickListener() {
      @Override public void onClick(TreeNode node, RecyclerView.ViewHolder holder) {
        if (node.isLeaf()) {

          LayoutItemType content = node.getContent();
          if (content instanceof Item) {
            Item item = (Item) content;
            String title = item.getName();

            Intent intent = new Intent(mActivity, item.getMClass());
            intent.putExtra(BaseActivity.KEY_TITLE, title);
            startActivity(intent);
          }
        }
      }
    });
  }

  private void initDatas() {

    String[] mCategorys = new String[] {
        "创建型",//
        "结构型", //
        "行为型"//
    };

    String[] create = {
        "工厂方法",//
        "抽象工厂", //
        "单例", //
        "构造者", //
        "原型"//
    };

    Class[] _create = {
        FactoryMethodActivity.class,//
        AbstractFactoryActivity.class, //
        SingletonActivity.class,//
        BuilderActivity.class,//
        CloneActivity.class, //
    };

    String[] structure = {
        "适配器", //
        "装饰器", //
        "代理", //
        "外观", //
        "桥接", //
        "组合", //
        "享元"//
    };

    Class[] _structure = {
        AdapterActivity.class, //
        DecoratorActivity.class, //
        ProxyActivity.class,//
        FacadeActivity.class, //
        BridgeActivity.class, //
        CompositeActivity.class,//
        FlyweightActivity.class,//
    };

    String[] behavior = {
        "策略", //
        "模板", //
        "观察者", //
        "迭代器", //
        "责任链", //
        "命令",//
        "备忘录",//
        "状态", //
        "访问者", //
        "中介者", //
        "解释器"//
    };
    Class[] _behavior = {
        TranficCal.class,//
        TemplateActivity.class,//
        ObservableActivity.class,//
        IteratorActivity.class,//
        ChainActivity.class,//
        CommandActivity.class,//
        NoteActivity.class, //
        StateActivity.class, //
        VisitorAcitivity.class,//
        MediatorActivity.class, //
        InterpreterActivity.class
    };

    ///////////
    TreeNode<Folder> ct = new TreeNode<>(new Folder(mCategorys[0]));
    for (int i = 0; i < create.length; i++) {
      Item item = new Item(create[i], _create[i]);
      TreeNode<Item> itemTreeNode = new TreeNode<>(item);
      ct.addChild(itemTreeNode);
    }
    mTreeNodes.add(ct);

    TreeNode<Folder> st = new TreeNode<>(new Folder(mCategorys[1]));
    for (int i = 0; i < structure.length; i++) {
      Item item = new Item(structure[i], _structure[i]);
      TreeNode<Item> itemTreeNode = new TreeNode<>(item);
      st.addChild(itemTreeNode);
    }
    mTreeNodes.add(st);

    TreeNode<Folder> bt = new TreeNode<>(new Folder(mCategorys[2]));
    for (int i = 0; i < behavior.length; i++) {
      Item item = new Item(behavior[i], _behavior[i]);
      TreeNode<Item> itemTreeNode = new TreeNode<>(item);
      bt.addChild(itemTreeNode);
    }
    mTreeNodes.add(bt);
  }
}
