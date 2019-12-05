package com.farhan.footballmatch


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farhan.footballmatch.adapter.ItemAdapter
import com.farhan.footballmatch.main.PreviousPresenter
import com.farhan.footballmatch.model.DetailEventItem
import com.farhan.footballmatch.model.League
import com.farhan.footballmatch.network.SportDBApi
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class PrevMatchFragment : Fragment() {
    private var match: MutableList<League> = mutableListOf()
    private lateinit var rv: RecyclerView
    private lateinit var presenter: PreviousPresenter
    private lateinit var adapter: ItemAdapter
    private var leagueId = DetailLeague.leagueId

    companion object {
        fun newInstance(leagueId: String) : PrevMatchFragment {
            val fragment = PrevMatchFragment()
            fragment.leagueId = leagueId

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_prev_match, container, false)
        val sportAPI = SportDBApi(leagueId)
        val api = sportAPI.prevSchedule()
        val gson = Gson()
        presenter = PreviousPresenter(this, api, gson)
        presenter.getEventList()


        context?.let {
            adapter = ItemAdapter(it,match){
                startActivity<DetailEvent>("match" to it)
            }
        }

        rv = view.findViewById(R.id.prevMatchRV)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(context)
        return view
    }


    fun showAllData(data: List<League>){
        match.clear()
        match.addAll(data)
        adapter.notifyDataSetChanged()
    }

}
