package online.grinaldi.footballmatch.model

import com.google.gson.annotations.SerializedName


data class Teams(

    @SerializedName("idLeague")
    var idLeague: String,
    @SerializedName("idSoccerXML")
    var idSoccerXML: String,
    @SerializedName("idTeam")
    var idTeam: String,
    @SerializedName("strLeague")
    var strLeague: String,
    @SerializedName("strTeam")
    var strTeam: String,
    @SerializedName("strTeamBadge")
    var strTeamBadge: String
)
