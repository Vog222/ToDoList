package com.jblearning.candystorev5;

import android.content.Context;
import android.widget.Button;

import java.util.Date;

public class ItemButton extends Button {
  private Item Item;

  public ItemButton(Context context, Item newItem ) {
    super( context );
    Item = newItem;
  }

  public Date getDate( ) {
    return Item.getDate( );
  }
}
