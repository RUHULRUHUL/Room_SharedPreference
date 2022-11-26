package com.ruhul.localstorage.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ruhul.localstorage.Todo;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    void insertTodo(Todo todo);

    @Delete
    int deleteCartData(Todo todo);

    @Query("Delete From todotable")
    int ClearAllDataFromTable();


    @Update
    int updateCart(Todo todo);

    @Query("Select * From todotable")
    LiveData<List<Todo>> getAllCartData();

/*    @Query("select SUM(ProductTotalPrice) from CartTable")
    double getTotalPrice();*/

/*    @Query("Update CartTable Set ProductTotalQuantity =:ProductTotalQuantity , ProductTotalPrice =:productTotalPrice where serialId =:id ")
    void updatePriceQuantity(String ProductTotalQuantity, String productTotalPrice, long id);*/


}
