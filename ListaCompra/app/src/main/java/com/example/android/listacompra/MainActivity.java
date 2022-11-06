package com.example.android.listacompra;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mShoppingList;
    private EditText mProductoEdit;
    private EditText mCantidadEdit;
    private EditText mPrecioEdit;
    private Button mAddButton;
    private TextView mResumenCompra;
    private ArrayAdapter<String> mAdapter;
    private float res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShoppingList = (ListView) findViewById(R.id.shopping_listView);
        mProductoEdit = (EditText) findViewById(R.id.producto_editText);
        mCantidadEdit = (EditText) findViewById(R.id.cantidad_editText);
        mPrecioEdit = (EditText) findViewById(R.id.precio_editText);
        mAddButton = (Button) findViewById(R.id.add_button);
        mResumenCompra = (TextView) findViewById(R.id.resumenCompra_title);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        mShoppingList.setAdapter(mAdapter);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String producto = mProductoEdit.getText().toString() + "(" + mCantidadEdit.getText().toString() + ") = " + mPrecioEdit.getText().toString() + "€";
                mAdapter.add(producto);
                mAdapter.notifyDataSetChanged();
                mProductoEdit.setText("");
                res += Float.parseFloat(mPrecioEdit.getText().toString());
                mResumenCompra.setText("Lista de la compra: "+ mAdapter.getCount() + " productos= " + res + "€");
            }
        });

    }
}