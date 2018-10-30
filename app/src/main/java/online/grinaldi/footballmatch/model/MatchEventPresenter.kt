package online.grinaldi.footballmatch.model

import io.reactivex.Flowable
import online.grinaldi.footballmatch.api.Request

class MatchEventPresenter(private val theSportDBRest: Request) : MatchEventView {

    override fun getUpcomingMatch(id: String): Flowable<MatchEventResponse> = theSportDBRest.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<MatchEventResponse> = theSportDBRest.getLastmatch(id)

    override fun getTeams(id: String): Flowable<TeamsResponse> = theSportDBRest.getTeam(id)
}