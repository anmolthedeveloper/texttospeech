package com.anmolthedeveloper.texttospeech;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anmol Singh on 16-Jan-17.
 */

public class LanguagesForSP {
    List<String> getWorkouts (String workouttypes)
    {
        List <String> lang = new ArrayList<String>();

        if (workouttypes.equals("English"))
        {
            lang.add("English");
        }
        else if (workouttypes.equals("Chinese"))
        {
            lang.add("Chinese");
        }
        return lang;
    }
}
