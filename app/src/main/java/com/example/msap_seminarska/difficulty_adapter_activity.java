package com.example.msap_seminarska;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class difficulty_adapter_activity extends AppCompatActivity {
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";

    ListView simpleListView;
    String[] difficultyArry = {"Easy", "Medium", "Hard"};
    String[] difficultyImages = {"  *","**","  ***"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_adapter_activity);
        simpleListView=(ListView)findViewById(R.id.simpleListView);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<difficultyArry.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("name",difficultyArry[i]);
            hashMap.put("image",difficultyImages[i]+"");
            arrayList.add(hashMap);
        }
        String[] from={"name","image"};
        int[] to={R.id.textView,R.id.starView};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_item,from,to);
        simpleListView.setAdapter(simpleAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),difficultyArry[i],Toast.LENGTH_LONG).show();
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_DIFFICULTY, difficultyArry[i]);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
