package com.afrzxd.wholang

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.InputFilter
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var listLang: RecyclerView
    private val list = ArrayList<Lang>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listLang = findViewById(R.id.list_lang)
        listLang.setHasFixedSize(true)
        list.addAll(getList_Langses())
        showRecyclerList()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page-> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun getList_Langses(): ArrayList<Lang> {
            val Name_Lang = resources.getStringArray(R.array.lang_name)
            val Tahun_Lang = resources.getStringArray(R.array.tahunrilis)
            val Since_Lang = resources.getStringArray(R.array.since_lang)
            val Owner_Lang = resources.getStringArray(R.array.owner_lang)
            val Description_LangRaw = resources.getStringArray(R.array.description_lang)
            val Photo_Lang = resources.obtainTypedArray(R.array.list_photo)
            val List_Langs = ArrayList<Lang>()
            /**val Description_Lang = Description_LangRaw.map {
                if (it.length > 25) {
                    Html.fromHtml(it.substring(0, 25) + "<font color=\"#FF0000\"><b> ...Baca selengkapnya</b></font>")
                } else {
                    it
                }
            }.toTypedArray()*/
            for (i in Name_Lang.indices) {
                val hero = Lang(Name_Lang[i],Tahun_Lang[i] ,Since_Lang[i], Owner_Lang[i], Description_LangRaw[i].toString(), Photo_Lang.getResourceId(i, -1))
                List_Langs.add(hero)
            }
            return List_Langs
        }

        private fun showRecyclerList() {
            listLang.layoutManager = LinearLayoutManager(this)
            val List_LangsAdapter = ListLang(list)
            listLang.adapter = List_LangsAdapter
        }
    override fun onBackPressed() {
        moveTaskToBack(true)
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(1)
    }

}