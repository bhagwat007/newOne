package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class dummy extends AppCompatActivity {
    private RecyclerView mrecyclerView2;
    private ArrayList<Parentmodelclass> mroundList2 = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundList = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundList1 = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundList3 = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundList4 = new ArrayList<>();



    String url = "https://rest.entitysport.com/v2/matches/?status=2&token=3e0e77298ef32518821a2490c457300c&per_page=150";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        mrecyclerView2 = findViewById(R.id.completeRecycle);
        mroundList = new ArrayList<>();
        mroundList1 = new ArrayList<>();
        mroundList2 = new ArrayList<>();
        mroundList4 = new ArrayList<>();
        mroundList3 = new ArrayList<>();


        mrecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView2.setHasFixedSize(true);

         scheduledmatchesdtaa();
          completedmatchData();

    }
    public  void scheduledmatchesdtaa(){
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, "https://rest.entitysport.com/v2/matches/?status=1&token=3e0e77298ef32518821a2490c457300c&per_page=150", null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                pd.dismiss();
                                try {

                                    JSONObject res = response.getJSONObject("response");
                                    JSONArray arr = res.getJSONArray("items");
                                    //Log.i("hoo",arr.toString());
                                    for (int i=0; i < arr.length();i++ ) {

                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String domestic = jsonObject.getString("domestic");
                                        if (domestic.equals("0")) {
                                            String title = jsonObject.getString("title");
                                            String match_id = jsonObject.getString("match_id");
                                            JSONObject competition = jsonObject.getJSONObject("competition");
                                            String team_batting = competition.getString("title");
                                            JSONObject teama = jsonObject.getJSONObject("teama");
                                            String team1 = teama.getString("name");
                                            String team1score = teama.getString("short_name");
                                            String status = jsonObject.getString("status_str");
                                            //scor
                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
                                            String team2 = teamb.getString("name");
                                            String team2score = teamb.getString("short_name");

                                            JSONObject toss = jsonObject.getJSONObject("venue");
                                            String tosswin = toss.getString("name");


                                            mroundList.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));

                                            Log.i("jhdsbfkjsdhjksh", match_id);
                                        }
                                    }
                                    mroundList2.add(new Parentmodelclass("International(Scheduled)", mroundList));

                                    for (int i = 0; i < arr.length(); i++) {
                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String domestic = jsonObject.getString("domestic");
                                        if (domestic.equals("1")) {
                                            String title = jsonObject.getString("title");
                                            String match_id = jsonObject.getString("match_id");
                                            JSONObject competition = jsonObject.getJSONObject("competition");
                                            String team_batting = competition.getString("title");
                                            JSONObject teama = jsonObject.getJSONObject("teama");
                                            String team1 = teama.getString("name");
                                            String team1score = teama.getString("short_name");
                                            String status = jsonObject.getString("status_str");
                                            //scor
                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
                                            String team2 = teamb.getString("name");
                                            String team2score = teamb.getString("short_name");

                                            JSONObject toss = jsonObject.getJSONObject("venue");
                                            String tosswin = toss.getString("name");


                                            mroundList4.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));

                                            Log.i("jhdsbfkjsdhjksh", match_id);
                                        }
                                    }
                                    mroundList2.add(new Parentmodelclass("Domestic(Scheduled)",mroundList4));




                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                ParentAdapter livefragmentAdapter = new ParentAdapter(dummy.this, mroundList2);
                                mrecyclerView2.setAdapter(livefragmentAdapter);
                            }

                        }, error -> {
                });
        queue.add(jsonObjectRequest);
    }

    public void completedmatchData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    JSONObject res = response.getJSONObject("response");
                                    JSONArray arr = res.getJSONArray("items");
                                    //Log.i("hoo",arr.toString());
                                    for (int i = 0; i < arr.length(); i++) {

                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String domestic = jsonObject.getString("domestic");
                                        if (domestic.equals("0")) {
                                            String match_id = jsonObject.getString("match_id");
                                            JSONObject competition = jsonObject.getJSONObject("competition");
                                            String team_batting = competition.getString("title");
                                            JSONObject teama = jsonObject.getJSONObject("teama");
                                            String team1 = teama.getString("name");
                                            String team1score = teama.getString("scores_full");
                                            String status = jsonObject.getString("status_str");
                                            //scor
                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
                                            String team2 = teamb.getString("name");
                                            String team2score = teamb.getString("scores_full");

                                            //JSONObject toss = jsonObject.getJSONObject("toss");
                                            String tosswin = jsonObject.getString("status_note");

                                            mroundList1.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));

//                                            Log.i("jhdsbfkjsdhjksh", category);
                                        }
                                    }
                                    mroundList2.add(new Parentmodelclass("International(Completed)",mroundList1));



                                    //Log.i("hoo",arr.toString());
                                    for (int i = 0; i < arr.length(); i++) {

                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String domestic = jsonObject.getString("domestic");
                                        if (domestic.equals("1")) {
                                            String match_id = jsonObject.getString("match_id");
                                            JSONObject competition = jsonObject.getJSONObject("competition");
                                            String team_batting = competition.getString("title");
                                            JSONObject teama = jsonObject.getJSONObject("teama");
                                            String team1 = teama.getString("name");
                                            String team1score = teama.getString("scores_full");
                                            String status = jsonObject.getString("status_str");
                                            //scor
                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
                                            String team2 = teamb.getString("name");
                                            String team2score = teamb.getString("scores_full");

                                            //JSONObject toss = jsonObject.getJSONObject("toss");
                                            String tosswin = jsonObject.getString("status_note");

                                            mroundList3.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));

//                                            Log.i("jhdsbfkjsdhjksh", category);
                                        }
                                    }

                                    mroundList2.add(new Parentmodelclass("Domestic(Completed)",mroundList3));


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                ParentAdapter livefragmentAdapter = new ParentAdapter(dummy.this, mroundList2);
                                mrecyclerView2.setAdapter(livefragmentAdapter);

//                                madapter = new LiveMatchAdapter(getActivity().getApplicationContext(),mroundList);
//                                mrecyclerView2.setAdapter(madapter);

                            }

                        }, error -> {
                });
        queue.add(jsonObjectRequest);
    }
}
