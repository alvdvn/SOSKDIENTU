package com.example.soskdientu.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.soskdientu.R;


public class TraCuuBaoHiemFragment extends Fragment {







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_tra_cuu_bao_hiem, container, false);
        WebView webView =(WebView) view.findViewById(R.id.web1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient( new WebViewClient());
        webView.loadUrl("https://baohiemxahoi.gov.vn/tracuu/pages/tra-cuu-thoi-han-su-dung-the-bhyt.aspx?fbclid=IwAR0bWEKWU_aLFs-b1diRohM8c5W-2Mvq11THrVsdetnDO5uMihB2n_3sxhg");
        return view;
    }
}