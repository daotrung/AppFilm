package com.daotrung.appfilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.daotrung.appfilm.adapter.BannerMoviePagerAdapter;
import com.daotrung.appfilm.adapter.MainRecyclerAdapter;
import com.daotrung.appfilm.model.AllCategory;
import com.daotrung.appfilm.model.BannerMovie;
import com.daotrung.appfilm.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviePagerAdapter bannerMoviePagerAdapter ;
    TabLayout indicatorTab , categoryTab;
    ViewPager viewPager ;
    List<BannerMovie> homeBannerList ;
    List<BannerMovie> tvShowBannerList ;
    List<BannerMovie> moviesBannerList ;
    List<BannerMovie> kidsBannerList ;
    List<AllCategory> categoryList ;
    RecyclerView recyclerMain ;
    MainRecyclerAdapter mainRecyclerAdapter ;
    NestedScrollView nestedScrollView ;
    AppBarLayout appBarLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.bannerViewPager);
        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout = findViewById(R.id.appbar);


        homeBannerList = new ArrayList<>();

        homeBannerList.add(new BannerMovie(1,"Inception","https://appandroid31082000.000webhostapp.com/film/home/hom1.jpg","https://appandroid3108.000webhostapp.com/video/y2mate.com%20-%20John%20Wick%202014%20All%20Fight%20Scenes%20Edited_360p.mp4"));
        homeBannerList.add(new BannerMovie(2,"Arrow Green","https://appandroid31082000.000webhostapp.com/film/home/hom2.jpg","https://appandroid3108.000webhostapp.com/video/y2mate.com%20-%20John%20Wick%202014%20All%20Fight%20Scenes%20Edited_360p.mp4"));
        homeBannerList.add(new BannerMovie(3,"Heather Massey","https://appandroid31082000.000webhostapp.com/film/home/hom3.jpg","https://appandroid3108.000webhostapp.com/video/y2mate.com%20-%20John%20Wick%202014%20All%20Fight%20Scenes%20Edited_360p.mp4"));
        homeBannerList.add(new BannerMovie(4,"Mamamia","https://appandroid31082000.000webhostapp.com/film/home/hom4.jpeg","https://appandroid3108.000webhostapp.com/video/y2mate.com%20-%20John%20Wick%202014%20All%20Fight%20Scenes%20Edited_360p.mp4"));
        homeBannerList.add(new BannerMovie(5,"Justin Lea","https://appandroid31082000.000webhostapp.com/film/home/hom5.jpg","https://appandroid3108.000webhostapp.com/video/y2mate.com%20-%20John%20Wick%202014%20All%20Fight%20Scenes%20Edited_360p.mp4"));

        tvShowBannerList = new ArrayList<>();

        tvShowBannerList.add(new BannerMovie(1,"Love Island","https://appandroid31082000.000webhostapp.com/film/tv_shows/tv_show_1.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        tvShowBannerList.add(new BannerMovie(2,"Kardashians","https://appandroid31082000.000webhostapp.com/film/tv_shows/tv_show_2.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        tvShowBannerList.add(new BannerMovie(3,"Hell Kitchens","https://appandroid31082000.000webhostapp.com/film/tv_shows/tv_show_3.png","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        tvShowBannerList.add(new BannerMovie(4,"You vs Wild","https://appandroid31082000.000webhostapp.com/film/tv_shows/tv_show_4.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));

        moviesBannerList = new ArrayList<>();

        moviesBannerList.add(new BannerMovie(1,"Stranger Things","https://appandroid31082000.000webhostapp.com/film/movies/movies_1.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        moviesBannerList.add(new BannerMovie(2,"Sex Education","https://appandroid31082000.000webhostapp.com/film/movies/movies_2.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        moviesBannerList.add(new BannerMovie(3,"Dark","https://appandroid31082000.000webhostapp.com/film/movies/movies_3.png","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        moviesBannerList.add(new BannerMovie(4,"Russian Doll 2","https://appandroid31082000.000webhostapp.com/film/movies/movies_4.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        moviesBannerList.add(new BannerMovie(5,"The Queen Gambits","https://appandroid31082000.000webhostapp.com/film/movies/movies_5.jpeg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));

        kidsBannerList = new ArrayList<>();

        kidsBannerList.add(new BannerMovie(1,"Bojack Horseman","https://appandroid31082000.000webhostapp.com/film/kids/kids_1.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        kidsBannerList.add(new BannerMovie(2,"Castlevania","https://appandroid31082000.000webhostapp.com/film/kids/kids_2.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        kidsBannerList.add(new BannerMovie(3,"Big Mouth","https://appandroid31082000.000webhostapp.com/film/kids/kids_3.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        kidsBannerList.add(new BannerMovie(4,"Princess OF Power","https://appandroid31082000.000webhostapp.com/film/kids/kids_4.png","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));
        kidsBannerList.add(new BannerMovie(4,"The Dragon Prince","https://appandroid31082000.000webhostapp.com/film/kids/kids_5.jpg","https://appandroid3108.000webhostapp.com/video/myideo.mp4"));

        setBannerMoviesPagerAdapter(homeBannerList);
        //on tab change selected data
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(moviesBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        List<CategoryItem> homeCategoryListItem1 = new ArrayList<>();
        homeCategoryListItem1.add(new CategoryItem(1,"Red Notice","https://appandroid31082000.000webhostapp.com/film/item/action_1.jpg",""));
        homeCategoryListItem1.add(new CategoryItem(2,"Dont look up","https://appandroid31082000.000webhostapp.com/film/item/action_2.jpg",""));
        homeCategoryListItem1.add(new CategoryItem(3,"Spider man : HomeComing","https://appandroid31082000.000webhostapp.com/film/item/action_3.jpg",""));
        homeCategoryListItem1.add(new CategoryItem(4,"Aquaman","https://appandroid31082000.000webhostapp.com/film/item/action_4.jpg",""));
        homeCategoryListItem1.add(new CategoryItem(5,"Cap doi gian diep","https://appandroid31082000.000webhostapp.com/film/item/action_5.jpg",""));
        homeCategoryListItem1.add(new CategoryItem(3,"Ông bà Smith","https://appandroid31082000.000webhostapp.com/film/item/action_6.jpg",""));
        homeCategoryListItem1.add(new CategoryItem(4,"Nhiệm vụ bất khả thi : Quốc gia bí ẩn","https://appandroid31082000.000webhostapp.com/film/item/action_7.jpg",""));
        homeCategoryListItem1.add(new CategoryItem(5,"Chiến binh bất tử","https://appandroid31082000.000webhostapp.com/film/item/action_8.jpg",""));

        List<CategoryItem> homeCategoryListItem2 = new ArrayList<>();
        homeCategoryListItem2.add(new CategoryItem(1,"Lật mặt 4 : Nhà có khách","https://appandroid31082000.000webhostapp.com/film/item/hai_1.jpg",""));
        homeCategoryListItem2.add(new CategoryItem(2,"Tuyệt đỉnh cung phu","https://appandroid31082000.000webhostapp.com/film/item/hai_2.jpg",""));
        homeCategoryListItem2.add(new CategoryItem(3,"Jumanji : Trò chơi kỳ ảo","https://appandroid31082000.000webhostapp.com/film/item/hai_3.jpg",""));
        homeCategoryListItem2.add(new CategoryItem(4,"Điệp viên không không thấy : Tái xuất","https://appandroid31082000.000webhostapp.com/film/item/hai_4.jpg","https://appandroid3108.000webhostapp.com/video/y2mate.com%20-%20John%20Wick%202014%20All%20Fight%20Scenes%20Edited_360p.mp4"));
        homeCategoryListItem2.add(new CategoryItem(5,"Tình yêu và quái vật","https://appandroid31082000.000webhostapp.com/film/item/hai_5.jpg",""));
        homeCategoryListItem2.add(new CategoryItem(6,"Ông bà Smith","https://appandroid31082000.000webhostapp.com/film/item/action_6.jpg",""));


        List<CategoryItem> homeCategoryListItem3 = new ArrayList<>();
        homeCategoryListItem3.add(new CategoryItem(1,"Mắt biếc","https://appandroid31082000.000webhostapp.com/film/item/romantic_1.jpg",""));
        homeCategoryListItem3.add(new CategoryItem(2,"Lừa đểu gặp lừa đảo","https://appandroid31082000.000webhostapp.com/film/item/romantic_2.jpg",""));
        homeCategoryListItem3.add(new CategoryItem(3,"Chàng vợ của em","https://appandroid31082000.000webhostapp.com/film/item/romantic_3.jpg",""));
        homeCategoryListItem3.add(new CategoryItem(4,"Twilight","https://appandroid31082000.000webhostapp.com/film/item/romantic_4.jpg",""));
        homeCategoryListItem3.add(new CategoryItem(5,"Forest Gump","https://appandroid31082000.000webhostapp.com/film/item/romantic_5.jpg",""));
        homeCategoryListItem3.add(new CategoryItem(3,"Những ngày tươi đẹp","https://appandroid31082000.000webhostapp.com/film/item/romantic_6.jpg",""));
        homeCategoryListItem3.add(new CategoryItem(4,"Bốt hôn","https://appandroid31082000.000webhostapp.com/film/item/romantic_7.jpg",""));

        List<CategoryItem> homeCategoryListItem4 = new ArrayList<>();
        homeCategoryListItem4.add(new CategoryItem(1,"Avatar: Tiết khí sư cuối cùng","https://appandroid31082000.000webhostapp.com/film/item/catton_1.jpg",""));
        homeCategoryListItem4.add(new CategoryItem(2,"Trại kỷ phấn trắng","https://appandroid31082000.000webhostapp.com/film/item/catton_2.jpg",""));
        homeCategoryListItem4.add(new CategoryItem(3,"Nhóc trùm : đi làm lại","https://appandroid31082000.000webhostapp.com/film/item/catton_3.jpg",""));
        homeCategoryListItem4.add(new CategoryItem(4,"Paw Patrol","https://appandroid31082000.000webhostapp.com/film/item/catton_4.jpg",""));
        homeCategoryListItem4.add(new CategoryItem(5,"Đảo ấu trùng","https://appandroid31082000.000webhostapp.com/film/item/catton_5.jpg",""));

        // recycler allcategory
        categoryList = new ArrayList<>();

        categoryList.add(new AllCategory(1,"Action",homeCategoryListItem1));
        categoryList.add(new AllCategory(2,"Comedy",homeCategoryListItem2));
        categoryList.add(new AllCategory(3,"Romantic",homeCategoryListItem3));
        categoryList.add(new AllCategory(4,"Kid and family movies",homeCategoryListItem4));

        setMainRecyclerView(categoryList);

    }

    public void setBannerMoviesPagerAdapter(List<BannerMovie> moviesBannerList){
         viewPager = findViewById(R.id.bannerViewPager);
         bannerMoviePagerAdapter = new BannerMoviePagerAdapter(this,moviesBannerList);
         viewPager.setAdapter(bannerMoviePagerAdapter);
         indicatorTab.setupWithViewPager(viewPager);

         Timer sliderTimer = new Timer();
         sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
         indicatorTab.setupWithViewPager(viewPager);
    }


    public class AutoSlider extends TimerTask{


        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() < homeBannerList.size()-1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    }else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
    public void setMainRecyclerView (List<AllCategory> allCategoryList){
        recyclerMain = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerMain.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        recyclerMain.setAdapter(mainRecyclerAdapter);

    }

    public void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }

}