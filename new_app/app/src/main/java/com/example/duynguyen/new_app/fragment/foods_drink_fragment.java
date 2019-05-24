package com.example.duynguyen.new_app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duynguyen.new_app.R;
import com.example.duynguyen.new_app.adapter.adapter_foods_drink;
import com.example.duynguyen.new_app.doi_tuong.doi_tuong_foods_drink;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class foods_drink_fragment extends Fragment {
    private static final String TAG = "FIREBASE";
    private ArrayList<doi_tuong_foods_drink> doituongs = new ArrayList<doi_tuong_foods_drink>();
    private View view;
    private RecyclerView recyclerView;
    private DatabaseReference mFirebaseDatabase;
    private ShimmerFrameLayout shimmerFrameLayout;
    doi_tuong_foods_drink value, value1, value2, value3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_list, container, false);
        shimmerFrameLayout = view.findViewById(R.id.shimmer);
        shimmerFrameLayout.startShimmer();
        setRecyclerView();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference().child("foods");
//        writeFoods("food_1","food_1","Tokbokki Ly - Quán Ăn","https://images.foody.vn/res/g11/102081/prof/s640x400/foody-upload-api-foody-mobile-img_9632-jpg-180824101312.jpg","This app is a simple \"Photo Album Viewer\" that lets the user scroll up and down to view a collection of photos. Each photo, which consists of an image with caption text, is displayed as a row item in the RecyclerView. The Random Pick button randomly swaps a photo in the collection with the first photo to demonstrate how RecyclerView is updated when the data set changes. When the user taps a photo, a toast appears to display the number of the photo within the collection – this demonstrates how item view click handlers work.",1000000,5);
//        writeFoods("food_2","food_2","KoKo Green Kafe","https://images.foody.vn/res/g30/292251/prof/s640x400/foody-upload-api-foody-mobile-koko-green-kafe-jpg-180620103013.jpg","This app is a simple \"Photo Album Viewer\" that lets the user scroll up and down to view a collection of photos. Each photo, which consists of an image with caption text, is displayed as a row item in the RecyclerView. The Random Pick button randomly swaps a photo in the collection with the first photo to demonstrate how RecyclerView is updated when the data set changes. When the user taps a photo, a toast appears to display the number of the photo within the collection – this demonstrates how item view click handlers work.",1000000,5);
//        writeFoods("food_3","food_3","Bò Lê Lết Restaurant","https://firebasestorage.googleapis.com/v0/b/appnew-bbeee.appspot.com/o/burger-chips-dinner-70497.png?alt=media&token=30b20d4d-0390-4f6c-ab52-6b19117cbeae","This app is a simple \"Photo Album Viewer\" that lets the user scroll up and down to view a collection of photos. Each photo, which consists of an image with caption text, is displayed as a row item in the RecyclerView. The Random Pick button randomly swaps a photo in the collection with the first photo to demonstrate how RecyclerView is updated when the data set changes. When the user taps a photo, a toast appears to display the number of the photo within the collection – this demonstrates how item view click handlers work.",1000000,5);
//        writeFoods("food_4","food_4","Faifo Grill & Buffet Restaurant","https://firebasestorage.googleapis.com/v0/b/appnew-bbeee.appspot.com/o/foody-upload-api-foody-mobile-img_9632-jpg-180824101312.jpg?alt=media&token=19e77431-672d-460f-a6e1-89c52640da93","This app is a simple \"Photo Album Viewer\" that lets the user scroll up and down to view a collection of photos. Each photo, which consists of an image with caption text, is displayed as a row item in the RecyclerView. The Random Pick button randomly swaps a photo in the collection with the first photo to demonstrate how RecyclerView is updated when the data set changes. When the user taps a photo, a toast appears to display the number of the photo within the collection – this demonstrates how item view click handlers work.",1000000,5);
        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                   recyclerView.setVisibility(View.VISIBLE);
                   shimmerFrameLayout.stopShimmer();
//                   value  = dataSnapshot.child("foods").child("food_1").getValue(doi_tuong_foods_drink.class);
//                   value1 = dataSnapshot.child("foods").child("food_2").getValue(doi_tuong_foods_drink.class);
//                   value2 = dataSnapshot.child("foods").child("food_3").getValue(doi_tuong_foods_drink.class);
//                   value3 = dataSnapshot.child("foods").child("food_4").getValue(doi_tuong_foods_drink.class);
//                   doituongs.add(value);
//                   doituongs.add(value1);
//                   doituongs.add(value2);
//                   doituongs.add(value3);
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    doituongs.add(dsp.getValue(doi_tuong_foods_drink.class));
                }
                   System.out.println(doituongs.get(0).getTitle());
                   setRecyclerView();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        System.out.println(doituongs.size());
    }
    public void setRecyclerView(){
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        adapter_foods_drink custom_list = new adapter_foods_drink(doituongs, getActivity());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(custom_list);
    }
    private void writeFoods(String userId,String id, String name, String image, String title, double price, double evaluate) {
        doi_tuong_foods_drink user = new doi_tuong_foods_drink(id,name,image,title,price,evaluate);
        mFirebaseDatabase.child(userId).setValue(user);
    }

}
