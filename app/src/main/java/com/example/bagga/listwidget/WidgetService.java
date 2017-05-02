package com.example.bagga.listwidget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by bagga on 2017-05-01.
 */

public class WidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        return new WidgetAdapter(this);
    }
}
