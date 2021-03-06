package leandro.com.catalagosdolivro;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastrar extends AppCompatActivity implements View.OnClickListener {

    private Button btnSalvar;
    private Button btnVoltar;
    private EditText edtTitulo;
    private EditText edtAutor;
    private EditText edtAno;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnVoltar = findViewById(R.id.btnVoltar);

        edtTitulo = findViewById(R.id.edtTitulo);
        edtAutor = findViewById(R.id.edtAutor);
        edtAno = findViewById(R.id.edtAno);

        btnSalvar.setOnClickListener(this);
        btnVoltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnVoltar){
            onBackPressed();
        }else if (v.getId()==R.id.btnSalvar){
            ContentValues contentValues = new ContentValues();
            contentValues.put("titulo",edtTitulo.getText().toString());
            contentValues.put("autor",edtAutor.getText().toString());
            contentValues.put("ano",edtAno.getText().toString());

            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            String mensagem="";
            if (dataBaseHelper.inserir(contentValues)>0){
                mensagem="Operação realizada com sucesso";
                edtTitulo.setText("");
                edtAutor.setText("");
                edtAno.setText("");
            }else{
                mensagem="Ocoreu erro durante operação";
            }

            Toast.makeText(this,mensagem,Toast.LENGTH_LONG);


        }

    }
}















