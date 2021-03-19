package ru.whitelext.currencytest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.currency_item.view.*
import ru.whitelext.currencytest.domain.Currency

class CurrencyListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var currencyList: List<Currency> = listOf()
        private set

    fun setCurrencyList(list: List<Currency>) {
        currencyList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CurrencyHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.currency_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CurrencyHolder).bind(currencyList[position])
    }

    class CurrencyHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val editTextRub = v.editText_ruble
        private val editTextCurrency = v.editText_currency
        private val textViewCurrencyName = v.textView_currency_name
        private val textViewCurrencyInitials = v.textView_currency_initials
        fun bind(data: Currency) {
            editTextRub.setText(data.nominal.toString())
            editTextCurrency.setText(data.value.toString())
            textViewCurrencyName.text = data.name
            textViewCurrencyInitials.text = data.charCode
            editTextRub.addTextChangedListener {
                if (it.toString() != "") {
                    val convertedValue: Float =
                        (data.value / data.nominal) * (it.toString().toFloat())
                    editTextCurrency.setText(convertedValue.toString())
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

}