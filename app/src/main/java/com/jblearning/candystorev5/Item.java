package com.jblearning.candystorev5;
import java.util.Calendar;
import java.util.Date;

public class Item {
  private int id;
  private String name;
  Calendar c = Calendar.getInstance();

  String sDate = c.get(Calendar.YEAR) + "-"
          + c.get(Calendar.MONTH)
          + "-" + c.get(Calendar.DAY_OF_MONTH)
          + " at " + c.get(Calendar.HOUR_OF_DAY)
          + ":" + c.get(Calendar.MINUTE);

  public Item(int newId, String newName, double newPrice ) {
    setId( newId );
    setName( newName );
    setPrice( newPrice );
  }

  public void setId( int newId ) {
    id = newId;
  }

  public void setName( String newName ) {
    name = newName;
  }

  public void setsDate(Date date){
    if (c >= date)
  }

  public void setPrice( double newPrice ) {
    if( newPrice >= 0.0 )
      price = newPrice;
  }

  public int getId( ) {
    return id;
  }

  public String getName( ) {
    return name;
  }

  public double getPrice( ) {
    return price;
  }

  public String toString( ) {
    return id + "; " + name + "; " + price;
  }
}