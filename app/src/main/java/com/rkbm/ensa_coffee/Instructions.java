package com.rkbm.ensa_coffee;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Instructions extends AppCompatActivity {
    ImageView imageView;
    TextView IDcoffee,Name,Inst;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_instructions);

       imageView=findViewById(R.id.imageInst);
       IDcoffee =findViewById(R.id.IdInst);
       Name=findViewById(R.id.NameInstr);
       Inst=findViewById(R.id.Instr_Inst);

       Intent intent=getIntent();
       Bundle bundle=intent.getExtras();
       Coffee coffee =(Coffee)bundle.getSerializable("MEAL");
       IDcoffee.setText(String.valueOf(coffee.getId()));
       Name.setText(coffee.getName());
       Inst.setText(coffee.getInstructions());
       Glide.with(this).load(coffee.getImageURL()).into(imageView);


    }
}