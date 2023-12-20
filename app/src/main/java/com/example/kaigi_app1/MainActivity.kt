package com.example.kaigi_app1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //view取得
        val btnMknew: Button =findViewById(R.id.btnMknew)
        val lv: ListView =findViewById(R.id.List_kaigi)
        val btnJoin: Button =findViewById(R.id.btnJoin)


        //listview配列に追加
        val adapter = ArrayAdapter<String>(
            this,android.R.layout.simple_expandable_list_item_1,
            mutableListOf()
        )
        lv.adapter = adapter

        //新規作成ボタンからアラートダイアログ
        btnMknew.setOnClickListener{
            val et = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("会議作成")
                .setMessage("名前")
                .setView(et)
                .setPositiveButton("作成",DialogInterface.OnClickListener{dialogInterface, i ->
                    val kaigiList = et.text.toString()
                    adapter.add(kaigiList)
                    val intent = Intent(this,kaigi_main1::class.java)
                    startActivity(intent)
                })
                .setNegativeButton("キャンセル",null)
                .show()
        }
        //参加ボタンからアラートダイアログ
        btnJoin.setOnClickListener{
            val et = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("会議に参加")
                .setMessage("コードを入力")
                .setView(et)
                .setPositiveButton("参加",DialogInterface.OnClickListener{dialogInterface, i ->
                    val kaigilist = et.text.toString()
                    adapter.add(kaigilist)
                })
                .setNegativeButton("キャンセル",null)
                .show()
        }
        //listViewからアラートダイアログ
        lv.setOnItemClickListener{adapterView,view,i,l->
            AlertDialog.Builder(this)
                .setTitle("削除しますか")
                .setPositiveButton("削除",DialogInterface.OnClickListener{_,_ ->
                    adapter.remove(adapter.getItem(i))
                    adapter.notifyDataSetChanged()//画面更新
                })
                .setNegativeButton("キャンセル",null)
                .show()
        }
        //検索テキストフィルター
        /*lv.isTextFilterEnabled = true

        findViewById<SearchView>(R.id.List_kaigi).setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                //入力変更処理
                override fun onQueryTextChange(p0: String?): Boolean {
                    if(p0.isNullOrBlank()){
                        lv.clearTextFilter()
                    }else{
                        lv.setFilterText(p0)
                    }
                    return false
                }
                //検索ボタン処理
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }
            }
        )*/
    }
}