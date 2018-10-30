package online.grinaldi.footballmatch.view

import online.grinaldi.footballmatch.model.MatchEvent

interface MainView {

    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList: List<MatchEvent>)
    }

    interface Presenter {
        fun getFootballMatchData()

        fun getFootballUpcomingData()
    }

}