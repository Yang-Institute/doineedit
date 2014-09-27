package com.yanginstitute.uhack.idontneedit;

/**
 * Created by Lathie on 9/27/14.
 */

import java.net.URLEncoder;
import java.util.ArrayList;
import java.net.URL;


public class Concater {

    private static final String PTCL = "https";
    private static final String HOST = "api.target.com/v2/products/search?searchTerm=";
    private static final String BASE_URL = "https://api.target.com/v2/products/search?searchTerm=";
    private static String searchWord = "";
    private static final String A_KEY = "&key=";
    private static final String KEY = "J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF";


    public Concater(String s){

        searchWord = s;

    }

    public String constructSearchURL() {

        StringBuffer sb = new StringBuffer();
        sb.append(BASE_URL);
        sb.append(URLEncoder.encode(searchWord));
        sb.append(A_KEY);
        sb.append(KEY);
        return sb.toString();
    }

    /*
    public URL constructSearchURL(){



    }
    */


}
