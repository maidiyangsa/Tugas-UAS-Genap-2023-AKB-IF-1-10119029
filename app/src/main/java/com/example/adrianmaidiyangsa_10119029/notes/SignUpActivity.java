/*  IDENTITAS DIRI :
 *  NIM : 10119029
 *  NAMA : Adrian Maidiyangsa
 *  KELAS : IF-1
 */

package com.example.adrianmaidiyangsa_10119029.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnSignUp, btnSignIn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        auth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    inputEmail.setError("Email harus diisi!");
                } else if (TextUtils.isEmpty(password)) {
                    inputPassword.setError("Password harus diisi!");
                } else if (password.length() < 6) {
                    inputPassword.setError("Password minimal 6 karakter!");
                } else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "User dengan Email dan Password berhasil dibuat", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Otentikasi Gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
    }
}