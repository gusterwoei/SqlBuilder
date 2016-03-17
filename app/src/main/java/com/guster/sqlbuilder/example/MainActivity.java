package com.guster.sqlbuilder.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.guster.sqlbuilder.SqlBuilder;

/**
 * Created by Gusterwoei on 9/30/15.
 *
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // example usage
        String query = SqlBuilder.newInstance()
                .select("u.*", "COUNT(p.*)")
                .from("users", "u")
                .innerJoin("u", "posts", "p", "p.user_id = u.user_id")
                .innerJoin("u", "books", "b", "b.user_id = u.user_id")
                .leftJoin("p", "comments", "c", "c.post_id = p.post_id")
                .where("u.user_id = :userId")
                .andWhere("u.status = :status")
                .groupBy("u.user_id")
                .orderBy("u.username")
                .bindValue("userId", "user123")
                .bindValue("status", 1)
                .getQuery();
        Log.d("SQL_BUILDER", "query: " + query);
    }
}
