package iut.dam.sae_app_mobile_france_asso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database.db";
    private static final String TABLE_NAME = "Personnes";
    private static final String COLUMN_ID = "IdPers";
    private static final String COLUMN_NAME = "Nom";
    private static final String COLUMN_FIRSTNAME = "Prenom";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_ADMIN = "estAdmin";

    private Context context ;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_FIRSTNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT UNIQUE, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_ADMIN + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addPerson(String nom, String prenom, String email, String password, int isAdmin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, nom);
        cv.put(COLUMN_FIRSTNAME, prenom);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_ADMIN, isAdmin);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isEmailExisting(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.longForQuery(db, "SELECT COUNT(*) FROM Personnes WHERE email = ?", new String[]{email});
        return count > 0; // Retourne true si l'email existe, sinon false
    }

    public String getPassword(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Password FROM Personnes WHERE email = ?", new String[]{email});
        cursor.moveToFirst();
        String password = cursor.getString(0);
        cursor.close();
        db.close();
        return password;
    }

}
