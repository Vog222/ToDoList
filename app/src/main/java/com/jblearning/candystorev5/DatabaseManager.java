package com.jblearning.candystorev5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseManager extends SQLiteOpenHelper {
  private static final String DATABASE_NAME = "todoDB";
  private static final int DATABASE_VERSION = 1;
  private static final String TABLE_LIST = "item";
  private static final String ID = "id";
  private static final String NAME = "name";
  private static final String DATE = "date";
	
  public DatabaseManager( Context context ) {
    super( context, DATABASE_NAME, null, DATABASE_VERSION );
  }
 
  public void onCreate( SQLiteDatabase db ) {
    // build sql create statement
    String sqlCreate = "create table " + TABLE_LIST + "( " + ID;
    sqlCreate += " integer primary key autoincrement, " + NAME;
    sqlCreate += " text, " + DATE + " real )" ;
    
    db.execSQL( sqlCreate );
  }
 
  public void onUpgrade( SQLiteDatabase db,
                         int oldVersion, int newVersion ) {
    // Drop old table if it exists
    db.execSQL( "drop table if exists " + TABLE_LIST);
    // Re-create tables
    onCreate( db );
  }
    
  public void insert( Item item ) {
    SQLiteDatabase db = this.getWritableDatabase( );
    String sqlInsert = "insert into " + TABLE_LIST;
    sqlInsert += " values( null, '" + item.getName( );
    sqlInsert += "', '" + item.getDate( ) + "' )";
 
    db.execSQL( sqlInsert );
    db.close( );
  }
   
  public void deleteById( int id ) {
    SQLiteDatabase db = this.getWritableDatabase( );
    String sqlDelete = "delete from " + TABLE_LIST;
    sqlDelete += " where " + ID + " = " + id;
    
    db.execSQL( sqlDelete );
    db.close( );
  }

  public void updateById(int id, String name, Date date) {
    SQLiteDatabase db = this.getWritableDatabase();
 
    String sqlUpdate = "update " + TABLE_LIST;
    sqlUpdate += " set " + NAME + " = '" + name + "', ";
    sqlUpdate += DATE + " = '" + date + "'";
    sqlUpdate += " where " + ID + " = " + id;

    db.execSQL( sqlUpdate );
    db.close( );
  }

  public ArrayList<Item> selectAll( ) {
    String sqlQuery = "select * from " + TABLE_LIST;
 
    SQLiteDatabase db = this.getWritableDatabase( );
    Cursor cursor = db.rawQuery( sqlQuery, null );
    
    ArrayList<Item> items = new ArrayList<Item>( );
    while( cursor.moveToNext( ) ) {
      Item currentItem
          = new Item( Integer.parseInt( cursor.getString( 0 ) ),
        		        cursor.getString( 1 ), cursor.( 2 ) );
      items.add( currentItem );
    }
    db.close( );
    return items;
  }
    
  public Item selectById(int id ) {
    String sqlQuery = "select * from " + TABLE_LIST;
    sqlQuery += " where " + ID + " = " + id;
    
    SQLiteDatabase db = this.getWritableDatabase( );
    Cursor cursor = db.rawQuery( sqlQuery, null );
 
    Item items = null;
    if( cursor.moveToFirst( ) )
      items = new Item( Integer.parseInt( cursor.getString( 0 ) ),
		              cursor.getString( 1 ), cursor.getDouble( 2 ) );
    return items;
  }
}
