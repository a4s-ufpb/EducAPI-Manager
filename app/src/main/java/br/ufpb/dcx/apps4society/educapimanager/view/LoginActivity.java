package br.ufpb.dcx.apps4society.educapimanager.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.apps4society.educapimanager.R;
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade;
import br.ufpb.dcx.apps4society.educapimanager.control.service.RetrofitInitializer;
import br.ufpb.dcx.apps4society.educapimanager.model.bean.Session;
import br.ufpb.dcx.apps4society.educapimanager.model.dto.UserDTO;
import br.ufpb.dcx.apps4society.educapimanager.view.ui.home.HomeFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Context context = this;

    private Button btn_entrar;
    private TextInputLayout email_input,password_input;
    private EditText edtTxEmail,edtTxPassword;
    //TODO("implementar 'esqueci minha senha', redirecionar para outra tela onde ira poder fazer a troca da senha")
    private TextView esqueci_senha,semCadastro;
    private ArrayList<UserDTO> auth = new ArrayList<>();
    private UserDTO userAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pegarUsuarios();

        //INICIALIZAÇÃO DOS COMPONENTES
        btn_entrar = findViewById(R.id.btnLogin);
        edtTxEmail = findViewById(R.id.edtTxEmail);
        edtTxPassword = findViewById(R.id.edtTxPassword);
        email_input = findViewById(R.id.tilEmail);
        password_input = findViewById(R.id.tilPassword);
        semCadastro = findViewById(R.id.withoutRegister);


        btn_entrar.setOnClickListener(v -> {
            System.out.println(auth);
            try {
                if(autorizar(edtTxEmail.getText().toString(),edtTxPassword.getText().toString())){
                   Intent next = new Intent();
                   next.setClass(context, NavDrawerActivity.class);
                   startActivity(next);
               }else{
                   password_input.setBoxBackgroundColor(getResources().getColor(R.color.crimson));
                   password_input.setErrorEnabled(true);
                   password_input.setBoxBackgroundColor(getResources().getColor(R.color.white));
                   password_input.setError("Senha incorreta, Tente Novamente");
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        semCadastro.setOnClickListener(v -> {
            Intent ir = new Intent();
            ir.setClass(this.context,RegisterActivity.class);
            startActivity(ir);
        });
    }

    private boolean autorizar (String email, String password) throws InterruptedException {
        UserDTO tmp = new UserDTO(email,password);
        for(UserDTO u : this.auth) {
            if (tmp.getEmail().equals(u.getEmail())) {
                System.out.println(u.getId());
                pegarUsuarioId(u.getId());
                 break;
            }
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(userAuth);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        return validar(tmp);



    }

    private void pegarUsuarios () {
        Call call = new RetrofitInitializer().userService().findAll();
        call.enqueue(new Callback<ArrayList<UserDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<UserDTO>> call, Response<ArrayList<UserDTO>> response) {
                auth = response.body();
                Toast.makeText(context,"Usuarios Recuperados",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<UserDTO>> call, Throwable t) {
                Toast.makeText(context,"Algo Ocorreu Errado",Toast.LENGTH_SHORT).show();
            }
        });
    }

  private boolean validar(UserDTO creator){
        boolean autorizacao = false;
        if(userAuth.equals(creator)){
          CreateObjectFacade.Companion.getInstance().setTempSession(new Session(userAuth));
          autorizacao = true;
      }
        return autorizacao;
  }

    void pegarUsuarioId(Long id) throws InterruptedException {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        AuthRunnable g = new AuthRunnable(id);
        Thread t = new Thread(g);
        t.start();
        t.join();
        System.out.println(g.getCreator());
        userAuth = g.getCreator();
    }

    private static class AuthRunnable implements Runnable{
        UserDTO creator;
        Long id;

        AuthRunnable(Long id){
            this.id = id;
        }

        @Override
        public void run() {
            Call<UserDTO> call = new RetrofitInitializer().userService().findUser(id);
            try {
                creator = call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        UserDTO getCreator() {
            return creator;
        }
    }
}
