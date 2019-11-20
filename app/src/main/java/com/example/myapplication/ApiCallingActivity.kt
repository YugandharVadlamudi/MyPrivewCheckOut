package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.webservice.ApiClient
import com.example.myapplication.webservice.ApiInterface
import com.example.myapplication.webservice.CallBackMethods
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCallingActivity : AppCompatActivity(), CallBackMethods<String> {
    override fun onCallBackFailure(call: Call<String>, t: Throwable) {
    }

    override fun onCallBackResponse(call: Call<String>, response: Response<String>) {
    }

    private val TAGF = ApiCallingActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_calling)
        apiCalling()
        apiCallingAddNotes()
    }

    private fun apiCallingAddNotes() {
        val jo_child = JSONObject()
        val jo_parentData = JSONObject()

//        ApiClient.getApi().apiAddNotes()
    }

    private fun apiCalling() {

//        ApiClient.getApi().getCourse().enqueue()
        /*check.enqueue(object: Callback<String?> {
            override fun onFailure(call: Call<String?>, t: Throwable) {
                Toast.makeText(baseContext, "Error", Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(call: Call<String?>, response: Response<List<ModelClass>?>) {
//                Log.d(TAGF, ":${response.body()}");
                val model = response.body()
                Log.d(TAGF, ":${model} ");
                Toast.makeText(baseContext, "success", Toast.LENGTH_SHORT).show();
            }
        })*/
//        var list = check.execute().body()
//        Log.d(TAGF, ": list->${list}");
        /* if (list.isSuccessful) {
             var listItems = list.body()
             Log.d(TAGF.toString(), ":${listItems} ");
         }
 */
    }
}
