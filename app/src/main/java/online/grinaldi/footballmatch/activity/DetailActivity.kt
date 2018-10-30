package online.grinaldi.footballmatch.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import online.grinaldi.footballmatch.R
import online.grinaldi.footballmatch.api.ApiRequest
import online.grinaldi.footballmatch.api.Request
import online.grinaldi.footballmatch.model.MatchEvent
import online.grinaldi.footballmatch.model.MatchEventPresenter
import online.grinaldi.footballmatch.model.Teams
import online.grinaldi.footballmatch.presenter.DetailPresenter
import online.grinaldi.footballmatch.view.DetailView

class DetailActivity : AppCompatActivity(), DetailView.View {

    override fun displayTeamBadgeAway(team: Teams) {
        Picasso.get()
            .load(team.strTeamBadge)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(img_away)
    }

    override fun displayTeamBadgeHome(team: Teams) {

        Picasso.get()
            .load(team.strTeamBadge)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(img_home)
    }

    private lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val service = ApiRequest.getClient().create(Request::class.java)
        val request = MatchEventPresenter(service)
        mPresenter = DetailPresenter(this, request)

        val event = intent.getParcelableExtra<MatchEvent>("match")
        mPresenter.getTeamsBadgeAway(event.idAwayTeam)
        mPresenter.getTeamsBadgeHome(event.idHomeTeam)
        initData(event)
        supportActionBar?.title = event.strEvent
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initData(matchEvent: MatchEvent) {
        match_date.text = matchEvent.dateEvent
        home_score_match.text = matchEvent.intHomeScore
        away_score_match.text = matchEvent.intAwayScore

        home_shots.text = matchEvent.intHomeShots
        away_shot.text = matchEvent.intAwayShots

        home_goals.text = matchEvent.strHomeGoalDetails
        away_goals.text = matchEvent.strAwayGoalDetails

        home_goalkeeper.text = matchEvent.strHomeLineupGoalkeeper
        away_goalkeeper.text = matchEvent.strAwayLineupGoalkeeper

        home_defense.text = matchEvent.strHomeLineupDefense
        away_defense.text = matchEvent.strAwayLineupDefense

        home_midfield.text = matchEvent.strHomeLineupMidfield
        away_midfield.text = matchEvent.strAwayLineupMidfield

        home_forward.text = matchEvent.strHomeLineupForward
        away_forward.text = matchEvent.strAwayLineupForward

        home_substitutes.text = matchEvent.strHomeLineupSubstitutes
        away_substitutes.text = matchEvent.strAwayLineupSubstitutes

    }


}