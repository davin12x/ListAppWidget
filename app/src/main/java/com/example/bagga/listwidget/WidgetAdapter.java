package com.example.bagga.listwidget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;

/**
 * Created by bagga on 2017-05-01.
 */

public class WidgetAdapter implements RemoteViewsService.RemoteViewsFactory {
    private Context context;
    private ArrayList<String> stringList;

    public WidgetAdapter(Context context) {
        this.context = context;
        stringList = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            stringList.add(Integer.toString(i));
        }
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.list_item);
        remoteViews.setTextViewText(R.id.textView, stringList.get(position));

        Intent intent = new Intent();
        intent.putExtra(WidgetProvider.KEY_ITEM, stringList.get(position));
        remoteViews.setOnClickFillInIntent(R.id.list_item, intent);
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
