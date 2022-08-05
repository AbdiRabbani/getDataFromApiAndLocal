package com.example.pahlawannasional.localjson

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.R
import com.example.pahlawannasional.databinding.ActivityJaonBinding
import com.example.pahlawannasional.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.IOException

class JsonActivity : AppCompatActivity() {

    private var _binding : ActivityJaonBinding? = null
    private val binding get() = _binding as ActivityJaonBinding

    private val arrayHero = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityJaonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPahlawanFromJson()
        Log.i("List", "onCreate : ${arrayHero[0]}")

        val mAdapter = HeroAdapter()
        binding.rvPahlawan.apply {
            layoutManager = LinearLayoutManager(this@JsonActivity)
            adapter = mAdapter
            mAdapter.setData(arrayHero)
        }
    }

    private fun getPahlawanFromJson(){
        val json = assets.readAssetsFile()
        val myJson = getJsonDataFromAsset()

        //get root json from pahlawan_nasional.json
        val getRootJson = json.let { JSONObject(it) }

        //get array from
        val pahlawanFromJsonArray = getRootJson.getJSONArray("daftar_pahlawan")

        for (i in 0 until pahlawanFromJsonArray.length()){
            val data = pahlawanFromJsonArray.getJSONObject(i)
            val hero = Hero(
                nama = data.getString("nama"),
                namaLengkap = data.getString("nama2"),
                kategori = data.getString("kategori"),
                asal = data.getString("asal"),
                lahir = data.getString("lahir"),
                usia = data.getString("usia"),
                gugur = data.getString("gugur"),
                lokasiMakam = data.getString("lokasimakam"),
                history = data.getString("history"),
                image = data.getString("img")
            )
            arrayHero.add(hero)
        }
    }

    //pemanggilan json 2 baris
    private fun AssetManager.readAssetsFile() : String =
        open("pahlawan_nasional.json").bufferedReader().use { it.readText() }

    //cara lain pemanggilan json
    private fun getJsonDataFromAsset(): String? {

        val json : String
        try {
            val stream = applicationContext.assets.open("pahlawan_nasional.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (e : IOException) {
            e.printStackTrace()
            return null
        }
        return json
    }
}