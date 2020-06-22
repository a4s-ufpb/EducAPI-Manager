package br.ufpb.dcx.apps4society.educapimanager.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.ufpb.dcx.apps4society.educapimanager.R;
import br.ufpb.dcx.apps4society.educapimanager.control.service.RetrofitInitializer;
import br.ufpb.dcx.apps4society.educapimanager.model.dto.UserDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private Context context = this;


    private TextInputLayout tilName,tilEmail,tilPassword;
    private TextInputEditText edtName,edtEmail,edtPassword;
    private Toolbar register_toolbar;
    private Button cadastrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initialização dos componentes
        tilName = findViewById(R.id.tilNameRegister);
        tilEmail = findViewById(R.id.tilEmailRegister);
        tilPassword = findViewById(R.id.tilPasswordRegister);
        edtName = findViewById(R.id.edtTxNameRegister);
        edtEmail = findViewById(R.id.edtTxEmailRegister);
        edtPassword = findViewById(R.id.edtTxPasswordRegister);
        cadastrar = findViewById(R.id.btnCadastro);
        register_toolbar = findViewById(R.id.toolbar_register);
        //

        cadastrar.setOnClickListener(v -> {
            UserDTO u = new UserDTO(edtName.getText().toString(),edtEmail.getText().toString(),edtPassword.getText().toString());
            cadastrarUsuario(u);
        });

        register_toolbar.setNavigationOnClickListener(v -> {
            Intent ir = new Intent();
            ir.setClass(this.context,LoginActivity.class);
            startActivity(ir);
        });


    }






    private void cadastrarUsuario (UserDTO u) {

        Call call = new RetrofitInitializer().userService().insert(u);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    Toast.makeText(context,"Cadastrado Com Sucesso",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"Algo de Errado Ocorreu: "+response.code(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context,"Não Foi Possivel se Comunicar com o Sistema",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
