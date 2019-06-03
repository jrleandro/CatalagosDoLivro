package leandro.com.catalagosdolivro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TelaPrincipal extends AppCompatActivity  implements View.OnClickListener {

    private Button btnCadastrar;
    private Button btnPesquisar;
    private RadioGroup rdgPesrisarPor;
    private EditText edtPesquisar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnPesquisar = findViewById(R.id.btnPesquisar);
        rdgPesrisarPor = findViewById(R.id.rdgpesquisarPor);

        edtPesquisar = findViewById(R.id.edtPesquisar);

        btnCadastrar.setOnClickListener(this);
        btnPesquisar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){

            case R.id.btnCadastrar:
                intent = new Intent(this, TelaCadastrar.class);
                break;

            case R.id.btnPesquisar:
                intent = new Intent(this,TelaPesquisar.class);
                intent.putExtra("tipo",rdgPesrisarPor.getCheckedRadioButtonId());
                intent.putExtra("chave",edtPesquisar.getText().toString());
                break;
         }
         if (intent!=null){
             startActivity(intent);
         }

}
}
