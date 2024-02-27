package g313.vakulenko.hw1_3_lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView outputFirstPlayer;
    private TextView outputSecondPlayer;

    private Button buttonFirstPlayer;
    private Button buttonSecondPlayer;

    private int countFirstPlayer = 0; // счётчик подсчёта нажатий 1 игрока
    private int countSecondPlayer = 0; // счётчик подсчёта нажатий 2 игрока

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка полей к разметке
        outputFirstPlayer = findViewById(R.id.resultFirstPlayer);
        buttonFirstPlayer = findViewById(R.id.buttonOne);

        outputSecondPlayer = findViewById(R.id.resultSecondPlayer);
        buttonSecondPlayer = findViewById(R.id.buttonTwo);

        // обработка нажатия кнопки
        buttonFirstPlayer.setOnClickListener(listenerFirstPlayer);
        buttonSecondPlayer.setOnClickListener(listenerSecondPlayer);

        // Восстанавливаем состояние, если оно сохранено
        if (savedInstanceState != null) {
            countFirstPlayer = savedInstanceState.getInt("countFirstPlayer", 0);
            countSecondPlayer = savedInstanceState.getInt("countSecondPlayer", 0);
            updateCounters();
        }
    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countFirstPlayer", countFirstPlayer);
        outState.putInt("countSecondPlayer", countSecondPlayer);
    }

    // создание слушателей
    private View.OnClickListener listenerFirstPlayer = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            countFirstPlayer++;
            outputFirstPlayer.setText("КОЛИЧЕСТВО НАЖАТИЙ: " + countFirstPlayer);
        }
    };

    private View.OnClickListener listenerSecondPlayer = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            countSecondPlayer++;
            outputSecondPlayer.setText("КОЛИЧЕСТВО НАЖАТИЙ: " + countSecondPlayer);
        }
    };

    // Обновление отображения счетчиков
    private void updateCounters() {
        outputFirstPlayer.setText("КОЛИЧЕСТВО НАЖАТИЙ: " + countFirstPlayer);
        outputSecondPlayer.setText("КОЛИЧЕСТВО НАЖАТИЙ: " + countSecondPlayer);
    }
}