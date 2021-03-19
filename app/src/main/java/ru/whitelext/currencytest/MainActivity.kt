package ru.whitelext.currencytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    private val currencyListAdapter = CurrencyListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        initViewModel()
        initSwipeToRefresh()
        initRv()

    }


    private fun initSwipeToRefresh() {
        swipe_refresh_main.setProgressViewOffset(false, 200, 350)
        swipe_refresh_main.setOnRefreshListener {
            viewModel.getCurrencyListFromServer()
            swipe_refresh_main.isRefreshing = false
        }
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this,MainActivityViewModelFactory()).get(MainActivityViewModel::class.java)
        viewModel.currencyListLoadingResult.observe(this@MainActivity, Observer { loadingResult ->
            loadingResult.error?.let {
                Snackbar.make(
                    recyclerView_main,
                    R.string.currency_loading_error,
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }

            loadingResult.success?.let {
                currencyListAdapter.setCurrencyList(it)
            }
        }
        )
    }

    private fun initRv() {
        with(recyclerView_main) {
            layoutManager = LinearLayoutManager(context)
            adapter = currencyListAdapter
        }
    }


}