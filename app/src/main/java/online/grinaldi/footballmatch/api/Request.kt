package online.grinaldi.footballmatch.api

import io.reactivex.Flowable
import online.grinaldi.footballmatch.model.MatchEventResponse
import online.grinaldi.footballmatch.model.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Request {

    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id: String): Flowable<MatchEventResponse>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id: String): Flowable<MatchEventResponse>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id: String): Flowable<TeamsResponse>
}