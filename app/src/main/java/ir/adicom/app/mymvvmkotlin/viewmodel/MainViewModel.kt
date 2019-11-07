package ir.adicom.app.mymvvmkotlin.viewmodel

import android.databinding.ObservableField
import ir.adicom.app.mymvvmkotlin.datasource.NameModel
import ir.adicom.app.mymvvmkotlin.model.MainModel
import ir.adicom.app.mymvvmkotlin.model.MainModelCallback

class MainViewModel(private val mainViewModelCallback: MainViewModelCallback) : MainModelCallback {
    var isLoading = ObservableField<Boolean>(false)

    fun loadData() {
        val model = MainModel()
        isLoading.set(true)
        model.loadData(this)
    }

    override fun onDataFetched(names: ArrayList<NameModel>) {
        isLoading.set(false)
        mainViewModelCallback.onDataFetched(names)
    }

}

interface MainViewModelCallback {
    fun onDataFetched(names: ArrayList<NameModel>)
}