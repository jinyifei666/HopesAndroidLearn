package top.jinyifei.hopes.ui.kongjian;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

//ExpandableList - 可展开/收缩列表
//继承 ExpandableListActivity 以实现列表的可展开/收缩的功能

public class HopesExpandable extends ExpandableListActivity {

    private ExpandableListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setTitle("ExpandableList");

        mAdapter = new MyExpandableListAdapter();
        setListAdapter(mAdapter);
        registerForContextMenu(this.getExpandableListView());
    }

    // 为列表的每一项创建上下文菜单（即长按后呼出的菜单）
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("ContextMenu");
        menu.add(0, 0, 0, "ContextMenu");
    }

    // 单击上下文菜单后的逻辑
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo) item.getMenuInfo();
        String title = ((TextView) info.targetView).getText().toString();

        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
            int childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);

            Toast.makeText(this, title + " - Group Index: " + groupPos + " Child Index: " + childPos, Toast.LENGTH_SHORT).show();

            return true;
        } else if (type == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
            Toast.makeText(this, title + " - Group Index: " + groupPos, Toast.LENGTH_SHORT).show();

            return true;
        }

        return false;
    }

    public class MyExpandableListAdapter extends BaseExpandableListAdapter {

        // 父列表数据
        private String[] groups =
                {
                        "group1",
                        "group2",
                        "group3",
                        "group4"
                };
        // 子列表数据
        private String[][] children =
                {
                        { "child1" },
                        { "child1", "child2" },
                        { "child1", "child2", "child3" },
                        { "child1", "child2", "child3", "child4" }
                };

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        // 取子列表中的某一项的 View
        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        // 取父列表中的某一项的 View
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        // 获取某一项的 View 的逻辑
        private TextView getGenericView() {
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 48);
            TextView textView = new TextView(HopesExpandable.this);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setPadding(32, 0, 0, 0);
            return textView;
        }
    }
}
