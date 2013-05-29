package com.example.exemplobd;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.example.db.BDHelper;
import com.example.db.Usuario;

public class MainActivity extends Activity {

  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Usuario teste = new Usuario("teste", "teste");
		// Instancia o objeto db
		BDHelper db = new BDHelper(getApplicationContext());

		// INSERT
		db.insert(teste);

		// SELECT ALL
		List<Usuario> allUsers = db.selectAll();
		for (Usuario user : allUsers) {
			System.out.println("[Login]: " + user.getLogin() + " [Senha]: " + user.getSenha());
		}

		// DELETE
		db.delete(teste);
	}

}
