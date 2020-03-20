package jp.ac.seiko.kito.simplecalculatorkenta2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ServiceConfigurationError;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextViewAnswer;
    private TextView mTextViewFormula;
    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButtonPlus;
    private Button mButtonMinus;
    private Button mButtonMultiply;
    private Button mButtonDivide;
    private Button mButtonEqual;
    private Button mButtonClear;

    int mProcessValue = 1;
    int mOperationValue = 0;
    int mNumber = 0;
    String mFirstValue = "";
    String mSecondValue = "";


    private void init() {
        mProcessValue = 0;
        mOperationValue = 0;
        mNumber = 0;
        mFirstValue = "";
        mSecondValue = "";
        mTextViewFormula.setText("");
        mTextViewAnswer.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewAnswer = findViewById(R.id.textView_answer);
        mTextViewFormula = findViewById(R.id.textView_formula);
        mButton0 = findViewById(R.id.button_0);
        mButton1 = findViewById(R.id.button_1);
        mButton2 = findViewById(R.id.button_2);
        mButton3 = findViewById(R.id.button_3);
        mButton4 = findViewById(R.id.button_4);
        mButton5 = findViewById(R.id.button_5);
        mButton6 = findViewById(R.id.button_6);
        mButton7 = findViewById(R.id.button_7);
        mButton8 = findViewById(R.id.button_8);
        mButton9 = findViewById(R.id.button_9);
        mButtonPlus = findViewById(R.id.button_plus);
        mButtonMinus = findViewById(R.id.button_minus);
        mButtonMultiply = findViewById(R.id.button_multiply);
        mButtonDivide = findViewById(R.id.button_divide);
        mButtonEqual = findViewById(R.id.button_equal);
        mButtonClear = findViewById(R.id.button_clear);

        Button[] allButtons = {
                mButton0,
                mButton1,
                mButton2,
                mButton3,
                mButton4,
                mButton5,
                mButton6,
                mButton7,
                mButton8,
                mButton9,
                mButtonPlus,
                mButtonMinus,
                mButtonMultiply,
                mButtonDivide,
                mButtonEqual,
                mButtonClear

        };
        for (Button button : allButtons) {
            button.setOnClickListener(this);
        }
    }
    private String Symbol() {
        String symbol = "";
        switch (mOperationValue) {
            case 1:
                symbol = " + ";
                break;
            case 2:
                symbol = " - ";
                break;
            case 3:
                symbol = " × ";
                break;
            case 4:
                symbol = " ÷ ";
                break;
        }
        return symbol;
    }

    private void Answer() {
        String AnswerValue = "";
        int f = Integer.parseInt(mFirstValue);
        int s = Integer.parseInt(mSecondValue);
        switch (mOperationValue) {
            case 1://足し算
                AnswerValue = String.valueOf(f + s);
                break;
            case 2://引き算
                AnswerValue = String.valueOf(f - s);
                break;
            case 3://掛け算
                AnswerValue = String.valueOf(f * s);
                break;
            case 4://割り算
                AnswerValue = String.valueOf(f / s);
                break;
        }
        mTextViewAnswer.setText(AnswerValue);
    }

    private void Process() {
        switch (mProcessValue) {
            case 1:
                switch (mOperationValue) {
                    case 0:
                        if (mFirstValue.equals("0")) {
                            mFirstValue = String.valueOf(mNumber);
                        } else {
                            mFirstValue += mNumber;
                        }
                        mTextViewFormula.setText(mFirstValue);
                        break;
                    case 5:
                        mTextViewAnswer.setText("");
                        mOperationValue = 0;
                        mFirstValue += mNumber;
                        mTextViewFormula.setText(mFirstValue);
                        break;
                     default:
                         if (mSecondValue.equals("0")) {
                             mSecondValue = String.valueOf(mNumber);
                         } else {
                             mSecondValue += mNumber;
                         }
                         mTextViewFormula.setText(mFirstValue + Symbol() + mSecondValue);
                }
                mNumber = 0;
                break;
            case 2:
                if (mFirstValue.equals("")) {
                    if (mOperationValue >= 5) {
                        mFirstValue = mTextViewAnswer.getText().toString();
                        mSecondValue = "";
                        mTextViewAnswer.setText("");
                        mOperationValue -= 5;
                        mTextViewFormula.setText(mFirstValue + Symbol());
                    } else {
                        mOperationValue = 0;
                    }
                } else {
                    mTextViewFormula.setText(mFirstValue + Symbol());
                }
                break;
            case 3:
                if (mSecondValue.equals("")) {
                    if (mOperationValue == 0) {
                        mTextViewAnswer.setText(mFirstValue);
                    } else {
                        mSecondValue = mFirstValue;
                        mTextViewFormula.setText(mFirstValue + Symbol() + mSecondValue);
                        Answer();
                    }
                } else {
                    Answer();
                }
                mOperationValue = 5;
                mProcessValue = 0;
                mNumber = 0;
                mFirstValue = "";
                mSecondValue = "";
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                mNumber = 0;
                mProcessValue = 1;
                break;
            case R.id.button_1:
                mNumber = 1;
                mProcessValue = 1;
                break;
            case R.id.button_2:
                mNumber = 2;
                mProcessValue = 1;
                break;
            case R.id.button_3:
                mNumber = 3;
                mProcessValue = 1;
                break;
            case R.id.button_4:
                mNumber = 4;
                mProcessValue = 1;
                break;
            case R.id.button_5:
                mNumber = 5;
                mProcessValue = 1;
                break;
            case R.id.button_6:
                mNumber = 6;
                mProcessValue = 1;
                break;
            case R.id.button_7:
                mNumber = 7;
                mProcessValue = 1;
                break;
            case R.id.button_8:
                mNumber = 8;
                mProcessValue = 1;
                break;
            case R.id.button_9:
                mNumber = 9;
                mProcessValue = 1;
                break;
            case R.id.button_plus:
                if (mOperationValue == 5) {
                    mOperationValue += 1;
                } else {
                    mOperationValue = 1;
                }
                mProcessValue = 2;
                break;
            case R.id.button_minus:
                if (mOperationValue == 5) {
                    mOperationValue += 2;
                } else {
                    mOperationValue = 2;
                }
                mProcessValue = 2;
                break;
            case R.id.button_multiply:
                if (mOperationValue == 5) {
                    mOperationValue += 3;
                } else {
                    mOperationValue = 3;
                }
                mProcessValue = 2;
                break;
            case R.id.button_divide:
                if (mOperationValue == 5) {
                    mOperationValue += 4;
                } else {
                    mOperationValue = 4;
                }
                mProcessValue = 2;
                break;
            case R.id.button_equal:
                mProcessValue = 3;
                break;
            case R.id.button_clear:
                init();
                break;
        }
        Process();
    }
}
