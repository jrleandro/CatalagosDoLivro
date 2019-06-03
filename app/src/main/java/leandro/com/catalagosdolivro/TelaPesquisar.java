package leandro.com.catalagosdolivro;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TelaPesquisar extends AppCompatActivity implements View.OnClickListener {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pesquisar);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        Intent intent = getIntent();//pegar os dados putExtra

        if (intent!=null){
            int tipo = intent.getIntExtra("tipo",0);//capturando tipo
            String chave = intent.getStringExtra("chave");//chave "nome" tem que ser igual
            List<ContentValues> lista = new ArrayList<>();//verificar valores ano ,titulo, ...

            if (tipo ==R.id.rbtPesquisarPorAno){
                try{
                    lista = new DataBaseHelper(this).pesquisarPorAno(Integer.parseInt(chave));//converte a o nome "chave"
                }catch (Exception ex){
                    lista =new  DataBaseHelper(this).pesquisarTodos();
                }

            }else if (tipo==R.id.rbtPesquisarPorTitulo){
                lista = new DataBaseHelper(this).pesquisarPortitulo(chave);//não percisa converter já são string
            }else {
                lista =new  DataBaseHelper(this).pesquisarTodos();
            }
            if (lista!=null){
                if (lista.size()>0){
                    TableLayout tb = findViewById(R.id.tbPesquisa);//pegando referencia da tabela
                    for (ContentValues cv: lista){
                        TableRow linha = new TableRow(this);

                        TextView coluna1 = new TextView(this);
                        coluna1.setText(String.valueOf(cv.getAsInteger("id")));
                        linha.addView(coluna1);


                        TextView coluna2 = new TextView(this);
                        coluna2.setText(String.valueOf(cv.getAsString("titulo")));
                        linha.addView(coluna2);

                        TextView coluna3 = new TextView(this);
                        coluna3.setText(String.valueOf(cv.getAsString( "autor")));
                        linha.addView(coluna3);

                        TextView coluna4 = new TextView(this);
                        coluna4.setText(String.valueOf(cv.getAsInteger("ano")));
                        linha.addView(coluna4);

                        tb.addView(linha);//adicionar linha na tabela
                    }
                }

            }
        }
    }

    @Override
    public void onClick(View v) {//ação do botão clicar
        if (v.getId()==R.id.btnVoltar){//verificando botão
            onBackPressed();//voltando ao inicio
        }

    }
}
