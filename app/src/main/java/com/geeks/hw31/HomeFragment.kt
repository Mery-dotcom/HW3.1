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
        binding.rvArcane.adapter = arcaneAdapter
    }

    private fun loadData() { //для заполнения данных
        arcaneList.clear()
    arcaneList.add(Arcane(name = "Jinx",
        image = "https://www.adrenaline.com.br/wp-content/uploads/2024/04/2a-Temporada-Arcane-tera-final-devastador-Img2-912x569.jpg",
        description = "Героиня научно-фэнтезийной медиафраншизы League of Legends (LoL) от компании Riot Games, дебютировавшая в одноимённой многопользовательской компьютерной игре: в ней Джинкс изображается как маниакальная и импульсивная преступница из подземного города Зауна, которая противостоит своей старшей сестре Вай."))
    arcaneList.add(Arcane(name = "Vi",
        image = "https://i.rutab.net/upload/2024/09/news/683e62d5f285c52fcde721230fb01602.webp",
        description = "Вай опасна, вспыльчива, импульсивна и не признает авторитетов. Она выросла в трущобах Зауна и с детства была предоставлена самой себе, полагаясь лишь на инстинкт выживания, что не могло не отразиться на ее характере и чувстве юмора. Теперь, когда она нашла свое место среди Хранителей Пилтовера, перед мощью ее хекстековых перчаток не устоит ни стена, ни преступник."))
    arcaneList.add(Arcane(name = "Caitlyn Kiramman",
        image = "https://sun9-63.userapi.com/s/v1/ig2/GqCa21nf0UwTzohVwGACAH7mCwoRf9iYjTQxRt9-CnA3-NnrU1i_Pt8jQxkpGGIJpgtJvkTacu1Z6YsWFC7-vhvR.jpg?quality=95&as=32x18,48x26,72x39,108x59,160x88,240x131,360x197,480x263,540x296,640x350,720x394,1080x591,1280x700,1440x788,2560x1401&from=bu&u=uIRDPl1V4puqe3PPvU5TXYh5G4Ocl93dvt6poqphCus&cs=604x331",
        description = "Талантливый миротворец и главная надежда Пилтовера на избавление от неуловимых преступных элементов. Как правило, она работает в паре с Вай, уравновешивая своим хладнокровием вспыльчивый нрав напарницы. Кейтлин владеет единственной в своем роде хекстековой винтовкой, однако самое мощное ее оружие – это превосходный интеллект."))
    arcaneList.add(Arcane(name = "Mel Medarda",
        image = "https://hawk.live/storage/post-images/mel-arcane-15866.jpg",
        description = "Советница из Совета Градоправителей Пилтовера. Богатейшая жительница Пилтовера, «но самая бедная в семье Медарда». Была изгнана из родного клана в Пилтовер, потому что проявила мягкость, пожелав сохранить жизнь принцессе свергнутой правящей семьи."))
    arcaneList.add(Arcane(name = "Jayce",
        image = "https://photobooth.cdn.sports.ru/preset/post/c/d2/7044ca09b494da2827ca48ee71ba9.png?w=730",
        description = "Гениальный изобретатель, который посвятил свою жизнь защите Пилтовера и неустанной погоне за прогрессом. Вооружившись хекстековым молотом-трансформером, Джейс использует свою силу, отвагу и недюжинный ум, чтобы стеречь покой родного города."))
    arcaneList.add(Arcane(name = "Ekko",
        image = "https://www.soyuz.ru/public/uploads/files/6/7639960/202411251740315fa703861d.jpg",
        description = "Юный гений, выросший на суровых улицах Зауна, который манипулирует временем, чтобы обернуть любую ситуацию в свою пользу. С помощью изобретенного им Z-привода он исследует множественные ответвления реальности, чтобы создать идеальный момент."))
    }
}