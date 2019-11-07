package ir.adicom.app.mymvvmkotlin.model

import android.os.Handler
import ir.adicom.app.mymvvmkotlin.datasource.NameModel

class MainModel {
    fun loadData(mainModelCallback: MainModelCallback) {
        Handler().postAtTime({
            val names = ArrayList<NameModel>()
            names.add(NameModel("Amir"))
            names.add(NameModel("Hassan"))
            names.add(NameModel("Abbas"))
            names.add(NameModel("Yashar"))
            mainModelCallback.onDataFetched(names)
        }, 5000)
    }
}

interface MainModelCallback {
    fun onDataFetched(names: ArrayList<NameModel>)
}