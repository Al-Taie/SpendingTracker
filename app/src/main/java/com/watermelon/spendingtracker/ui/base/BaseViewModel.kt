package com.watermelon.spendingtracker.ui.base

import androidx.lifecycle.ViewModel
import com.watermelon.spendingtracker.model.data.domain.Category
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {


    private val compositeDisposable = CompositeDisposable()

    fun subscribeData(data: Completable?) {
        data?.subscribeOn(Schedulers.io())?.subscribe()
    }

    fun <T> observeData(
        observable: Observable<T>?,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        observable
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(onSuccess, onError)
            .apply {
                compositeDisposable
            }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}

