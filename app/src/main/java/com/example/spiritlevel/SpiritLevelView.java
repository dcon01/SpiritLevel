package com.example.spiritlevel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class SpiritLevelView extends View {

    private int width, height;
    private Point center;
    private PointF bubble;
    private Paint paint;

    public SpiritLevelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);

        center = new Point(0, 0);
        bubble = new PointF(0, 0);


        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;
        center.x = w / 2;
        center.y = h / 2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(bubble.x, bubble.y, 100, paint);
    }

    public void setBubble(float x, float y) {
        bubble.x = center.x + x / 9.81f * width;
        bubble.y = center.y + y / 9.81f * height;
        Log.i("SpiritLevelView", bubble.toString());

        invalidate();


    }
}
