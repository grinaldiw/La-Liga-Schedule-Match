package online.grinaldi.footballmatch.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.achmad.FootballMatchScheduleVer1.utils.invisible
import com.example.achmad.FootballMatchScheduleVer1.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import online.grinaldi.footballmatch.R
import online.grinaldi.footballmatch.R.id.lastMatch
import online.grinaldi.footballmatch.R.id.nextMatch
import online.grinaldi.footballmatch.api.ApiRequest
import online.grinaldi.footballmatch.api.Request
import online.grinaldi.footballmatch.model.MatchEvent
import online.grinaldi.footballmatch.model.MatchEventPresenter
import online.grinaldi.footballmatch.presenter.MainPresenter
import online.grinaldi.footballmatch.recycler.ListAdapter
import online.grinaldi.footballmatch.view.MainView
import org.jetbrains.anko.AnkoLogger

class MainActivity : AppCompatActivity(), AnkoLogger, MainView.View {

    lateinit var mPresenter: MainPresenter

    private var matchLists: MutableList<MatchEvent> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = ApiRequest.getClient().create(Request::class.java)
        val request = MatchEventPresenter(service)
        mPresenter = MainPresenter(this, request)
        mPresenter.getFootballMatchData()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                lastMatch -> {
                    mPresenter.getFootballMatchData()
                }
                nextMatch -> {

                    mPresenter.getFootballUpcomingData()
                }

            }
            true
        }
        bottom_navigation.selectedItemId = lastMatch

    }

    override fun hideLoading() {
        mainProgressBar.invisible()
    }

    override fun showLoading() {
        mainProgressBar.visible()
    }

    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = ListAdapter(matchList, applicationContext)
    }


}
