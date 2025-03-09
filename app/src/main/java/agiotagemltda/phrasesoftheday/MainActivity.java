package agiotagemltda.phrasesoftheday;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] frases = {
            "Zé da moeda",
            "Calango azul",
            "Agiota sabido"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void gerarFrase(View view){
        TextView text = findViewById(R.id.textResultado);
        int randomNumber = new Random().nextInt(3);
        String phrase = frases[randomNumber];
        text.setText(phrase);
    }

    public void exibirTodas(View view){
        TextView text = findViewById(R.id.textResultado);
        String resultText = "";
        for (String frase: frases) {
            resultText = resultText + frase + "\n";
        }

        text.setText(resultText);
    }
}