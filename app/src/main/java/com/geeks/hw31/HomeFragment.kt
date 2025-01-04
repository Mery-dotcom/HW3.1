package com.geeks.hw31

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.hw31.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val arcaneList = arrayListOf<Arcane>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initialize()
    }

    private fun initialize() { //для инициализации адаптера
        val arcaneAdapter = ArcaneAdapter(arcaneList){position: Int ->
            val bundle = Bundle()
            bundle.putSerializable("key", arcaneList[position])
            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment).addToBackStack(null).commit()
        }
        binding.rvArcane.adapter =arcaneAdapter
    }

    private fun loadData() { //для заполнения данных
    arcaneList.add(Arcane(name = "Jinx", image = "https://www.adrenaline.com.br/wp-content/uploads/2024/04/2a-Temporada-Arcane-tera-final-devastador-Img2-912x569.jpg"))
    arcaneList.add(Arcane(name = "Vi", image = "https://i.rutab.net/upload/2024/09/news/683e62d5f285c52fcde721230fb01602.webp"))
    arcaneList.add(Arcane(name = "Caitlyn Kiramman", image = "https://sun9-63.userapi.com/s/v1/ig2/GqCa21nf0UwTzohVwGACAH7mCwoRf9iYjTQxRt9-CnA3-NnrU1i_Pt8jQxkpGGIJpgtJvkTacu1Z6YsWFC7-vhvR.jpg?quality=95&as=32x18,48x26,72x39,108x59,160x88,240x131,360x197,480x263,540x296,640x350,720x394,1080x591,1280x700,1440x788,2560x1401&from=bu&u=uIRDPl1V4puqe3PPvU5TXYh5G4Ocl93dvt6poqphCus&cs=604x331"))
    arcaneList.add(Arcane(name = "Mel Medarda", image = "https://hawk.live/storage/post-images/mel-arcane-15866.jpg"))
    arcaneList.add(Arcane(name = "Jayce", image = "https://photobooth.cdn.sports.ru/preset/post/c/d2/7044ca09b494da2827ca48ee71ba9.png?w=730"))
    arcaneList.add(Arcane(name = "Ekko", image = "https://www.soyuz.ru/public/uploads/files/6/7639960/202411251740315fa703861d.jpg"))
    }
}