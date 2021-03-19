package ru.whitelext.currencytest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.whitelext.currencytest.network.CurrencyLoadingResult
import ru.whitelext.currencytest.network.LogInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainActivityViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    private val _currencyListLoadingResult = MutableLiveData<CurrencyLoadingResult>()
    val currencyListLoadingResult: LiveData<CurrencyLoadingResult>
        get() = _currencyListLoadingResult

    init {
        disposables.add(
            Observable.interval(0, 15, TimeUnit.MINUTES)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    getCurrencyListFromServer()
                }
        )
    }

    private val client = OkHttpClient().newBuilder().addInterceptor(LogInterceptor()).build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://www.cbr-xml-daily.ru/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    override fun onCleared() {
        disposables.dispose()
    }

    private val currencyApi =
        retrofit.create(ru.whitelext.currencytest.network.CurrencyApi::class.java)


    fun getCurrencyListFromServer() {
        disposables.add(
            currencyApi.getCurrency()
                .map { response -> response.valuteResponse }
                .map { list -> list.getCurrencyList() }
                .subscribeToRequest(onNext = { currencyList ->
                    _currencyListLoadingResult.value =
                        CurrencyLoadingResult(
                            currencyList,
                            isLoading = false
                        )
                }, onError = {
                    Timber.tag("network").i(it)
                    _currencyListLoadingResult.value = CurrencyLoadingResult(
                        isLoading = false,
                        error = R.string.currency_loading_error
                    )
                })
        )
    }

    private fun <T : Any> Single<T>.subscribeToRequest(
        onNext: (T) -> Unit,
        onError: (Throwable) -> Unit
    ): Disposable = this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(onNext, onError)

}