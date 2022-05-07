package com.example.marketplaceaplo5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailBrowseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailBrowseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PRODUCT_NAME = "Product Name";
    private static final String ARG_PRODUCT_DESCRIPTION = "Product Description";
    private static final String ARG_PRICE = "Price";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    public DetailBrowseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailBrowseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailBrowseFragment newInstance(String param1, String param2, String param3) {
        DetailBrowseFragment fragment = new DetailBrowseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PRODUCT_NAME, param1);
        args.putString(ARG_PRODUCT_DESCRIPTION, param2);
        args.putString(ARG_PRICE, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PRODUCT_NAME);
            mParam2 = getArguments().getString(ARG_PRODUCT_DESCRIPTION);
            mParam3 = getArguments().getString(ARG_PRICE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_browse, container, false);
    }
}