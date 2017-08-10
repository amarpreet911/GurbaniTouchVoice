package starter.app.design.com.dgn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by amarpreet911 on 14/07/16.
 */

public class BaniTextView extends TextView {
    Context context;
    public BaniTextView(Context context) {
        super(context);
        this.context = context;
    }

    public BaniTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

  /*  @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }*/

    @Override
    public void draw(Canvas canvas) {
        Paint strokePaint = new Paint();
        strokePaint.setARGB(255, 0, 0, 0);
        strokePaint.setTextAlign(Paint.Align.CENTER);
        strokePaint.setTextSize(16);
        strokePaint.setTypeface(Typeface.DEFAULT_BOLD);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(2);

        Paint textPaint = new Paint();
        textPaint.setARGB(255, 255, 255, 255);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(16);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);

        canvas.drawText("Some Text", 100, 100, strokePaint);
        canvas.drawText("Some Text", 100, 100, textPaint);

        super.draw(canvas);
    }

}

