package com.example.fbw_tanks_guide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fbw_tanks_guide.Tank;

import java.util.ArrayList;
import java.util.List;

public class TanksDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tanks.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TANKS = "tanks";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LEVEL = "level";
    private static final String COLUMN_HEALTH = "health";
    private static final String COLUMN_DAMAGE = "damage";
    private static final String COLUMN_ARMOR = "armor";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_HISTORY = "history";
    private static final String COLUMN_NATION = "nation";
    private static final String COLUMN_TYPE = "type";

    public TanksDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TANKS_TABLE = "CREATE TABLE " + TABLE_TANKS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_LEVEL + " INTEGER,"
                + COLUMN_HEALTH + " INTEGER,"
                + COLUMN_DAMAGE + " INTEGER,"
                + COLUMN_ARMOR + " INTEGER,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_HISTORY + " TEXT,"
                + COLUMN_NATION + " TEXT,"
                + COLUMN_TYPE + " TEXT"
                + ")";
        db.execSQL(CREATE_TANKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TANKS);
        onCreate(db);
    }

    public void addTank(Tank tank) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, tank.getName());
        values.put(COLUMN_LEVEL, tank.getLevel());
        values.put(COLUMN_HEALTH, tank.getHealth());
        values.put(COLUMN_DAMAGE, tank.getDamage());
        values.put(COLUMN_ARMOR, tank.getArmor());
        values.put(COLUMN_DESCRIPTION, tank.getDescription());
        values.put(COLUMN_HISTORY, tank.getHistory());
        values.put(COLUMN_NATION, tank.getNation());
        values.put(COLUMN_TYPE, tank.getType());

        db.insert(TABLE_TANKS, null, values);
        db.close();
    }

    public List<Tank> getAllTanks() {
        List<Tank> tankList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_TANKS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(COLUMN_ID);
            int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
            int levelIndex = cursor.getColumnIndex(COLUMN_LEVEL);
            int healthIndex = cursor.getColumnIndex(COLUMN_HEALTH);
            int damageIndex = cursor.getColumnIndex(COLUMN_DAMAGE);
            int armorIndex = cursor.getColumnIndex(COLUMN_ARMOR);
            int descriptionIndex = cursor.getColumnIndex(COLUMN_DESCRIPTION);
            int historyIndex = cursor.getColumnIndex(COLUMN_HISTORY);
            int nationIndex = cursor.getColumnIndex(COLUMN_NATION);
            int typeIndex = cursor.getColumnIndex(COLUMN_TYPE);

            do {
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                int level = cursor.getInt(levelIndex);
                int health = cursor.getInt(healthIndex);
                int damage = cursor.getInt(damageIndex);
                int armor = cursor.getInt(armorIndex);
                String description = cursor.getString(descriptionIndex);
                String history = cursor.getString(historyIndex);
                String nation = cursor.getString(nationIndex);
                String type = cursor.getString(typeIndex);

                Tank tank = new Tank(id, name, level, health, damage, armor, description, history, nation, type);
                tankList.add(tank);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return tankList;
    }


}

