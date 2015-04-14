package lib.test.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by arnold_lin on 2015/4/14.
 */
public class TestDraw extends TextView {

    private float limit =0;
    private float p = 0;
    private float x = 0;
    private float r;
    public TestDraw(Context context) {
        super(context);
    }

    public TestDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestDraw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public TestDraw(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(r == 0) {
            r = canvas.getWidth() < canvas.getHeight() ? canvas.getWidth() : canvas.getHeight();
            r = r / 2;
        }
        if(limit == 0){
            limit = canvas.getWidth();
            p = canvas.getWidth() * 0.1f;
            x = - r;
        }
        
        float cy = r;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(android.R.color.white));
        canvas.drawCircle(x,cy,r,paint);
        
        if(x < limit + r){
            x = x + p ;
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
    }
}
