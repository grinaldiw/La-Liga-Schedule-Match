package online.grinaldi.footballmatch.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import online.grinaldi.footballmatch.model.MatchEventPresenter
import online.grinaldi.footballmatch.view.MainView

class MainPresenter(val mView: MainView.View, val matchEventPresenter: MatchEventPresenter) : MainView.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getFootballUpcomingData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getUpcomingMatch("4335")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                mView.displayFootballMatch(it.events)
                mView.hideLoading()
            })
    }

    override fun getFootballMatchData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getFootballMatch("4335")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                mView.displayFootballMatch(it.events)
                mView.hideLoading()
            })
    }
}