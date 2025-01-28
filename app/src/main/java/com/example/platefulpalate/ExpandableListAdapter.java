package com.example.platefulpalate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.BaseExpandableListAdapter;
import com.example.platefulpalate.R;
import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> recipeTitles;
    private HashMap<String, List<String>> recipeDetails;

    public ExpandableListAdapter(Context context, List<String> recipeTitles, HashMap<String, List<String>> recipeDetails) {
        this.context = context;
        this.recipeTitles = recipeTitles;
        this.recipeDetails = recipeDetails;
    }

    @Override
    public int getGroupCount() {
        return recipeTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return recipeDetails.get(recipeTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return recipeTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return recipeDetails.get(recipeTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String recipeTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_expandable_group, parent, false);
        }
        TextView groupTitle = convertView.findViewById(R.id.groupTitle);
        groupTitle.setText(recipeTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String step = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_expandable_child, parent, false);
        }
        TextView childText = convertView.findViewById(R.id.childText);
        childText.setText(step);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
