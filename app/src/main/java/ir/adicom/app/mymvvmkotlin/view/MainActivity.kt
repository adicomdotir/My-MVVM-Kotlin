package ir.adicom.app.mymvvmkotlin.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ir.adicom.app.mymvvmkotlin.datasource.NameModel
import ir.adicom.app.mymvvmkotlin.R
import ir.adicom.app.mymvvmkotlin.view.adapter.NameAdapter
import ir.adicom.app.mymvvmkotlin.viewmodel.MainViewModelCallback
import ir.adicom.app.mymvvmkotlin.databinding.ActivityMainBinding
import ir.adicom.app.mymvvmkotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), MainViewModelCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = NameAdapter(arrayListOf())
        val mainViewModel = MainViewModel(this)
        binding.vm = mainViewModel
        binding.rvNames.layoutManager = LinearLayoutManager(this)
        binding.rvNames.adapter = adapter
        binding.executePendingBindings()
    }

    override fun onDataFetched(names: ArrayList<NameModel>) {
        adapter.reloadData(names)
    }
}
