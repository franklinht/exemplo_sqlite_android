package com.example.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {

  // Database Name
	private static final String DATABASE_NAME = "usuarios";

	// Contacts table name
	private static final String TABLE_USUARIO = "usuario";

	// Contacts Table Columns names
	private static final String C_ID = "id";
	private static final String C_LOGIN = "login";
	private static final String C_SENHA = "senha";

	public BDHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	// Criação de um BD
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USUARIO + "(" + C_ID + " INTEGER PRIMARY KEY," + C_LOGIN + " TEXT," + C_SENHA + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// No caso de um banco de dados já tiver a table
	@Override
	public void onUpgrade(SQLiteDatabase db, int velhoBD, int novoBD) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);

		onCreate(db);
	}

	// Insert
	public void insert(Usuario usuario) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(C_LOGIN, usuario.getLogin());
		values.put(C_SENHA, usuario.getSenha());

		// Inserting Row
		db.insert(TABLE_USUARIO, null, values);
		db.close(); // Closing database connection
	}

	// Select
	public Usuario select(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_USUARIO, new String[] { C_ID, C_LOGIN, C_SENHA }, C_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		Usuario contact = new Usuario(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
		return contact;
	}

	// Select all
	public List<Usuario> selectAll() {
		List<Usuario> contactList = new ArrayList<Usuario>();
		String selectQuery = "SELECT  * FROM " + TABLE_USUARIO;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Usuario user = new Usuario(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
				contactList.add(user);
			} while (cursor.moveToNext());
		}
		return contactList;
	}

	// Update em Usuario
	// Retorna se conseguiu adicionar ou não
	public int update(Usuario usuario) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(C_LOGIN, usuario.getLogin());
		values.put(C_SENHA, usuario.getSenha());

		return db.update(TABLE_USUARIO, values, C_ID + " = ?", new String[] { String.valueOf(usuario.getId()) });
	}

	// Delete
	public void delete(Usuario usuario) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_USUARIO, C_ID + " = ?", new String[] { String.valueOf(usuario.getId()) });
		db.close();
	}

	public void dropTable() {
		SQLiteDatabase db = this.getReadableDatabase();
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
		db.close();
	}
}
