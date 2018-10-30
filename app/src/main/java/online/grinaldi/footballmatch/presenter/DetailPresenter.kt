package online.grinaldi.footballmatch.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import online.grinaldi.footballmatch.model.MatchEventPresenter
import online.grinaldi.footballmatch.view.DetailView

class DetailPresenter(val mView: DetailView.View, val matchEventPresenter: MatchEventPresenter) : DetailView.Presenter {

    override fun getTeamsBadgeHome(id: String) {
        compositeDisposable.add(matchEventPresenter.getTeams(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                mView.displayTeamBadgeHome(it.teams[0])
            })
    }

    val compositeDisposable = CompositeDisposable()

    override fun getTeamsBadgeAway(id: String) {
        compositeDisposable.add(matchEventPresenter.getTeams(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                mView.displayTeamBadgeAway(it.teams[0])
            })
    }
}