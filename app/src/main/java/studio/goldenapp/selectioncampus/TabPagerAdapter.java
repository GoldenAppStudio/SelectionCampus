package studio.goldenapp.selectioncampus;

import 	androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import androidx.annotation.Nullable;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    String[] tabArray = new String[]{"Paid Courses","Videos","Exam Quiz","More"};

    Integer tabNumber = 4;


    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabArray[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                four four4 = new four();
                return four4;
            case 1:
                one one1 = new one();
                return one1;
            case 2:
                two two2 = new two();
                return two2;
            case 3:
                three three3 = new three();
                return three3;


        }
        return null;
    }

    @Override
    public int getCount() {
        return tabNumber;
    }
}
