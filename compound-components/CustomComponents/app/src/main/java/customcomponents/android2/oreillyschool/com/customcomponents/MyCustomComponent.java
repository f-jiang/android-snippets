package customcomponents.android2.oreillyschool.com.customcomponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/**
 * Created by feilan on 23/09/17.
 */

public class MyCustomComponent extends FrameLayout implements View.OnClickListener {

    private ToggleButton mButton01;
    private ToggleButton mButton02;
    private ToggleButton mButton03;
    private ToggleButton mSelectedToggleButton;

    public MyCustomComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public MyCustomComponent(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        inflate(context, R.layout.my_custom_component_view, this);

        mButton01 = (ToggleButton) findViewById(R.id.button01);
        mButton02 = (ToggleButton) findViewById(R.id.button02);
        mButton03 = (ToggleButton) findViewById(R.id.button03);

        mButton01.setOnClickListener(this);
        mButton02.setOnClickListener(this);
        mButton03.setOnClickListener(this);

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomComponent, defStyle, 0);

        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.MyCustomComponent_defaultButtonIndex:
                    int index = a.getInt(attr, 0);
                    switch (index) {
                        case 1:
                            mSelectedToggleButton = mButton02;
                            break;
                        case 2:
                            mSelectedToggleButton = mButton03;
                            break;
                        default:
                            mSelectedToggleButton = mButton01;
                            break;
                    }
                    mSelectedToggleButton.setChecked(true);
                    break;
            }
        }
        a.recycle();
    }

    @Override
    public void onClick(View v) {
        mSelectedToggleButton.setChecked(false);
        mSelectedToggleButton = (ToggleButton) v;
        mSelectedToggleButton.setChecked(true);
    }

}
